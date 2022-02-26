package com.example.myfoodlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pad_random.*
import kotlin.random.Random

class Pad_Random : AppCompatActivity() {

    val RandomSet2 = arrayOf(
        RandomModal("ผัดไทยกุ้งสด","กุ้ง","ไข่ไก่","ใบกุ่ยช่าย",R.drawable.padthai),
        RandomModal("ผัดหอยลาย","พริกขี้หนู","โหระพา","หอยลาย",R.drawable.stirfriedclams),
        RandomModal("หมูผัดกิมจิ","โคชูจัง","เนื้อหมู","กิมจิ",R.drawable.friedporkkimchi),
        RandomModal("พริกแกงหมู","หมู","ใบมะกรูด","ถั่วฝักยาว",R.drawable.pickkangmoo),
        RandomModal("ผัดเปรี้ยวหวานหมู","เนือหมู","สับปะรด","พริกหยวก",R.drawable.sweetandsourpork)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pad_random)

        randomBtn.setOnClickListener {
            val random = Random
            val randomFood = random.nextInt(RandomSet2.count())

            RandomName.text = RandomSet2[randomFood].Name
            DataTxt1.text = RandomSet2[randomFood].Desc1
            DataTxt2.text = RandomSet2[randomFood].Desc2
            DataTxt3.text = RandomSet2[randomFood].Desc3
            RandomImage.setImageResource(RandomSet2[randomFood].Images)
        }
    }
}