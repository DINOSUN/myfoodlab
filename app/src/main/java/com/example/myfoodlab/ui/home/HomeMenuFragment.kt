package com.example.myfoodlab.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.FragmentTransaction
import com.example.myfoodlab.R
import com.example.myfoodlab.ui.italianfood.ItalianFoodFragment
import com.example.myfoodlab.ui.thaifood.ThaifoodFragment

class HomeMenuFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_home_menu, container, false)


        val thaifood = v.findViewById<ImageView>(R.id.imageThai_Food)
        thaifood.setOnClickListener {
            val thaifoodFragment = ThaifoodFragment()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.mainlayout, thaifoodFragment)
            transaction.commit()
        }


            val italianfood = v.findViewById<ImageView>(R.id.imageItalian_Food)
            italianfood.setOnClickListener{
                val italian_foodFragment = ItalianFoodFragment()
                val trans : FragmentTransaction = requireFragmentManager().beginTransaction()
                trans.replace(R.id.mainlayout,italian_foodFragment)
                trans.commit()
            }


        return v
    }


}