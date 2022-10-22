package com.psm.imlaundry.Models

class Product(var name: String? = null,
              var price: Float? = null,
              var description: String? = null,
              var imageId: Int? = null,
              var imagesUrl: List<String> = listOf()) {
}