package com.psm.imlaundry

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.psm.imlaundry.Data.DataManager
import kotlinx.android.synthetic.main.content_bag.*

class BagActivity: AppCompatActivity() {

    private var bagAdapter: BagRecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bag)
        setSupportActionBar(findViewById(R.id.toolbarBag))


        // Get total of the bag and show it

        var bagTotal: Float = 0.0f;

        for(bagItem in DataManager.bagItems){
            bagTotal += bagItem.price!!
        }

        val txtViewTotal = findViewById<TextView>(R.id.txtViewBagTotal)
        txtViewTotal.text = "Total: $" + bagTotal.toString() + " M.N."

        // Load bag items
        DataManager.content = this

        //RecyclerView
        rcListBagItems.layoutManager = LinearLayoutManager(this)

        this.bagAdapter = BagRecyclerAdapter(this, DataManager.bagItems)

        rcListBagItems.adapter = this.bagAdapter

    }

}