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
        holder.decs1.text = itemsModal.desc1
        holder.decs2.text = itemsModal.desc2
        holder.decs3.text = itemsModal.desc3
        holder.cal.text = itemsModal.txtCal
        holder.ingrad.text = itemsModal.txtIngrad
        holder.image.setImageResource(itemsModal.image)

        holder.itemView.setOnClickListener{
            clickListener.ClickedItem(itemsModal)
        }
    }

    override fun getItemCount(): Int {
        return itemsModalList.size
    }

    class ItemsAdapterVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name = itemView.RandomName
        val decs1 = itemView.DataTxt1
        val decs2 = itemView.DataTxt2
        val decs3 = itemView.DataTxt3
        val cal = itemView.txtCalorieRandom
        val ingrad = itemView.txtnameIngradientSearch
        val image = itemView.RandomImage

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
                        if (item.name.contains(searchChr)|| item.desc1.contains(searchChr) || item.desc2.contains(searchChr) || item.desc3.contains(searchChr) || item.txtCal.contains(searchChr) || item.txtIngrad.contains(searchChr)){
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

