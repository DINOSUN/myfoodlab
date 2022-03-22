package com.example.myfoodlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_boiled_random.*
import kotlin.random.Random

class Boiled_Random : AppCompatActivity(){

    val RandomSet1 = arrayOf(
        RandomModal("ต้มยำอกไก่ใส่เห็ด", "อกไก่","เครื่องต้มยำ","พริกขี้หนู","874 Kcal","10", R.drawable.tomyumchicken),
        RandomModal("ต้มยำกุ้ง", "กุ้ง","ใบมะกรูด","ตะไคร้","874 Kcal","", R.drawable.tomyumkung),
        RandomModal("สุกี้ยากี้น้ำดำ", "มิริน","สาเก","คิคโคแมน","625","12", R.drawable.sukiyaki),
        RandomModal("ซุปกิมจิ", "กิมจิ","ผัก","โคชูจัง","894 Kcal","12", R.drawable.kimchisoup),
        RandomModal("บูเดจิเก", "บะหมี่เกาหลี","กิมจิ","โคชูจัง","639 Kcal","7", R.drawable.budaejjigae)
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boiled_random)

        randomBtn.setOnClickListener {
            val random = Random
            val randomFood = random.nextInt(RandomSet1.count())

            RandomName.text= RandomSet1[randomFood].Name
            DataTxt1.text=RandomSet1[randomFood].Desc1
            DataTxt2.text=RandomSet1[randomFood].Desc2
            DataTxt3.text=RandomSet1[randomFood].Desc3
            txtCalorieRandom.text=RandomSet1[randomFood].caloreis
            txtnameIngradientSearch.text=RandomSet1[randomFood].ingredient
            RandomImage.setImageResource(RandomSet1[randomFood].Images)
        }
    }
}