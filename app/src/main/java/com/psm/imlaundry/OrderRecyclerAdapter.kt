package com.psm.imlaundry

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.psm.imlaundry.Data.ORDER_POSITION
import com.psm.imlaundry.Data.PACKAGE_POSITION
import com.psm.imlaundry.Models.Order

class OrderRecyclerAdapter(val context: Context, var orders: List<Order>):
    RecyclerView.Adapter<OrderRecyclerAdapter.OrderViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    inner class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // Get components
        val txtOrderNumberContent = itemView?.findViewById<TextView>(R.id.txtViewOrderNumberContent)
        val txtOrderDate = itemView?.findViewById<TextView>(R.id.txtViewOrderDate)
        val txtOrderStatusContent = itemView?.findViewById<TextView>(R.id.txtViewOrderStatusContent)
        val progressBarStatus = itemView?.findViewById<ProgressBar>(R.id.progressBarOrderStatus)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {

        val itemView = this.layoutInflater.inflate(R.layout.item_order_list, parent, false)
        return OrderViewHolder(itemView)
    }

    override fun getItemCount(): Int = this.orders.size


    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = this.orders[position]
        holder.txtOrderNumberContent.text = order.number.toString()
        holder.txtOrderDate.text = order.date
        holder.txtOrderStatusContent.text = order.status
        holder.progressBarStatus.progress = order.progressPercent!!
    }
}