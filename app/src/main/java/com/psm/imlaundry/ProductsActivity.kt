package com.psm.imlaundry

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.psm.imlaundry.Data.DataManager
import kotlinx.android.synthetic.main.content_products.*

class ProductsActivity: AppCompatActivity() {

    private var productAdapter: ProductRecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_products)
        setSupportActionBar(findViewById(R.id.toolbar))

        DataManager.content = this

        //RecyclerView
        rcListProduct.layoutManager = LinearLayoutManager(this)

        this.productAdapter = ProductRecyclerAdapter(this, DataManager.products)

        rcListProduct.adapter = this.productAdapter
    }

}