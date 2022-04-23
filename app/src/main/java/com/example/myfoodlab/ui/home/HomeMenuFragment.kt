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
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.myfoodlab.CardMenu_Tomyumkung
import com.example.myfoodlab.R
import com.example.myfoodlab.Scan_Ai
import com.example.myfoodlab.Search
import com.example.myfoodlab.ui.italianfood.ItalianFoodActivity
import com.example.myfoodlab.ui.japan.JapanFood_Activity
import com.example.myfoodlab.ui.koreafood.KoreaFood_Activity
import com.example.myfoodlab.ui.microwave_food.MicrowaveFood_Activity
import com.example.myfoodlab.ui.thaifood.Thaifood_Activity
import com.example.myfoodlab.ui.topfood.TopFood_Activity
import com.example.myfoodlab.ui.topfood_clean.TopFoodClean_Activity
import com.example.myfoodlab.ui.topfood_korea.TopFoodKorea_Activity
import kotlinx.android.synthetic.main.fragment_home_menu.*
import kotlinx.android.synthetic.main.fragment_home_menu.view.*
import java.lang.reflect.Array
import java.util.ArrayList


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
        //imageSlider
        val imageList = ArrayList<SlideModel>()

        imageList.add(SlideModel("https://www.img.in.th/images/90477943ee26f7d7b0575141f2983ed1.png"))
        imageList.add(SlideModel("https://www.img.in.th/images/b0730219e141069c98c2fb1ce4bde5a6.png"))
        imageList.add(SlideModel("https://www.img.in.th/images/b6afdb87da91f7a30a1739811c30a41d.png"))

        val imageSlider = rootView!!.findViewById<ImageSlider>(R.id.image_slider)
        imageSlider.setImageList(imageList)


        // intent card category
        val koearFood = rootView!!.findViewById<ImageView>(R.id.imageKorean_Food)
        koearFood.setOnClickListener {
            val intent = Intent (this.requireContext(), KoreaFood_Activity::class.java)
            startActivity(intent)

        }

        val thaiFood = rootView!!.findViewById<ImageView>(R.id.imageThai_Food)
        thaiFood.setOnClickListener {
            val intent = Intent (this.requireContext(), Thaifood_Activity::class.java)
            startActivity(intent)

        }

        val italianfood = rootView!!.findViewById<ImageView>(R.id.imageItalian_Food)
        italianfood.setOnClickListener {
            val intent = Intent (this.requireContext(), ItalianFoodActivity::class.java)
            startActivity(intent)

        }

        val japanfood = rootView!!.findViewById<ImageView>(R.id.imageJapan_Food)
        japanfood.setOnClickListener {
            val intent = Intent (this.requireContext(), JapanFood_Activity::class.java)
            startActivity(intent)

        }

        val topfood = rootView!!.findViewById<ImageView>(R.id.imageMenu_food)
        topfood.setOnClickListener {
            val intent = Intent (this.requireContext(), TopFood_Activity::class.java)
            startActivity(intent)

        }

        val topfood_clean = rootView!!.findViewById<ImageView>(R.id.imageMenu_Clean)
        topfood_clean.setOnClickListener {
            val intent = Intent (this.requireContext(), TopFoodClean_Activity::class.java)
            startActivity(intent)
        }

        val topfood_korea = rootView!!.findViewById<ImageView>(R.id.imageMenu_Korean)
        topfood_korea.setOnClickListener {
            val intent = Intent (this.requireContext(), TopFoodKorea_Activity::class.java)
            startActivity(intent)
        }

        val topfood_microwave = rootView!!.findViewById<ImageView>(R.id.imageMenu_microwave)
        topfood_microwave.setOnClickListener {
            val intent = Intent (this.requireContext(), MicrowaveFood_Activity::class.java)
            startActivity(intent)
        }

        /* SearchIcon Intent to Activity Search */
        SearchIcon.setOnClickListener {
            val intent = Intent(activity, Search::class.java)
            startActivity(intent)
        }

        scanbtn.setOnClickListener {
            val intent = Intent(activity, Scan_Ai::class.java)
            startActivity(intent)
        }

    }


}


