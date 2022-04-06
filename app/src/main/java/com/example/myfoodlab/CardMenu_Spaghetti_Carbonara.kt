package com.example.myfoodlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout

class CardMenu_Spaghetti_Carbonara : AppCompatActivity() {

    lateinit var layout_constraint_spaghetti_Carbonara: ConstraintLayout
    lateinit var scan_spaghetti: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_menu_spaghetti)

        layout_constraint_spaghetti_Carbonara = findViewById<ConstraintLayout>(R.id.layout_constraint_spaghetti_Carbonara)
        scan_spaghetti = findViewById<ImageView>(R.id.scan_spaghetti)

        layout_constraint_spaghetti_Carbonara.setOnClickListener {
            val gotoMainMenu = Intent(this, Search::class.java)
            startActivity(gotoMainMenu)
        }

        scan_spaghetti.setOnClickListener {
            val gotoMainMenu = Intent(this, Scan_Ai::class.java)
            startActivity(gotoMainMenu)
        }
    }
}