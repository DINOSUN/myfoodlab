package com.example.myfoodlab.ui.japan

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myfoodlab.*
import kotlinx.android.synthetic.main.fragment_japan_food.view.*
import kotlinx.android.synthetic.main.fragment_koreafood.view.*


class JapanFoodFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_japan_food, container, false)

        root.steamedeggs.setOnClickListener {
            val intent = Intent (activity, CardMenu_PoachedEggs::class.java)
            startActivity(intent)
        }

        root.button_japan_food.setOnClickListener {
            val intent = Intent(activity, Search::class.java)
            startActivity(intent)
        }

        root.scan_japanfood.setOnClickListener {
            val intent = Intent (activity, Scan_Ai::class.java)
            startActivity(intent)
        }

        return root
    }

}