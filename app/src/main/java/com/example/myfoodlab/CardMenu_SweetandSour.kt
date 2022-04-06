package com.example.myfoodlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout

class CardMenu_SweetandSour : AppCompatActivity() {

    lateinit var layout_constraint_sweetandsour: ConstraintLayout
    lateinit var scan_sweetandsour: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_menu_sweetand_sour)

        layout_constraint_sweetandsour = findViewById<ConstraintLayout>(R.id.layout_constraint_sweetandsour)
        scan_sweetandsour = findViewById<ImageView>(R.id.scan_sweetandsour)


        layout_constraint_sweetandsour.setOnClickListener {
            val gotoMainMenu = Intent(this, Search::class.java)
            startActivity(gotoMainMenu)
        }

        scan_sweetandsour.setOnClickListener {
            val gotoMainMenu = Intent(this, Scan_Ai::class.java)
            startActivity(gotoMainMenu)
        }
    }
}