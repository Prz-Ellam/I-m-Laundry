package com.psm.imlaundry

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.psm.imlaundry.Models.BagItem

class BagRecyclerAdapter(val context: Context, var bagItems: List<BagItem>):
    RecyclerView.Adapter<BagRecyclerAdapter.BagViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    inner class BagViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        // Get components
        val txtName = itemView?.findViewById<TextView>(R.id.txtViewPurchasableName)
        val txtPrice = itemView?.findViewById<TextView>(R.id.txtViewPurchasablePrice)
        val imgPurchasable = itemView?.findViewById<ImageView>(R.id.imgViewPurchasable)

        var purchasablePosition:Int = 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BagRecyclerAdapter.BagViewHolder {

        val itemView = this.layoutInflater.inflate(R.layout.item_bag_list, parent, false)
        return BagViewHolder(itemView)
    }

    override fun getItemCount(): Int = this.bagItems.size

    override fun onBindViewHolder(holder: BagRecyclerAdapter.BagViewHolder, position: Int) {

        val bagItem = this.bagItems[position]
        holder.txtName.text = bagItem.name
        holder.txtPrice.text = "$" + bagItem.price.toString() +" M.N."
        holder.imgPurchasable.setImageResource(bagItem.imageId!!)
        holder.purchasablePosition = position
    }
}