package com.example.myfoodlab.ui.random

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.myfoodlab.*
import kotlinx.android.synthetic.main.fragment_random.*

class RandomFragment : Fragment() {

    private var hasInitializedRootView = false
    private var rootView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return getPersistentView(inflater, container, savedInstanceState, screenLayout())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!hasInitializedRootView) {
            hasInitializedRootView = true
            setupView()
        }
    }

    private fun getPersistentView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
        layout: Int
    ): View? {
        if (rootView == null) {
            rootView = inflater.inflate(layout, container, false)
        } else {
            (rootView?.parent as? ViewGroup)?.removeView(rootView)
        }
        return rootView
    }

    private fun screenLayout(): Int = R.layout.fragment_random


    private fun setupView() {
        Clickdropdown()
    }

    private fun Clickdropdown() {
        val menuItems = resources.getStringArray(R.array.Randomfood)
        val arrayAdapter = context?.let { ArrayAdapter(it, R.layout.dropdown_item, menuItems) }
        autoRandomFood?.setAdapter(arrayAdapter)
        autoRandomFood?.setText("เลือกหมวดหมู่อาหาร")
        autoRandomFood?.setOnItemClickListener { parent, view, position, id ->
            Log.d("A1B2C3", "String = " + position + " " + autoRandomFood?.text.toString())
            when (autoRandomFood?.text.toString()) {
                "ต้ม" -> {
                    checkClickType1()
                }
                "ผัด" -> {
                    checkClickType2()
                }
                "อาหารจานเดียว" -> {
                    checkClickType3()
                }
            }
        }

        /* SearchIcon Intent to Activity Search */
        SearchIcon_Filter?.setOnClickListener {
            val intent = Intent(activity, Search::class.java)
            startActivity(intent)
        }
    }

    /* Fragment to Activity */
    private fun checkClickType1() {
        randomBtn?.setOnClickListener {
            val intent = Intent(activity, Boiled_Random::class.java)
            startActivity(intent)
        }
    }

    private fun checkClickType2() {
        randomBtn?.setOnClickListener {
            val intent = Intent(activity, puff_Random::class.java)
            startActivity(intent)
        }
    }

    private fun checkClickType3() {
        randomBtn?.setOnClickListener {
            val intent = Intent(activity, OneDish_Random::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        val menuItems = resources.getStringArray(R.array.Randomfood)
        val arrayAdapter = context?.let { ArrayAdapter(it, R.layout.dropdown_item, menuItems) }
        autoRandomFood?.setAdapter(arrayAdapter)

    }

}