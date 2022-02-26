package com.example.myfoodlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_one_dish_random.*

import kotlin.random.Random

class OneDish_Random : AppCompatActivity() {

    val RandomSet3 = arrayOf(
        RandomModal("ผงซุปตาชิ","ไข่ไก่","ปูอัด","หมูสับ",R.drawable.eggwithmincedpork),
        RandomModal("ทูน่า","สาหร่าย","ข้าวญี่ปุ่น","มายองชีส",R.drawable.jumokbap),
        RandomModal("โคจูจัง","ปีกไก่","แป้งทอด","งา",R.drawable.koreanfriedchicken),
        RandomModal("ปลาแห้ง","กะหล่ำปลี","แป้งฮาคุริกิ","ซอสมะเขือเทศ",R.drawable.okonomiyaki)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_dish_random)


        randomBtn.setOnClickListener {
            val random = Random
            val randomFood = random.nextInt(RandomSet3.count())

            RandomName.text= RandomSet3[randomFood].Name
            DataTxt1.text=RandomSet3[randomFood].Desc1
            DataTxt2.text=RandomSet3[randomFood].Desc2
            DataTxt3.text=RandomSet3[randomFood].Desc3
            RandomImage.setImageResource(RandomSet3[randomFood].Images)
        }
    }
}