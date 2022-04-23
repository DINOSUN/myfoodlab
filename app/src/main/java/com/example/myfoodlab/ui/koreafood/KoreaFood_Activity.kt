package com.example.myfoodlab.ui.koreafood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myfoodlab.CardMenu_Jumokbab
import com.example.myfoodlab.R
import com.example.myfoodlab.Scan_Ai
import com.example.myfoodlab.Search
import kotlinx.android.synthetic.main.activity_korea_food.*

class KoreaFood_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_korea_food)

        jumokbap.setOnClickListener {
            val intent = Intent (this, CardMenu_Jumokbab::class.java)
            startActivity(intent)
        }

        button_koreafood.setOnClickListener {
            val intent = Intent(this, Search::class.java)
            startActivity(intent)
        }

        scan_koreafood.setOnClickListener {
            val intent = Intent (this, Scan_Ai::class.java)
            startActivity(intent)
        }
    }
}