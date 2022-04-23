/*
package com.example.myfoodlab.ui.topfood_korea

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myfoodlab.R
import com.example.myfoodlab.Scan_Ai
import com.example.myfoodlab.Search
import kotlinx.android.synthetic.main.fragment_topfood__clean.view.*
import kotlinx.android.synthetic.main.fragment_topfood__clean.view.button_topfood_clean
import kotlinx.android.synthetic.main.fragment_topfood__korea.view.*


class Topfood_KoreaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_topfood__korea, container, false)

        root.button_topfood_korea.setOnClickListener {
            val intent = Intent(activity, Search::class.java)
            startActivity(intent)
        }

        root.scan_topkorea.setOnClickListener {
            val intent = Intent (activity, Scan_Ai::class.java)
            startActivity(intent)
        }

        return root
    }
}*/
