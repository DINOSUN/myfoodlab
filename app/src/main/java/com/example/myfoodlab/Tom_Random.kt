package com.example.myfoodlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tom_random.*
import kotlin.random.Random

class Tom_Random : AppCompatActivity(){

    val RandomSet1 = arrayOf(
        RandomModal("ต้มยำอกไก่ใส่เห็ด", "อกไก่","เครื่องต้มยำ","พริกขี้หนู", R.drawable.tomyumchicken),
        RandomModal("ต้มยำกุ้ง", "กุ้ง","ใบมะกรูด","ตะไคร้", R.drawable.tomyumkung),
        RandomModal("สุกี้ยากี้น้ำดำ", "มิริน","สาเก","คิคโคแมน", R.drawable.sukiyaki),
        RandomModal("ซุปกิมจิ", "กิมจิ","ผัก","โคชูจัง", R.drawable.kimchisoup),
        RandomModal("บูเดจิเก", "บะหมี่เกาหลี","โคชูจัง","โคชูจัง", R.drawable.budaejjigae)
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tom_random)

        randomBtn.setOnClickListener {
            val random = Random
            val randomFood = random.nextInt(RandomSet1.count())

            RandomName.text= RandomSet1[randomFood].Name
            DataTxt1.text=RandomSet1[randomFood].Desc1
            DataTxt2.text=RandomSet1[randomFood].Desc2
            DataTxt3.text=RandomSet1[randomFood].Desc3
            RandomImage.setImageResource(RandomSet1[randomFood].Images)
        }
    }
}