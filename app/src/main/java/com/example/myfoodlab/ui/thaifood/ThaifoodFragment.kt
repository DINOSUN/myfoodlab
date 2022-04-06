package com.example.myfoodlab.ui.thaifood

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myfoodlab.CardMenu_Tomyumkung
import com.example.myfoodlab.R
import com.example.myfoodlab.Scan_Ai
import com.example.myfoodlab.Search
import kotlinx.android.synthetic.main.fragment_home_menu.view.*
import kotlinx.android.synthetic.main.fragment_thaifood.*
import kotlinx.android.synthetic.main.fragment_thaifood.view.*

class ThaifoodFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_thaifood, container, false)

        root.tomyumkung.setOnClickListener {
            val intent = Intent (activity, CardMenu_Tomyumkung::class.java)
            startActivity(intent)
        }

        root.button_thaifood.setOnClickListener {
            val intent = Intent(activity, Search::class.java)
            startActivity(intent)
        }

        root.scan_thaifood.setOnClickListener {
            val intent = Intent (activity, Scan_Ai::class.java)
            startActivity(intent)
        }
        return root
    }
}