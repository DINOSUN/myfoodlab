package com.example.myfoodlab.ui.japan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myfoodlab.CardMenu_PoachedEggs
import com.example.myfoodlab.R
import com.example.myfoodlab.Scan_Ai
import com.example.myfoodlab.Search
import kotlinx.android.synthetic.main.activity_japan_food.*

class JapanFood_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_japan_food)

        steamedeggs.setOnClickListener {
            val intent = Intent (this, CardMenu_PoachedEggs::class.java)
            startActivity(intent)
        }

        button_japan_food.setOnClickListener {
            val intent = Intent(this, Search::class.java)
            startActivity(intent)
        }

        scan_japanfood.setOnClickListener {
            val intent = Intent (this, Scan_Ai::class.java)
            startActivity(intent)
        }
    }
}