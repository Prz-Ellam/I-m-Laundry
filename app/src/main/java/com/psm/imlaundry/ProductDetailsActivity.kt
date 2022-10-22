package com.psm.imlaundry

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.psm.imlaundry.Data.DEFAULT_PRODUCT_POSITION
import com.psm.imlaundry.Data.DataManager
import com.psm.imlaundry.Data.PRODUCT_POSITION
import com.psm.imlaundry.Models.Product
import kotlinx.android.synthetic.main.activity_product_details.*
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class ProductDetailsActivity: AppCompatActivity() {

    var productPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_product_details)
        setSupportActionBar(toolbarProductDetails)

        // Load product position
        this.productPosition = savedInstanceState?.getInt(PRODUCT_POSITION, DEFAULT_PRODUCT_POSITION)
            ?: intent.getIntExtra(PRODUCT_POSITION, DEFAULT_PRODUCT_POSITION)

        // Display product information
        this.displayProductDetails()

        // Cargar el toolbar
        setSupportActionBar(toolbarProductDetails)
    }

    private fun displayProductDetails() {

        // Get product
        val product: Product = DataManager.products[productPosition]
        txtViewProductName.text = product.name;
        txtViewProductPrice.text = "$" + product.price.toString() + " M.N."

        txtViewProductDescriptionContent.text = product.description;


        // Load product images in carousel
        val productImages = mutableListOf<CarouselItem>()

        for (imageUrl in product.imagesUrl) {
            productImages.add(CarouselItem(imageUrl))
        }

        val imageCarouselView: ImageCarousel = findViewById(R.id.imageCarouselProductImages)
        imageCarouselView.addData(productImages)


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(PRODUCT_POSITION, this.productPosition)
    }

}