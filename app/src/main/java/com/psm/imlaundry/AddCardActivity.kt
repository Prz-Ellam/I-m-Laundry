package com.psm.imlaundry

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.psm.imlaundry.Data.CardType
import com.psm.imlaundry.Data.DataManager
import kotlinx.android.synthetic.main.activity_add_card.*
import kotlinx.android.synthetic.main.content_bag.*

class AddCardActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_card)
        setSupportActionBar(findViewById(R.id.toolbarAddCard))

        // Load card types dropdown
        val adapterCardType =  ArrayAdapter<CardType>(this, R.layout.dropdown_item, DataManager.cardTypes)

        val autoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.cardTypeDropdown)
        autoCompleteTextView.setAdapter(adapterCardType)

    }
}