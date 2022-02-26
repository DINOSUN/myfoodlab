package com.example.myfoodlab.ui.koreafood

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myfoodlab.CardMenu_Jumokbab
import com.example.myfoodlab.CardMenu_Tomyumkung
import com.example.myfoodlab.R
import kotlinx.android.synthetic.main.fragment_koreafood.view.*
import kotlinx.android.synthetic.main.fragment_thaifood.view.*

class koreafoodFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root =  inflater.inflate(R.layout.fragment_koreafood, container, false)

        root.jumokbap.setOnClickListener {
            val intent = Intent (activity, CardMenu_Jumokbab::class.java)
            startActivity(intent)
        }

        return root
    }
}