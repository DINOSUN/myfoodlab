package com.example.myfoodlab.ui.home


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentTransaction
import com.example.myfoodlab.*
import com.example.myfoodlab.ui.italianfood.ItalianFoodFragment
import com.example.myfoodlab.ui.japan.JapanFoodFragment
import com.example.myfoodlab.ui.koreafood.koreafoodFragment
import com.example.myfoodlab.ui.microwave_food.Microwave_FoodFragment
import com.example.myfoodlab.ui.thaifood.ThaiFood_Activity
import com.example.myfoodlab.ui.thaifood.ThaifoodFragment
import com.example.myfoodlab.ui.topfood.TopFoodFragment
import com.example.myfoodlab.ui.topfood_clean.Topfood_CleanFragment
import com.example.myfoodlab.ui.topfood_korea.Topfood_KoreaFragment
import kotlinx.android.synthetic.main.fragment_home_menu.*
import kotlinx.android.synthetic.main.fragment_home_menu.view.*

class HomeMenuFragment : Fragment() {

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

    private fun screenLayout(): Int = R.layout.fragment_home_menu

    private fun setupView() {
        SetUpHomeMenu()
    }

    private fun SetUpHomeMenu() {
        // intent card category
        val koearFood = rootView!!.findViewById<ImageView>(R.id.imageKorean_Food)
        koearFood.setOnClickListener{
            val koreanFood = koreafoodFragment()
            val transaction : FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.mainLayout,koreanFood)
            transaction.commit()

        }

        val thaiFood = rootView!!.findViewById<ImageView>(R.id.imageThai_Food)
        thaiFood.setOnClickListener{
            val intent = Intent(this.requireContext(), ThaiFood_Activity::class.java)
            startActivity(intent)
        }

        val italianfood = rootView!!.findViewById<ImageView>(R.id.imageItalian_Food)
        italianfood.setOnClickListener {
            val italianfood = ItalianFoodFragment()
            val tran: FragmentTransaction = requireFragmentManager().beginTransaction()
            tran.replace(R.id.mainLayout, italianfood)
            tran.commit()

        }

        val japanfood = rootView!!.findViewById<ImageView>(R.id.imageJapan_Food)
        japanfood.setOnClickListener {
            val japanfood = JapanFoodFragment()
            val tran: FragmentTransaction = requireFragmentManager().beginTransaction()
            tran.replace(R.id.mainLayout, japanfood)
            tran.commit()

        }

        val topfood = rootView!!.findViewById<ImageView>(R.id.imageMenu_food)
        topfood.setOnClickListener {
            val topfood = TopFoodFragment()
            val tran: FragmentTransaction = requireFragmentManager().beginTransaction()
            tran.replace(R.id.mainLayout, topfood)
            tran.commit()

        }

        val topfood_clean = rootView!!.findViewById<ImageView>(R.id.imageMenu_Clean)
        topfood_clean.setOnClickListener {
            val topfood_clean = Topfood_CleanFragment()
            val tran: FragmentTransaction = requireFragmentManager().beginTransaction()
            tran.replace(R.id.mainLayout, topfood_clean)
            tran.commit()
        }

        val topfood_korea = rootView!!.findViewById<ImageView>(R.id.imageMenu_Korean)
        topfood_korea.setOnClickListener {
            val topfood_korea = Topfood_KoreaFragment()
            val tran: FragmentTransaction = requireFragmentManager().beginTransaction()
            tran.replace(R.id.mainLayout, topfood_korea)
            tran.commit()
        }

        val topfood_microwave = rootView!!.findViewById<ImageView>(R.id.imageMenu_microwave)
        topfood_microwave.setOnClickListener {
            val topfood_microwave = Microwave_FoodFragment()
            val tran: FragmentTransaction = requireFragmentManager().beginTransaction()
            tran.replace(R.id.mainLayout, topfood_microwave)
            tran.commit()
        }


        /* SearchIcon Intent to Activity Search */
        SearchIcon.setOnClickListener {
            val intent = Intent(activity, Search::class.java)
            startActivity(intent)
        }



    }

}

