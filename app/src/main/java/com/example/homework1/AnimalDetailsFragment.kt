package com.example.homework1
import Animal
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import org.jetbrains.annotations.NotNull

//ca sa fac din string "@color/continent" in culoare
import android.content.res.Resources
import android.graphics.Color
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

class AnimalDetailsFragment : Fragment() {

    companion object {
        fun newInstance(animalName: String, continent: String): AnimalDetailsFragment {
            val fragment = AnimalDetailsFragment()
            val args = Bundle()
            args.putString("animalName", animalName)
            args.putString("continent", continent)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_animal_details, container, false)

        // Afișează detaliile animalului selectat
        val bundle = arguments
        if (bundle != null) {
            val animalName = bundle.getString("animalName")
            val continent = bundle.getString("continent")
            val backgroundColor = getBackgroundColor(continent)

            // Setează numele și continentul
            val nameTextView = view.findViewById<TextView>(R.id.name_text_view)
            val continentTextView = view.findViewById<TextView>(R.id.continent_text_view)
            nameTextView.text = animalName
            continentTextView.text = continent

            val colorResName = backgroundColor.substring(1) // Remove the "@"
            val resourceId = resources.getIdentifier(colorResName, "color", requireActivity().packageName)
            val colorInt = ContextCompat.getColor(requireContext(), resourceId) // Use ContextCompat to get the color integer value
            view.setBackgroundColor(colorInt)
        }

        return view
    }

    // Metodă pentru a obține culoarea de fundal corespunzătoare în funcție de continent
    private fun getBackgroundColor(continent: String?): String {

        return when (continent) {
            "Africa" -> "@color/africa"
            "Asia" -> "@color/asia"
            "Europa" -> "@color/europa"
            "America de Nord" -> "@color/america_nord"
            "America de Sud" -> "@color/america_sud"
            "Australia" -> "@color/australia"
            "Antarctica" -> "@color/antarctica"
            else -> throw IllegalArgumentException("Invalid continent")
        }

    }
}
