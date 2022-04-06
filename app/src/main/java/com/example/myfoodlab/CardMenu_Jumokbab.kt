package com.example.myfoodlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout

class CardMenu_Jumokbab : AppCompatActivity() {

    lateinit var layout_constraint_jumokbabab: ConstraintLayout
    lateinit var scan_jumokbab: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_menu_jumokbab)

        layout_constraint_jumokbabab = findViewById<ConstraintLayout>(R.id.layout_constraint_jumokbabab)
        scan_jumokbab = findViewById<ImageView>(R.id.scan_jumokbab)


        layout_constraint_jumokbabab.setOnClickListener {
            val gotoMainMenu = Intent(this, Search::class.java)
            startActivity(gotoMainMenu)
        }

        scan_jumokbab.setOnClickListener {
            val gotoMainMenu = Intent(this, Scan_Ai::class.java)
            startActivity(gotoMainMenu)
        }


    }
}