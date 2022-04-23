package com.example.myfoodlab.ui.topfood_korea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myfoodlab.R
import com.example.myfoodlab.Scan_Ai
import com.example.myfoodlab.Search
import kotlinx.android.synthetic.main.activity_top_food_korea.*


class TopFoodKorea_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_food_korea)

        button_topfood_korea.setOnClickListener {
            val intent = Intent(this, Search::class.java)
            startActivity(intent)
        }

        scan_topkorea.setOnClickListener {
            val intent = Intent (this, Scan_Ai::class.java)
            startActivity(intent)
        }
    }
}