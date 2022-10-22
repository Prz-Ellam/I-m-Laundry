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
import com.psm.imlaundry.Data.PRODUCT_POSITION
import com.psm.imlaundry.Models.Product

class ProductRecyclerAdapter(val context: Context, var products: List<Product>):
    RecyclerView.Adapter<ProductRecyclerAdapter.ViewHolder>(){

    private val layoutInflater = LayoutInflater.from(context)

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {

        // Get components
        val txtName = itemView?.findViewById<TextView>(R.id.txtViewPurchasableName)
        val txtPrice = itemView?.findViewById<TextView>(R.id.txtViewPurchasablePrice)
        val imgProduct = itemView?.findViewById<ImageView>(R.id.imgViewPurchasable)

        var productPosition:Int = 0

        init {
            itemView?.findViewById<FrameLayout>(R.id.idPurchasableFrameLayoutCard).setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            when(v!!.id) {

                R.id.idPurchasableFrameLayoutCard -> {

                    // Open product details
                    val activityIntent = Intent(context, ProductDetailsActivity::class.java)
                    activityIntent.putExtra(PRODUCT_POSITION, this.productPosition)
                    context.startActivity(activityIntent)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val itemView = this.layoutInflater.inflate(R.layout.item_purchasable_list, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = this.products.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val product = this.products[position]
        holder.txtName.text = product.name
        holder.txtPrice.text = "$" + product.price.toString() +" M.N."
        holder.productPosition = position
        holder.imgProduct.setImageResource(product.imageId!!)
    }

}