package com.jimena.pm_l6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.content.Intent
import android.widget.Button



class MainActivity : AppCompatActivity() {
    private lateinit var bottomNav: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNav = findViewById(R.id.bottomNav_bottomNavActivity)
        setCurrentFragment(Home())
        setListeners()
    }

    private fun setListeners() {
        bottomNav.setOnItemSelectedListener {
            // Dependiendo el item del menu, mostramos el fragment deseado
            when(it.itemId) {
                R.id.item_home -> setCurrentFragment(Home.newInstance("Jimena","Hernandez"))
                R.id.item_search -> setCurrentFragment(Search())
                R.id.item_library -> setCurrentFragment(Library())
            }
            true
        }

    }

    /**
     * Función que reemplaza el fragment actual. No usamos backstack porque
     * para este tipo de navegación, no es el comportamiento esperado.
     */
    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fragmentContainer_bottomNavActivity, fragment)
        }
    }
}