package com.psm.imlaundry

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.psm.imlaundry.Models.Card
import de.hdodenhof.circleimageview.CircleImageView

class CardMethodRecyclerAdapter(val context: Context, var cards: List<Card>):
    RecyclerView.Adapter<CardMethodRecyclerAdapter.CardMethodViewHolder>() {

    private var layoutInflater = LayoutInflater.from(context)

    inner class CardMethodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // Get components
        val txtBankName = itemView?.findViewById<TextView>(R.id.txtViewBank)
        val txtCardLastNumbers = itemView?.findViewById<TextView>(R.id.txtViewLastCardNumbers)
        val circleImageBankProvider = itemView?.findViewById<CircleImageView>(R.id.circleImageViewBank)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardMethodRecyclerAdapter.CardMethodViewHolder {

        val itemView = this.layoutInflater.inflate(R.layout.item_card_method_list, parent, false)
        return CardMethodViewHolder(itemView)
    }

    override fun getItemCount(): Int = this.cards.size


    override fun onBindViewHolder(holder: CardMethodRecyclerAdapter.CardMethodViewHolder, position: Int) {
        val card = this.cards[position]
        holder.txtBankName.text = card.bankName + " " + card.type
        holder.txtCardLastNumbers.text = "**** " + card.lastNumbers

        if(card.cardProvider == 1)
            holder.circleImageBankProvider.setImageResource(R.drawable.ic_visa)
        else
            holder.circleImageBankProvider.setImageResource(R.drawable.ic_mastercard)
    }

}