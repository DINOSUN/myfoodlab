package com.example.myfoodlab.ui.fillter

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.myfoodlab.R
import com.example.myfoodlab.ui.home.HomeMenuFragment
import com.google.android.material.internal.ContextUtils.getActivity
import kotlinx.android.synthetic.main.activity_filter_main.*

class getDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_details)

        val txtDetials1 = findViewById<TextView>(R.id.detials1)
        val txtDetials2 = findViewById<TextView>(R.id.detials2)
        val txtDetials3 = findViewById<TextView>(R.id.detials3)
        val txtDetials4 = findViewById<TextView>(R.id.detials4)
        val loadBtn = findViewById<Button>(R.id.btnConfirm)
        val editBtn = findViewById<Button>(R.id.btnBack)
        val sharedPref = getSharedPreferences("addItems", Context.MODE_PRIVATE)


        val getItems1 = sharedPref.getString("Name1", "default value")
        val getItems2 = sharedPref.getString("Name2", "default value")
        val getItems3 = sharedPref.getString("Name3", "default value")
        val getItems4 = sharedPref.getString("Name4", "default value")

        txtDetials1.text = getItems1
        txtDetials2.text = getItems2
        txtDetials3.text = getItems3
        txtDetials4.text = getItems4

        /* Click Edit to FilterFragment */
        /* Activity To Fragment */
        editBtn.setOnClickListener {
            val fragmentFilter = FillterFragment()
            val manager: FragmentManager = supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.replace(
                R.id.FilterMain,
                fragmentFilter,
                FillterFragment::class.java.simpleName
            )
            transaction.addToBackStack(null)
            transaction.commit()
        }


        /* Get Detail and Check Word  */
        loadBtn.setOnClickListener {
            if (txtDetials1.text.isNullOrEmpty()
                && txtDetials2.text.isNullOrEmpty()
                && txtDetials3.text.isNullOrEmpty()
                && txtDetials4.text.isNullOrEmpty()
            ) {
                Toast.makeText(this, "กรุณากรอกวัตถุดิบ", Toast.LENGTH_LONG).show()
            } else {
                startActivity(Intent(this@getDetails, Filter_main::class.java))

            }


        }
    }
}




//when (txtDetials1.text) {
//    "กุ้ง" -> {
//        padthaiFilter.visibility = View.VISIBLE
//        tomyumkungFilter.visibility = View.GONE
//        khowpadrodfieFilter.visibility = View.GONE
//        pickkangmooFilter.visibility = View.GONE
//    }
//}

//|| (txtDetials1.text == "กุ้ง") {
//    padthaiFilter.visibility = View.VISIBLE
//    tomyumkungFilter.visibility = View.GONE
//    khowpadrodfieFilter.visibility = View.GONE
//    pickkangmooFilter.visibility = View.GONE
//}


