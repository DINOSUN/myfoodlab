package com.example.myfoodlab

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.myfoodlab.ItemsAdapter.ItemsAdapterVH
import kotlinx.android.synthetic.main.row_items.view.*
import kotlin.collections.ArrayList

class ItemsAdapter
    (var clickListener: ClickListener)
    : RecyclerView.Adapter<ItemsAdapterVH>(), Filterable {

    var itemsModalList = ArrayList<ItemsModal>()
    var itemsModalListFilter = ArrayList<ItemsModal>()

    fun setData(itemsModalList: ArrayList<ItemsModal>){
        this.itemsModalList = itemsModalList
        this.itemsModalListFilter = itemsModalList
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsAdapterVH {
        return ItemsAdapterVH(LayoutInflater.from(parent.context).inflate(R.layout.row_items,parent,false))
    }

    override fun onBindViewHolder(holder: ItemsAdapterVH, position: Int) {

        val itemsModal = itemsModalList[position]
        holder.name.text = itemsModal.name
        holder.decs.text = itemsModal.desc
        holder.image.setImageResource(itemsModal.image)

        holder.itemView.setOnClickListener{
            clickListener.ClickedItem(itemsModal)
        }
    }

    override fun getItemCount(): Int {
        return itemsModalList.size
    }

    class ItemsAdapterVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name = itemView.fName
        val decs = itemView.fDesc
        val image = itemView.imageView

    }

    interface ClickListener{
        fun  ClickedItem(itemsModal: ItemsModal)
    }

    override fun getFilter(): Filter {
        return  object : Filter(){
            override fun performFiltering(charSequence: CharSequence?): FilterResults {

                val filterResults = FilterResults()
                if (charSequence == null || charSequence.length < 0 ){
                    filterResults.count = itemsModalListFilter.size
                    filterResults.values = itemsModalListFilter
                }else {

                    var searchChr = charSequence.toString().toLowerCase()

                    val itemModal = ArrayList<ItemsModal>()

                    for(item in itemsModalListFilter){
                        if (item.name.contains(searchChr) || item.desc.contains(searchChr)){
                            itemModal.add(item)
                        }
                    }

                    filterResults.count = itemModal.size
                    filterResults.values = itemModal

                }

                return filterResults
            }

            override fun publishResults(p0: CharSequence?, filterResults: FilterResults?) {

                itemsModalList = filterResults!!.values as ArrayList<ItemsModal>
                notifyDataSetChanged()

            }

        }
    }

}

