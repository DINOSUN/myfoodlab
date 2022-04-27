package com.example.myfoodlab.ui.fillter

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.myfoodlab.R
import com.example.myfoodlab.ui.thaifood.ThaiFood_Activity
import kotlinx.android.synthetic.main.activity_filter_main.*
import kotlinx.android.synthetic.main.activity_notfound_filter.*

class Filter_main : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter_main)

        val sharedPref = applicationContext.getSharedPreferences(
            "addItems",
            Context.MODE_PRIVATE
        )

        val getItems1 = sharedPref.getString("Name1", "default value")
        val getItems2 = sharedPref.getString("Name2", "default value")
        val getItems3 = sharedPref.getString("Name3", "default value")
        val getItems4 = sharedPref.getString("Name4", "default value")

        var setEdit = sharedPref.edit()


        when (getItems1.toString()) {
            /* แสดงการ์ดกต้มมยำกุ้งและผัดไทย */
            "กุ้ง" -> {
                padthaiFilter.visibility = View.VISIBLE
                tomyumkungFilter.visibility = View.VISIBLE
            }
            /* แสดงการ์ดต้มยำ */
            "ข่า" -> {
                padthaiFilter.visibility = View.GONE
                tomyumkungFilter.visibility = View.VISIBLE
            }
            "ใบมะกรูด" -> {
                tomyumkungFilter.visibility = View.VISIBLE
                pickkangmooFilter.visibility - View.VISIBLE
            }
            "ตะไคร้" -> {
                padthaiFilter.visibility = View.VISIBLE
                tomyumkungFilter.visibility = View.VISIBLE
            }
            /* แสดงการ์ดผัดไทย */
            "ไชโป๊" -> {
                padthaiFilter.visibility = View.VISIBLE
            }
            "เต้าหู้เหลือง" -> {
                padthaiFilter.visibility = View.VISIBLE
            }
            "ใบกุ่ยช่าย" -> {
                padthaiFilter.visibility = View.VISIBLE
            }
            "ต้ม" -> {
                tomyumkungFilter.visibility = View.VISIBLE
            }
            /* แสดงการ์ดพริกแกงหมูและลาบหมู */
            "หมู" -> {
                pickkangmooFilter.visibility = View.VISIBLE
                larbmoo.visibility = View.VISIBLE
                khowpadrodfieFilter.visibility = View.VISIBLE
            }
            /* แสดงการ์ดข้าวผัดรถไฟ */
            "ข้าวสวย" -> {
                khowpadrodfieFilter.visibility = View.VISIBLE
                txtNotMenu.visibility = View.GONE
            }
            "คะน้า" -> {
                khowpadrodfieFilter.visibility = View.VISIBLE
            }
            "มะเขือเทศ" -> {
                khowpadrodfieFilter.visibility = View.VISIBLE
            }
            /* แสดงการ์ดพริกแกงหมู */
            "พริกแกง" -> {
                pickkangmooFilter.visibility = View.VISIBLE
            }
            "ถั่วฝักยาว" -> {
                pickkangmooFilter.visibility = View.VISIBLE
            }
            /* แสดงการ์ดลาบหมู */
            "หมูสับ" -> {
                larbmoo.visibility = View.VISIBLE
            }
            "ตับหมู" -> {
                larbmoo.visibility = View.VISIBLE
            }
            "พริกป่น" -> {
                larbmoo.visibility = View.VISIBLE
            }
            "ข้าวคั่ว" -> {
                larbmoo.visibility = View.VISIBLE
            }
            else -> {
                txtNotMenu.visibility = View.VISIBLE
            }

        }

        when (getItems2.toString()) {
            /* แสดงการ์ดกต้มมยำกุ้งและผัดไทย */
            "กุ้ง" -> {
                padthaiFilter.visibility = View.VISIBLE
                tomyumkungFilter.visibility = View.VISIBLE
            }
            /* แสดงการ์ดต้มยำ */
            "ข่า" -> {
                padthaiFilter.visibility = View.GONE
                tomyumkungFilter.visibility = View.VISIBLE
            }
            "ใบมะกรูด" -> {
                tomyumkungFilter.visibility = View.VISIBLE
                pickkangmooFilter.visibility - View.VISIBLE
            }
            "ตะไคร้" -> {
                padthaiFilter.visibility = View.VISIBLE
                tomyumkungFilter.visibility = View.VISIBLE
            }
            /* แสดงการ์ดผัดไทย */
            "ไชโป๊" -> {
                padthaiFilter.visibility = View.VISIBLE
            }
            "เต้าหู้เหลือง" -> {
                padthaiFilter.visibility = View.VISIBLE
            }
            "ใบกุ่ยช่าย" -> {
                padthaiFilter.visibility = View.VISIBLE
            }
            "ต้ม" -> {
                tomyumkungFilter.visibility = View.VISIBLE
            }
            /* แสดงการ์ดพริกแกงหมูและลาบหมู */
            "หมู" -> {
                pickkangmooFilter.visibility = View.VISIBLE
                larbmoo.visibility = View.VISIBLE
                khowpadrodfieFilter.visibility = View.VISIBLE
            }
            /* แสดงการ์ดข้าวผัดรถไฟ */
            "ข้าวสวย" -> {
                khowpadrodfieFilter.visibility = View.VISIBLE
            }
            "คะน้า" -> {
                khowpadrodfieFilter.visibility = View.VISIBLE
            }
            "มะเขือเทศ" -> {
                khowpadrodfieFilter.visibility = View.VISIBLE
            }
            /* แสดงการ์ดพริกแกงหมู */
            "พริกแกง" -> {
                pickkangmooFilter.visibility = View.VISIBLE
            }
            "ถั่วฝักยาว" -> {
                pickkangmooFilter.visibility = View.VISIBLE
            }
            /* แสดงการ์ดลาบหมู */
            "หมูสับ" -> {
                larbmoo.visibility = View.VISIBLE
            }
            "ตับหมู" -> {
                larbmoo.visibility = View.VISIBLE
            }
            "พริกป่น" -> {
                larbmoo.visibility = View.VISIBLE
            }
            "ข้าวคั่ว" -> {
                larbmoo.visibility = View.VISIBLE
            }
            else -> {
                txtNotMenu.visibility = View.VISIBLE
            }

        }

        when (getItems3.toString()) {
            /* แสดงการ์ดกต้มมยำกุ้งและผัดไทย */
            "กุ้ง" -> {
                padthaiFilter.visibility = View.VISIBLE
                tomyumkungFilter.visibility = View.VISIBLE
            }
            /* แสดงการ์ดต้มยำ */
            "ข่า" -> {
                padthaiFilter.visibility = View.GONE
                tomyumkungFilter.visibility = View.VISIBLE
            }
            "ใบมะกรูด" -> {
                tomyumkungFilter.visibility = View.VISIBLE
                pickkangmooFilter.visibility - View.VISIBLE
            }
            "ตะไคร้" -> {
                padthaiFilter.visibility = View.VISIBLE
                tomyumkungFilter.visibility = View.VISIBLE
            }
            /* แสดงการ์ดผัดไทย */
            "ไชโป๊" -> {
                padthaiFilter.visibility = View.VISIBLE
            }
            "เต้าหู้เหลือง" -> {
                padthaiFilter.visibility = View.VISIBLE
            }
            "ใบกุ่ยช่าย" -> {
                padthaiFilter.visibility = View.VISIBLE
            }
            "ต้ม" -> {
                tomyumkungFilter.visibility = View.VISIBLE
            }
            /* แสดงการ์ดพริกแกงหมูและลาบหมู */
            "หมู" -> {
                pickkangmooFilter.visibility = View.VISIBLE
                larbmoo.visibility = View.VISIBLE
                khowpadrodfieFilter.visibility = View.VISIBLE
            }
            /* แสดงการ์ดข้าวผัดรถไฟ */
            "ข้าวสวย" -> {
                khowpadrodfieFilter.visibility = View.VISIBLE
            }
            "คะน้า" -> {
                khowpadrodfieFilter.visibility = View.VISIBLE
            }
            "มะเขือเทศ" -> {
                khowpadrodfieFilter.visibility = View.VISIBLE
            }
            /* แสดงการ์ดพริกแกงหมู */
            "พริกแกง" -> {
                pickkangmooFilter.visibility = View.VISIBLE
                txtNotMenu.visibility = View.GONE
            }
            "ถั่วฝักยาว" -> {
                pickkangmooFilter.visibility = View.VISIBLE
                txtNotMenu.visibility = View.GONE
            }
            /* แสดงการ์ดลาบหมู */
            "หมูสับ" -> {
                larbmoo.visibility = View.VISIBLE
                txtNotMenu.visibility = View.GONE
            }
            "ตับหมู" -> {
                larbmoo.visibility = View.VISIBLE
                txtNotMenu.visibility = View.GONE
            }
            "พริกป่น" -> {
                larbmoo.visibility = View.VISIBLE
                txtNotMenu.visibility = View.GONE
            }
            "ข้าวคั่ว" -> {
                larbmoo.visibility = View.VISIBLE
                txtNotMenu.visibility = View.GONE
            }
            else -> {
                txtNotMenu.visibility = View.VISIBLE
            }


        }

        when (getItems4.toString()) {
            /* แสดงการ์ดกต้มมยำกุ้งและผัดไทย */
            "กุ้ง" -> {
                padthaiFilter.visibility = View.VISIBLE
                tomyumkungFilter.visibility = View.VISIBLE
                txtNotMenu.visibility = View.GONE
            }
            /* แสดงการ์ดต้มยำ */
            "ข่า" -> {
                padthaiFilter.visibility = View.GONE
                tomyumkungFilter.visibility = View.VISIBLE
                txtNotMenu.visibility = View.GONE
            }
            "ใบมะกรูด" -> {
                tomyumkungFilter.visibility = View.VISIBLE
                pickkangmooFilter.visibility - View.VISIBLE
                txtNotMenu.visibility = View.GONE
            }
            "ตะไคร้" -> {
                padthaiFilter.visibility = View.VISIBLE
                tomyumkungFilter.visibility = View.VISIBLE
                txtNotMenu.visibility = View.GONE
            }
            /* แสดงการ์ดผัดไทย */
            "ไชโป๊" -> {
                padthaiFilter.visibility = View.VISIBLE
                txtNotMenu.visibility = View.GONE
            }
            "เต้าหู้เหลือง" -> {
                padthaiFilter.visibility = View.VISIBLE
                txtNotMenu.visibility = View.GONE
            }
            "ใบกุ่ยช่าย" -> {
                padthaiFilter.visibility = View.VISIBLE
                txtNotMenu.visibility = View.GONE
            }
            "ต้ม" -> {
                tomyumkungFilter.visibility = View.VISIBLE
                txtNotMenu.visibility = View.GONE
            }
            /* แสดงการ์ดพริกแกงหมูและลาบหมู */
            "หมู" -> {
                pickkangmooFilter.visibility = View.VISIBLE
                larbmoo.visibility = View.VISIBLE
                khowpadrodfieFilter.visibility = View.VISIBLE
                txtNotMenu.visibility = View.GONE
            }
            /* แสดงการ์ดข้าวผัดรถไฟ */
            "ข้าวสวย" -> {
                khowpadrodfieFilter.visibility = View.VISIBLE
                txtNotMenu.visibility = View.GONE
            }
            "คะน้า" -> {
                khowpadrodfieFilter.visibility = View.VISIBLE
                txtNotMenu.visibility = View.GONE
            }
            "มะเขือเทศ" -> {
                khowpadrodfieFilter.visibility = View.VISIBLE
                txtNotMenu.visibility = View.GONE
            }
            /* แสดงการ์ดพริกแกงหมู */
            "พริกแกง" -> {
                pickkangmooFilter.visibility = View.VISIBLE
                txtNotMenu.visibility = View.GONE
            }
            "ถั่วฝักยาว" -> {
                pickkangmooFilter.visibility = View.VISIBLE
                txtNotMenu.visibility = View.GONE
            }
            /* แสดงการ์ดลาบหมู */
            "หมูสับ" -> {
                larbmoo.visibility = View.VISIBLE
                txtNotMenu.visibility = View.GONE
            }
            "ตับหมู" -> {
                larbmoo.visibility = View.VISIBLE
                txtNotMenu.visibility = View.GONE
            }
            "พริกป่น" -> {
                larbmoo.visibility = View.VISIBLE
                txtNotMenu.visibility = View.GONE
            }
            "ข้าวคั่ว" -> {
                larbmoo.visibility = View.VISIBLE
                txtNotMenu.visibility = View.GONE
            }
            else -> {
                txtNotMenu.visibility = View.VISIBLE
            }

        }
    }
}






