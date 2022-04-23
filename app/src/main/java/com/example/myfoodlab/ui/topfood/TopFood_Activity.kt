package com.example.myfoodlab.ui.topfood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myfoodlab.CardMenu_SweetandSour
import com.example.myfoodlab.R
import com.example.myfoodlab.Scan_Ai
import com.example.myfoodlab.Search
import kotlinx.android.synthetic.main.activity_top_food.*

class TopFood_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_food)

        sweetandsourpork.setOnClickListener {
            val intent = Intent (this, CardMenu_SweetandSour::class.java)
            startActivity(intent)
        }

        button_topfood.setOnClickListener {
            val intent = Intent(this, Search::class.java)
            startActivity(intent)
        }

        scan_topfood.setOnClickListener {
            val intent = Intent (this, Scan_Ai::class.java)
            startActivity(intent)
        }
    }
}