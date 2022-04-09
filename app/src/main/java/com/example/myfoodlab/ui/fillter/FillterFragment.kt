package com.example.myfoodlab.ui.fillter

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.example.myfoodlab.R
import com.example.myfoodlab.Scan_Ai
import com.example.myfoodlab.Search
import kotlinx.android.synthetic.main.fragment_filtlter.*
import kotlinx.android.synthetic.main.fragment_italian_food.view.*

class FillterFragment : Fragment() {

    private var hasInitializedRootView = false
    private var rootView: View? = null
    private var focusView: View? = null
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var searchFil1 : EditText
    private lateinit var searchFil2 : EditText
    private lateinit var searchFil3 : EditText
    private lateinit var searchFil4 : EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
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

    private fun screenLayout(): Int = R.layout.fragment_filtlter

    private fun setupView() {
        ClickFilter()
    }

    private fun ClickFilter() {

        searchFil1 = rootView!!.findViewById(R.id.txtFill3)
        searchFil2 = rootView!!.findViewById(R.id.txtFill4)
        searchFil3 = rootView!!.findViewById(R.id.txtFill5)
        searchFil4 = rootView!!.findViewById(R.id.txtFill6)

        val sharedPref = requireActivity().applicationContext.getSharedPreferences(
            "addItems",
            Context.MODE_PRIVATE
        )
        var setEdit = sharedPref.edit()


        btnConfirm.setOnClickListener {
            setEdit.putString("Name1", searchFil1.text.toString())
            setEdit.putString("Name2", searchFil2.text.toString())
            setEdit.putString("Name3", searchFil3.text.toString())
            setEdit.putString("Name4", searchFil4.text.toString())
            setEdit.commit()
            Toast.makeText(activity, "บันทึกแล้ว", Toast.LENGTH_SHORT).show()


            /* validate data */
            val intent = Intent(getActivity(), getDetails::class.java)
            getActivity()?.startActivity(intent)

        }

        button_fillter.setOnClickListener {
            val intent = Intent(activity, Search::class.java)
            startActivity(intent)
        }

        search_fillter.setOnClickListener {
            val intent = Intent (activity, Scan_Ai::class.java)
            startActivity(intent)
        }

    }

}

