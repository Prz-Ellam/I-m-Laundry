package com.psm.imlaundry

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.psm.imlaundry.Data.DataManager
import kotlinx.android.synthetic.main.content_packages.*

class PackagesActivity: AppCompatActivity() {

    private var productAdapter: PackageRecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_packages)
        setSupportActionBar(findViewById(R.id.toolbarPackages))

        DataManager.content = this

        //RecyclerView
        rcListPackage.layoutManager = LinearLayoutManager(this)

        this.productAdapter = PackageRecyclerAdapter(this, DataManager.packageItems)

        rcListPackage.adapter = this.productAdapter
    }

}