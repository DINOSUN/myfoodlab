package com.example.myfoodlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_search.*
class Search : AppCompatActivity(), ItemsAdapter.ClickListener {

    lateinit var searchView: SearchView


    val fname = arrayOf(
        ItemsModal("ต้มยำกุ้ง", "ตะไคร้","กุ้ง","ข่า","874 kcal","10", R.drawable.tomyumkung),
        ItemsModal("จูม็อกบับ", "มายองเนส","ทูน่า","สาหร่าย","400 kcal","7", R.drawable.jumokbap),
        ItemsModal("ผัดไทยกุ้งสด", "ไชโป๊","เต้าหู้เหลือง","ใบกุ่ยช่าย","486 kcal","11", R.drawable.padthai),
        ItemsModal("ข้าวผัดรถไฟ", "ข้าวสวย","หมู","คะน้า","600 kcal","11", R.drawable.khowpadrodfie),
        ItemsModal("ซุปกิมจิ", "ผงซุปกิมจิ","กิมจิ","โคชูจัง","894 kcal","12", R.drawable.kimchisoup),
        ItemsModal("บิบิมบับ", "ข้าวสวย","เนื้อสัตว์บด","โคชูจัง","430 kcal","14", R.drawable.bibimbap),
        ItemsModal("ข้าวหน้าเนื้อ", "โชยุ","มิริน","สาเก","720 kcal","11", R.drawable.yoshinoyagyudon),
        ItemsModal("สุกี้ยากี้น้ำดำ", "คิคโคแมน","มิริน","สาเก","625 kcal","12", R.drawable.sukiyaki),
        ItemsModal("ต๊อกโบกี", "แป้งต๊อก","กิมจิ","โคชูจัง","420 kcal","14", R.drawable.tokbokki),
    )

    private val itemsModalList = ArrayList<ItemsModal>()
    var itemsAdapter: ItemsAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        val searchBar = findViewById<SearchView>(R.id.fName_search)


        for (items in fname) {
            itemsModalList.add(items)
        }

        itemsAdapter = ItemsAdapter(this)
        itemsAdapter!!.setData(itemsModalList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = itemsAdapter

        searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                searchBar.clearFocus()
                if (fname.isArrayOf<String>()) {
                    itemsAdapter!!.filter.filter(p0)
                    Log.d("Adapter food", "P0 : $p0")
                } else {

                    Toast.makeText(applicationContext, "ไม่พบผลลัพธ์การค้นหา", Toast.LENGTH_LONG).show()
                }
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                itemsAdapter!!.filter.filter(p0)
                Log.d("Adapter food", "P0 : $p0")
                return false
            }

        })

    }

    override fun ClickedItem(itemsModal: ItemsModal) {
        Log.e("TAG", itemsModal.name)

        when (itemsModal.name) {
            "ต้มยำกุ้ง" ->
                startActivity(Intent(this@Search, CardMenu_Tomyumkung::class.java))
            "จูม็อกบับ" ->
                startActivity(Intent(this@Search, CardMenu_Jumokbab::class.java))

            else -> {
                Toast.makeText(this, "ไม่มีหน้า", Toast.LENGTH_LONG).show()
            }

        }

    }


}


