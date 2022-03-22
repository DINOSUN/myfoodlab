package com.example.myfoodlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_one_dish_random.*
import kotlinx.android.synthetic.main.activity_one_dish_random.DataTxt1
import kotlinx.android.synthetic.main.activity_one_dish_random.DataTxt2
import kotlinx.android.synthetic.main.activity_one_dish_random.DataTxt3
import kotlinx.android.synthetic.main.activity_one_dish_random.RandomImage
import kotlinx.android.synthetic.main.activity_one_dish_random.RandomName
import kotlinx.android.synthetic.main.activity_one_dish_random.randomBtn
import kotlinx.android.synthetic.main.activity_puff_random.*

import kotlin.random.Random

class OneDish_Random : AppCompatActivity() {

    val RandomSet3 = arrayOf(
        RandomModal("ไข่ตุ๋น","ไข่ไก่","ปูอัด","กุ้ง","180 Kcal","6",R.drawable.eggwithmincedpork),
        RandomModal("จูม็อกบับ","สาหร่าย","ข้าวญี่ปุ่น","มายองเนส","400","7",R.drawable.jumokbap),
        RandomModal("ไก่ทอดเกาหลี","ปีกไก่","แป้งทอด","งา","292 Kcal","17",R.drawable.koreanfriedchicken),
        RandomModal("โอโคโน มิยากิ","กะหล่ำปลี","แป้งฮาคุริกิ","ปลาแห้ง","380","9",R.drawable.okonomiyaki)
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