package com.psm.imlaundry

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.psm.imlaundry.Data.DataManager
import kotlinx.android.synthetic.main.activity_payment_methods.*
import kotlinx.android.synthetic.main.content_packages.*

class PaymentMethodsActivity: AppCompatActivity() {

    private var cardMethodAdapter: CardMethodRecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_payment_methods)
        setSupportActionBar(findViewById(R.id.toolbarPaymentMethods))

        DataManager.content = this

        //RecyclerView
        rcListCardMethods.layoutManager = LinearLayoutManager(this)

        this.cardMethodAdapter = CardMethodRecyclerAdapter(this, DataManager.cards)

        rcListCardMethods.adapter = this.cardMethodAdapter
    }

}