package com.example.myfoodlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout

class CardMenu_PoachedEggs : AppCompatActivity() {

    lateinit var layout_constraint_poachedegg: ConstraintLayout
    lateinit var scan_poachedeggs: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_menu_poached_eggs)

        layout_constraint_poachedegg = findViewById<ConstraintLayout>(R.id.layout_constraint_poachedegg)
        scan_poachedeggs = findViewById<ImageView>(R.id.scan_poachedeggs)


        layout_constraint_poachedegg.setOnClickListener {
            val gotoMainMenu = Intent(this, Search::class.java)
            startActivity(gotoMainMenu)
        }

        scan_poachedeggs.setOnClickListener {
            val gotoMainMenu = Intent(this, Scan_Ai::class.java)
            startActivity(gotoMainMenu)
        }

    }
}