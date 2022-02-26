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
import com.example.myfoodlab.databinding.FragmentRandomBinding


class RandomFragment : Fragment() {

    private var _binding: FragmentRandomBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRandomBinding.inflate(inflater, container, false)


        val menuItems = resources.getStringArray(R.array.Randomfood)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, menuItems)
        binding.autoRandomFood.setAdapter(arrayAdapter)
        binding.autoRandomFood.setOnItemClickListener { parent, view, position, id ->
            Log.d("A1B2C3", "String = " + position + " " + binding.autoRandomFood.text.toString())
            when (binding.autoRandomFood.text.toString()) {
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


        return binding.root
    }

    private fun checkClickType1(){
        binding.randomBtn.setOnClickListener {
            val intent = Intent(activity, Tom_Random::class.java)
            startActivity(intent)
        }
    }

    private fun checkClickType2(){
        binding.randomBtn.setOnClickListener {
            val intent = Intent(activity, Pad_Random::class.java)
            startActivity(intent)
        }
    }

    private fun checkClickType3(){
        binding.randomBtn.setOnClickListener {
            val intent = Intent(activity, OneDish_Random::class.java)
            startActivity(intent)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}