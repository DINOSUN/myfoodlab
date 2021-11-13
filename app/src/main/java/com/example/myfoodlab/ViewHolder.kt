package com.example.myfoodlab

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var txtTitleItem: TextView = view.findViewById(R.id.txtTitleItem)
    var imageview: ImageView = view.findViewById(R.id.imageView3)
    var cardview: CardView = view.findViewById(R.id.cardview)
}