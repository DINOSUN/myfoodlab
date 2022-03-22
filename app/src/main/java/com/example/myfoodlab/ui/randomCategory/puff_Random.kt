package com.example.myfoodlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_boiled_random.*
import kotlinx.android.synthetic.main.activity_puff_random.*
import kotlinx.android.synthetic.main.activity_puff_random.DataTxt1
import kotlinx.android.synthetic.main.activity_puff_random.DataTxt2
import kotlinx.android.synthetic.main.activity_puff_random.DataTxt3
import kotlinx.android.synthetic.main.activity_puff_random.RandomImage
import kotlinx.android.synthetic.main.activity_puff_random.RandomName
import kotlinx.android.synthetic.main.activity_puff_random.randomBtn
import kotlinx.android.synthetic.main.activity_puff_random.txtCalorieRandom
import kotlinx.android.synthetic.main.activity_puff_random.txtnameIngradientSearch
import kotlin.random.Random

class puff_Random : AppCompatActivity() {

    val RandomSet2 = arrayOf(
        RandomModal("ผัดไทยกุ้งสด","กุ้ง","ไข่ไก่","ใบกุ่ยช่าย","486 Kcal","11",R.drawable.padthai),
        RandomModal("ผัดหอยลาย","พริกขี้หนู","โหระพา","หอยลาย","200 Kcal","13",R.drawable.stirfriedclams),
        RandomModal("หมูผัดกิมจิ","โคชูจัง","เนื้อหมู","กิมจิ","1395 Kcal","9",R.drawable.friedporkkimchi),
        RandomModal("พริกแกงหมู","หมู","ใบมะกรูด","ถั่วฝักยาว","440 Kcal","8",R.drawable.pickkangmoo),
        RandomModal("ผัดเปรี้ยวหวานหมู","เนือหมู","สับปะรด","พริกหยวก","180 Kcal","13",R.drawable.sweetandsourpork)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_puff_random)

        randomBtn.setOnClickListener {
            val random = Random
            val randomFood = random.nextInt(RandomSet2.count())

            RandomName.text = RandomSet2[randomFood].Name
            DataTxt1.text = RandomSet2[randomFood].Desc1
            DataTxt2.text = RandomSet2[randomFood].Desc2
            DataTxt3.text = RandomSet2[randomFood].Desc3
            txtCalorieRandom.text=RandomSet2[randomFood].caloreis
            txtnameIngradientSearch.text=RandomSet2[randomFood].ingredient
            RandomImage.setImageResource(RandomSet2[randomFood].Images)
        }
    }
}