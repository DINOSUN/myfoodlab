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
        ItemsModal("tom yum kung", "อาหารไทย", R.drawable.tomyumkung),
        ItemsModal("jumokbab", "อาหารเกาหลี", R.drawable.tokbokki),
        ItemsModal("padthai", "อาหารไทย", R.drawable.padthai),
        ItemsModal("khawpadkung", "อาหารเกาหลี", R.drawable.khowpadrodfie),
        ItemsModal("kimchisoup", "อาหารเกาหลี", R.drawable.kimchisoup),
        ItemsModal("soup kimgi", "อาหารเกาหลี", R.drawable.bibimbap)
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

                    Toast.makeText(applicationContext, "Item not found", Toast.LENGTH_LONG).show()
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
            "tom yum kung" ->
                startActivity(Intent(this@Search, CardMenu_Tomyumkung::class.java))
            "jumokbab" ->
                startActivity(Intent(this@Search, CardMenu_Jumokbab::class.java))

            else -> {
                Toast.makeText(this, "ไม่มีหน้า", Toast.LENGTH_LONG).show()
            }

        }

    }


}


