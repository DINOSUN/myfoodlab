package com.example.myfoodlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_card_menu_tomyumkung.*

class CardMenu_Tomyumkung : AppCompatActivity() {

    lateinit var layout_constraint_tomyumkung: ConstraintLayout
    lateinit var scan_tomyumkung: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_menu_tomyumkung)

        layout_constraint_tomyumkung = findViewById<ConstraintLayout>(R.id.layout_constraint_tomyumkung)
        scan_tomyumkung = findViewById<ImageView>(R.id.scan_tomyumkung)


        layout_constraint_tomyumkung.setOnClickListener {
            val gotoMainMenu = Intent(this, Search::class.java)
            startActivity(gotoMainMenu)
        }

        scan_tomyumkung.setOnClickListener {
            val gotoMainMenu = Intent(this, Scan_Ai::class.java)
            startActivity(gotoMainMenu)
        }
    }
}