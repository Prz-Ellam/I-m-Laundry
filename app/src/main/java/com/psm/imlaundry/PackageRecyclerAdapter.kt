package com.psm.imlaundry

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.psm.imlaundry.Data.PACKAGE_POSITION
import com.psm.imlaundry.Models.PackageItem

class PackageRecyclerAdapter(val context: Context, var packages: List<PackageItem>):
    RecyclerView.Adapter<PackageRecyclerAdapter.PackageViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    inner class PackageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        // Get components
        val txtName = itemView?.findViewById<TextView>(R.id.txtViewPurchasableName)
        val txtPrice = itemView?.findViewById<TextView>(R.id.txtViewPurchasablePrice)
        val imgProduct = itemView?.findViewById<ImageView>(R.id.imgViewPurchasable)

        var packagePosition:Int = 0

        init {
            itemView?.findViewById<FrameLayout>(R.id.idPurchasableFrameLayoutCard).setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            when(v!!.id) {

                R.id.idPurchasableFrameLayoutCard -> {

                    // Open package details
                    val activityIntent = Intent(context, PackageDetailsActivity::class.java)
                    activityIntent.putExtra(PACKAGE_POSITION, this.packagePosition)
                    context.startActivity(activityIntent)
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PackageRecyclerAdapter.PackageViewHolder {

        val itemView = this.layoutInflater.inflate(R.layout.item_purchasable_list, parent, false)
        return PackageViewHolder(itemView)
    }


    override fun getItemCount(): Int = this.packages.size


    override fun onBindViewHolder(holder: PackageViewHolder, position: Int) {
        val packageItem = this.packages[position]
        holder.txtName.text = packageItem.name
        holder.txtPrice.text = "$" + packageItem.price.toString() +" M.N."
        holder.packagePosition = position
        holder.imgProduct.setImageResource(packageItem.imageId!!)
    }

}