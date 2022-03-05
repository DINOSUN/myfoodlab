package com.example.myfoodlab.ui.italianfood

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myfoodlab.CardMenu_PoachedEggs
import com.example.myfoodlab.CardMenu_Spaghetti_Carbonara
import com.example.myfoodlab.R
import kotlinx.android.synthetic.main.fragment_italian_food.view.*
import kotlinx.android.synthetic.main.fragment_japan_food.view.*

class ItalianFoodFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root =  inflater.inflate(R.layout.fragment_italian_food, container, false)

        root.spaghetticarbonara.setOnClickListener {
            val intent = Intent (activity, CardMenu_Spaghetti_Carbonara::class.java)
            startActivity(intent)
        }

        return root
    }
}