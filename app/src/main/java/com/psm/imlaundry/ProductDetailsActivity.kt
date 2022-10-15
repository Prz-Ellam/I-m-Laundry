package com.psm.imlaundry

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.relex.circleindicator.CircleIndicator
import me.relex.circleindicator.CircleIndicator2
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class ProductDetailsActivity: AppCompatActivity() {

    // List of product images to show in carousel image
    val productImages = mutableListOf<CarouselItem>()
    val productImagesUrl: List<String> = listOf("https://http2.mlstatic.com/D_NQ_NP_655885-MLM50060385031_052022-O.jpg",
                                                "https://dsnegsjxz63ti.cloudfront.net/images/pg/m_326077a9fdcbc87.jpg",
                                                "https://i0.wp.com/casaedith.mx/wp-content/uploads/2020/07/Pantal%C3%B3n-de-mezclilla-Kajm.jpeg?fit=720%2C1280&ssl=1")

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_product_details)

        // Add product images
        for (imageUrl in productImagesUrl) {
            productImages.add(CarouselItem(imageUrl))
        }

        // Load product images in carousel
        val imageCarouselView: ImageCarousel = findViewById(R.id.imageCarouselProductImages)
        imageCarouselView.addData(productImages)

    }
}