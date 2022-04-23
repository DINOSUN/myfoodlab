/*
package com.example.myfoodlab.ui.koreafood

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myfoodlab.*
import kotlinx.android.synthetic.main.fragment_italian_food.view.*
import kotlinx.android.synthetic.main.fragment_koreafood.view.*
import kotlinx.android.synthetic.main.fragment_thaifood.view.*

class koreafoodFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root =  inflater.inflate(R.layout.fragment_koreafood, container, false)

        root.jumokbap.setOnClickListener {
            val intent = Intent (activity, CardMenu_Jumokbab::class.java)
            startActivity(intent)
        }

        root.button_koreafood.setOnClickListener {
            val intent = Intent(activity, Search::class.java)
            startActivity(intent)
        }

        root.scan_koreafood.setOnClickListener {
            val intent = Intent (activity, Scan_Ai::class.java)
            startActivity(intent)
        }

        return root
    }
}*/
