package com.example.homework1
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import Animal

class AnimalListAdapter(
    private val animalList: List<Animal>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(animal: Animal)
    }

    companion object {
        const val AFRICA_VIEW_TYPE = 1
        const val ASIA_VIEW_TYPE = 2
        const val EUROPE_VIEW_TYPE = 3
        const val NORTH_AMERICA_VIEW_TYPE = 4
        const val SOUTH_AMERICA_VIEW_TYPE = 5
        const val AUSTRALIA_VIEW_TYPE = 6
        const val ANTARCTICA_VIEW_TYPE = 7
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            AFRICA_VIEW_TYPE -> ContinentViewHolder(inflater.inflate(R.layout.item_africa, parent, false))
            ASIA_VIEW_TYPE -> ContinentViewHolder(inflater.inflate(R.layout.item_asia, parent, false))
            EUROPE_VIEW_TYPE -> ContinentViewHolder(inflater.inflate(R.layout.item_europa, parent, false))
            NORTH_AMERICA_VIEW_TYPE -> ContinentViewHolder(inflater.inflate(R.layout.item_america_nord, parent, false))
            SOUTH_AMERICA_VIEW_TYPE -> ContinentViewHolder(inflater.inflate(R.layout.item_america_sud, parent, false))
            AUSTRALIA_VIEW_TYPE -> ContinentViewHolder(inflater.inflate(R.layout.item_australia, parent, false))
            ANTARCTICA_VIEW_TYPE -> ContinentViewHolder(inflater.inflate(R.layout.item_antarctica, parent, false))
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val animal = animalList[position]
        (holder as ContinentViewHolder).bind(animal)
        holder.itemView.setOnClickListener {
            listener.onItemClick(animal)
        }
    }



    override fun getItemViewType(position: Int): Int {
        val continent = animalList[position].continent
        return when (continent) {
            "Africa" -> AFRICA_VIEW_TYPE
            "Asia" -> ASIA_VIEW_TYPE
            "Europa" -> EUROPE_VIEW_TYPE
            "America de Nord" -> NORTH_AMERICA_VIEW_TYPE
            "America de Sud" -> SOUTH_AMERICA_VIEW_TYPE
            "Australia" -> AUSTRALIA_VIEW_TYPE
            "Antarctica" -> ANTARCTICA_VIEW_TYPE
            else -> throw IllegalArgumentException("Invalid continent")
        }
    }



    override fun getItemCount(): Int {
        return animalList.size
    }

    inner class ContinentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.name_text_view)
        val continentTextView: TextView = itemView.findViewById(R.id.continent_text_view)

        fun bind(animal: Animal) {
            nameTextView.text = animal.name
            continentTextView.text = animal.continent
        }
    }


}
