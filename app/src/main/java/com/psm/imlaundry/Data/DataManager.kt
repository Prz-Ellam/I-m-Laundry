package com.psm.imlaundry.Data

import android.content.Context
import com.psm.imlaundry.Models.Card
import com.psm.imlaundry.Models.Order
import com.psm.imlaundry.Models.PackageItem
import com.psm.imlaundry.Models.Product
import com.psm.imlaundry.R
import java.util.*
import kotlin.collections.ArrayList

object DataManager {

    val products = ArrayList<Product>()
    val packageItems = ArrayList<PackageItem>()
    val orders = ArrayList<Order>()
    val cards = ArrayList<Card>()
    var content: Context? = null

    init {
        this.initializeProducts()
        this.initializePackages()
        this.initializeOrders()
        this.initializeCards()
    }

    private fun initializeProducts() {

        var product =  Product()
        product.name =  "Pantalón"
        product.price = 70.00f
        product.description = LOREMIPSUM
        product.imageId = R.drawable.jeans
        product.imagesUrl  = listOf("https://http2.mlstatic.com/D_NQ_NP_655885-MLM50060385031_052022-O.jpg",
                                    "https://dsnegsjxz63ti.cloudfront.net/images/pg/m_326077a9fdcbc87.jpg",
                                    "https://i0.wp.com/casaedith.mx/wp-content/uploads/2020/07/Pantal%C3%B3n-de-mezclilla-Kajm.jpeg")

        products.add(product)


        product =  Product()
        product.name =  "Camiseta"
        product.price = 50.00f
        product.description = LOREMIPSUM
        product.imageId = R.drawable.t_shirt
        product.imagesUrl  = listOf("https://static.lefties.com/9/photos2/2022/I/0/1/p/1003/303/660/1003303660_1_1_3.jpg",
                                    "http://racingmotor26.es/wp-content/uploads/2016/03/lote-camiseta-negra.jpg-300x300.png",
                                    "https://www.ropadecazamoratalla.com/381-large_default_2x/camiseta-algodon-premium.jpg")

        products.add(product)


        product =  Product()
        product.name =  "Gorro"
        product.price = 30.00f
        product.description = LOREMIPSUM
        product.imageId = R.drawable.hat
        product.imagesUrl  = listOf("https://dsnegsjxz63ti.cloudfront.net/images/pg/m_326164abab74044.jpg",
                                    "https://dsnegsjxz63ti.cloudfront.net/images/pg/g_326176dba7c9802.jpg",
                                    "https://ss433.liverpool.com.mx/sm/1119023242.jpg")

        products.add(product)


        product =  Product()
        product.name =  "Camisa"
        product.price = 50.00f
        product.description = LOREMIPSUM
        product.imageId = R.drawable.shirt
        product.imagesUrl  = listOf("https://http2.mlstatic.com/D_NQ_NP_983726-MLM46709425352_072021-W.jpg",
                                    "https://www.zegna.com/bin/productImage.UAX18.SRO1.169.F.R6.jpeg",
                                    "https://static.massimodutti.net/3/photos/2022/I/0/2/p/0155/446/250/0155446250_1_1_3.jpg")

        products.add(product)


        product =  Product()
        product.name =  "Sudadera"
        product.price = 100.00f
        product.description = LOREMIPSUM
        product.imageId = R.drawable.hoodie
        product.imagesUrl  = listOf("https://hips.hearstapps.com/vader-prod.s3.amazonaws.com/1627492161-filson-prospector-hoodie-blue-1627491769.jpg",
                                    "https://production-dam-media.arco.co.uk/cdn/1030000/images/I_1030000_COf_ProdSmall_414978_1.jpg",
                                    "https://static.pullandbear.net/2/photos/2022/I/0/2/p/8591/501/717/8591501717_1_1_3.jpg")

        products.add(product)

    }


    private fun initializePackages() {

        var packageItem =  PackageItem()
        packageItem.name =  "5 playeras"
        packageItem.price = 180.00f
        packageItem.description = LOREMIPSUM
        packageItem.imageId = R.drawable.t_shirts_package
        packageItem.imagesUrl  = listOf("https://m.media-amazon.com/images/I/31le8QAYnOL.jpg",
            "https://m.media-amazon.com/images/I/31le8QAYnOL.jpg",
            "https://m.media-amazon.com/images/I/31le8QAYnOL.jpg")

        packageItems.add(packageItem)


        packageItem =  PackageItem()
        packageItem.name =  "10 calzones"
        packageItem.price = 250.00f
        packageItem.description = LOREMIPSUM
        packageItem.imageId = R.drawable.underpants_package
        packageItem.imagesUrl  = listOf("https://m.media-amazon.com/images/I/81vmsv3kgAL._AC_SX679_.jpg",
            "https://m.media-amazon.com/images/I/81vmsv3kgAL._AC_SX679_.jpg",
            "https://m.media-amazon.com/images/I/81vmsv3kgAL._AC_SX679_.jpg")

        packageItems.add(packageItem)


        packageItem = PackageItem()
        packageItem.name =  "3 pantalones"
        packageItem.price = 175.00f
        packageItem.description = LOREMIPSUM
        packageItem.imageId = R.drawable.jeans_package
        packageItem.imagesUrl  = listOf("https://http2.mlstatic.com/D_NQ_NP_841446-MLM49181156155_022022-W.jpg",
            "https://http2.mlstatic.com/D_NQ_NP_841446-MLM49181156155_022022-W.jpg",
            "https://http2.mlstatic.com/D_NQ_NP_841446-MLM49181156155_022022-W.jpg")

        packageItems.add(packageItem)


        packageItem = PackageItem()
        packageItem.name =  "6 pares de calcetines"
        packageItem.price = 50.00f
        packageItem.description = LOREMIPSUM
        packageItem.imageId = R.drawable.calcetines
        packageItem.imagesUrl  = listOf("https://m.media-amazon.com/images/I/9133x8ipVCL._AC_SX569_.jpg",
            "https://m.media-amazon.com/images/I/9133x8ipVCL._AC_SX569_.jpg",
            "https://m.media-amazon.com/images/I/9133x8ipVCL._AC_SX569_.jpg")

        packageItems.add(packageItem)



    }


    private fun initializeOrders() {

        var order =  Order()
        order.number =  12
        order.date = "21/04/2022"
        order.status = "En proceso"
        order.progressPercent = 85

        orders.add(order)

        order =  Order()
        order.number =  15
        order.date = "22/04/2022"
        order.status = "En proceso"
        order.progressPercent = 35

        orders.add(order)

        order =  Order()
        order.number =  20
        order.date = "23/04/2022"
        order.status = "En proceso"
        order.progressPercent = 60

        orders.add(order)

        order =  Order()
        order.number =  23
        order.date = "23/04/2022"
        order.status = "Sin iniciar"
        order.progressPercent = 0

        orders.add(order)

        order =  Order()
        order.number =  23
        order.date = "19/04/2022"
        order.status = "Finalizado"
        order.progressPercent = 100

        orders.add(order)

    }


    private fun initializeCards() {

        var card =  Card()
        card.lastNumbers =  "4522"
        card.bankName = "HSBC"
        card.type = "Débito"
        card.cardProvider = 2

        cards.add(card)

        card =  Card()
        card.lastNumbers =  "2312"
        card.bankName = "Banorte"
        card.type = "Crédito"
        card.cardProvider = 1

        cards.add(card)

    }

}