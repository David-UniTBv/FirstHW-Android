package com.example.homework1
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homework1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Determine the current screen orientation
        val orientation = resources.configuration.orientation

        // Inflate the appropriate layout based on screen orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
        } else {
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
        }

        // Display AnimalListFragment in fragment_container_1
        supportFragmentManager.beginTransaction().apply {
            replace(binding.fragmentContainer1.id, AnimalListFragment())
            commit()
        }

        // Hide AnimalDetailsFragment initially
        supportFragmentManager.beginTransaction().apply {
            replace(binding.fragmentContainer2.id, AnimalDetailsFragment())
            commit()
        }

        // Set click listener for the close button
        binding.closeButton.setOnClickListener {
            finishAndRemoveTask() // Close all activities associated with the application
        }
    }
}
