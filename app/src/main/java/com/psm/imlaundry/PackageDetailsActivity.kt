package com.psm.imlaundry

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.psm.imlaundry.Data.*
import com.psm.imlaundry.Models.PackageItem
import com.psm.imlaundry.Models.Product
import kotlinx.android.synthetic.main.activity_package_details.*
import kotlinx.android.synthetic.main.activity_product_details.*
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class PackageDetailsActivity: AppCompatActivity() {

    var packagePosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_package_details)
        setSupportActionBar(toolbarPackageDetails)

        // Load product position
        this.packagePosition = savedInstanceState?.getInt(PACKAGE_POSITION, DEFAULT_PACKAGE_POSITION)
            ?: intent.getIntExtra(PACKAGE_POSITION, DEFAULT_PACKAGE_POSITION)

        // Display package information
        this.displayPackageDetails()

        // Load toolbar
        setSupportActionBar(toolbarPackageDetails)
    }

    private fun displayPackageDetails() {

        // Get package
        val packageItem: PackageItem = DataManager.packageItems[packagePosition]
        txtViewPackageName.text = packageItem.name;
        txtViewPackagePrice.text = "$" + packageItem.price.toString() + " M.N."
        txtViewPackageDescriptionContent.text = packageItem.description;

        // Load package images in carousel
        val packagesImages = mutableListOf<CarouselItem>()

        for (imageUrl in packageItem.imagesUrl) {
            packagesImages.add(CarouselItem(imageUrl))
        }

        val imageCarouselView: ImageCarousel = findViewById(R.id.imageCarouselPackageImages)
        imageCarouselView.addData(packagesImages)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(PACKAGE_POSITION, this.packagePosition)
    }

}