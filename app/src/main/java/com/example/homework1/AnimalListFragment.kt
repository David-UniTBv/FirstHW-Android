package com.example.homework1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import Animal


class AnimalListFragment : Fragment(), AnimalListAdapter.OnItemClickListener {

    private lateinit var animalList: ArrayList<Animal>
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AnimalListAdapter

    interface AnimalSelectionListener {
        fun onAnimalSelected(animalName: String, continent: String)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_animal_list, container, false)

        // Initializare lista de animale
        animalList = ArrayList()
        populateAnimalList()

        // Initializare RecyclerView
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = AnimalListAdapter(animalList, this)
        recyclerView.adapter = adapter

        return view
    }

    override fun onItemClick(animal: Animal) {
        // Deschideți AnimalDetailsFragment și trimiteți detalii despre animalul selectat
        val fragmentManager = parentFragmentManager
        val transaction = fragmentManager.beginTransaction()
        val fragment = AnimalDetailsFragment.newInstance(animal.name, animal.continent)
        transaction.replace(R.id.fragment_container_2, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    // Metoda pentru popularea listei de animale
    private fun populateAnimalList() {
        val animals = listOf(
            Animal("Leu", "Africa"),
            Animal("Elefant", "Africa"),
            Animal("Girafă", "Africa"),
            Animal("Hipopotam", "Africa"),
            Animal("Ghepard", "Africa"),
            Animal("Zebra", "Africa"),
            Animal("Vulpe", "Africa"),
            Animal("Struț", "Africa"),
            Animal("Bivol", "Africa"),
            Animal("Bufniță", "Africa"),
            Animal("Panda", "Asia"),
            Animal("Tigru", "Asia"),
            Animal("Leopard Zăpadă", "Asia"),
            Animal("Panda Roșie", "Asia"),
            Animal("Orangutan", "Asia"),
            Animal("Elefant Indian", "Asia"),
            Animal("Cobra", "Asia"),
            Animal("Lemur", "Asia"),
            Animal("Rinocer Indian", "Asia"),
            Animal("Papagal", "Asia"),
            Animal("Cangur", "Australia"),
            Animal("Koala", "Australia"),
            Animal("Cangur Roșu", "Australia"),
            Animal("Ornitorinc", "Australia"),
            Animal("Kangaroo Island Emu", "Australia"),
            Animal("Wombat", "Australia"),
            Animal("Quokka", "Australia"),
            Animal("Dingo", "Australia"),
            Animal("Kookaburra", "Australia"),
            Animal("Platypus", "Australia"),
            Animal("Urs Grizzly", "America de Nord"),
            Animal("Vultur Pleșuv", "America de Nord"),
            Animal("Urs Negru", "America de Nord"),
            Animal("Bizon", "America de Nord"),
            Animal("Bursuc", "America de Nord"),
            Animal("Veveriță", "America de Nord"),
            Animal("Coyote", "America de Nord"),
            Animal("Jaguarundis", "America de Nord"),
            Animal("Veveriță", "America de Nord"),
            Animal("Elan", "America de Nord"),
            Animal("Puma", "America de Sud"),
            Animal("Jaguar", "America de Sud"),
            Animal("Audis", "America de Sud"),
            Animal("Lama", "America de Sud"),
            Animal("Armadillo", "America de Sud"),
            Animal("Anaconda", "America de Sud"),
            Animal("Toucan", "America de Sud"),
            Animal("Tapir", "America de Sud"),
            Animal("Sloth", "America de Sud"),
            Animal("Capybara", "America de Sud"),
            Animal("Urs Polar", "Antarctica"),
            Animal("Pinguin Împărat", "Antarctica"),
            Animal("Focă Weddell", "Antarctica"),
            Animal("Orca", "Antarctica"),
            Animal("Albatross", "Antarctica"),
            Animal("Leopard de mare", "Antarctica"),
            Animal("Pingwin Papua", "Antarctica"),
            Animal("Balena", "Antarctica"),
            Animal("Păsări Petrel", "Antarctica"),
            Animal("Morse", "Antarctica"),
            Animal("Urs Brun", "Europa"),
            Animal("Cioară", "Europa"),
            Animal("Lup", "Europa"),
            Animal("Bursuc", "Europa"),
            Animal("Păun", "Europa"),
            Animal("Jder", "Europa"),
            Animal("Rățuște", "Europa"),
            Animal("Bufniță", "Europa"),
            Animal("Căprioară", "Europa"),
            Animal("Bursuc", "Europa")
        )

// Shuffle animals
        val shuffledAnimals = animals.shuffled()

// Add shuffled animals to animalList
        animalList.addAll(shuffledAnimals)
    }
}
