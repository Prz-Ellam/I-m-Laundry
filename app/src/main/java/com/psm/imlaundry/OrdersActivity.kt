package com.psm.imlaundry

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.psm.imlaundry.Data.DataManager
import kotlinx.android.synthetic.main.content_orders.*
import kotlinx.android.synthetic.main.content_packages.*

class OrdersActivity: AppCompatActivity() {

    private var orderAdapter: OrderRecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_orders)
        setSupportActionBar(findViewById(R.id.toolbarOrders))

        DataManager.content = this

        //RecyclerView
        rcListOrders.layoutManager = LinearLayoutManager(this)

        this.orderAdapter = OrderRecyclerAdapter(this, DataManager.orders)

        rcListOrders.adapter = this.orderAdapter
    }

}