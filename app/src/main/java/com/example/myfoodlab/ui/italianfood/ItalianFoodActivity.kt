package com.example.myfoodlab.ui.italianfood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myfoodlab.CardMenu_Spaghetti_Carbonara
import com.example.myfoodlab.R
import com.example.myfoodlab.Scan_Ai
import com.example.myfoodlab.Search
import kotlinx.android.synthetic.main.activity_italian_food.*

class ItalianFoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_italian_food)

        spaghetticarbonara.setOnClickListener {
            val intent = Intent (this, CardMenu_Spaghetti_Carbonara::class.java)
            startActivity(intent)
        }

        button_italianfood.setOnClickListener {
            val intent = Intent(this, Search::class.java)
            startActivity(intent)
        }

        scan_ltalianfood.setOnClickListener {
            val intent = Intent (this, Scan_Ai::class.java)
            startActivity(intent)
        }
    }
}