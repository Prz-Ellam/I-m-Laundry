package com.psm.imlaundry.Data

class CardType(var intId:Int, var strTitle:String){

    override fun toString(): String {
        return this.strTitle
    }
}