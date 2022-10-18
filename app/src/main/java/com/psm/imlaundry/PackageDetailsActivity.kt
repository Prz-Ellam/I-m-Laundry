package com.psm.imlaundry

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class PackageDetailsActivity: AppCompatActivity() {

    // List of package images to show in carousel image
    val packageImages = mutableListOf<CarouselItem>()
    val packageImagesUrl: List<String> = listOf("https://cdn.shopify.com/s/files/1/0078/3958/0249/products/Paquete-3Playeras-basicas-cuello_redondo_3A_1200x1200.jpg?v=1658463533",
        "https://static.pullandbear.net/2/photos/2022/I/0/2/p/8240/972/401/8240972401_1_1_3.jpg?t=1647419116787",
        "https://static.pullandbear.net/2/photos/2022/V/0/2/p/8240/972/707/8240972707_1_1_3.jpg")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_package_details)

        // Add product images
        for (imageUrl in packageImagesUrl) {
            packageImages.add(CarouselItem(imageUrl))
        }

        // Load product images in carousel
        val imageCarouselView: ImageCarousel = findViewById(R.id.imageCarouselPackageImages)
        imageCarouselView.addData(packageImages)

    }
}