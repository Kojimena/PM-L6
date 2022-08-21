package com.jimena.pm_l6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import android.widget.TextView


/**
 * A simple [Fragment] subclass.
 * Use the [Library.newInstance] factory method to
 * create an instance of this fragment.
 */
class Library : Fragment(R.layout.fragment_library) {
    private lateinit var buttonCount: ImageView
    private lateinit var numberofsongs: TextView
    private var count = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonCount = view.findViewById(R.id.sumarcanciones)
        numberofsongs = view.findViewById(R.id.numberofsongs)
        setListeners()
    }

    override fun onResume() {
        super.onResume()
        numberofsongs.text = count.toString()
    }

    private fun setListeners() {
        buttonCount.setOnClickListener {
            count++
            numberofsongs.text = count.toString()
        }
    }
}