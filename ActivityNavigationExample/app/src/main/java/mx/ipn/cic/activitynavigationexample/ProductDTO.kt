package mx.ipn.cic.activitynavigationexample

import java.io.Serializable

class ProductDTO(
    var productName: String = "",
    var productPrice: Double = 0.0,
    var stock: Int = 0
) : Serializable {

    //constructor() : this("", 0.0, 0)

    fun fullName(): String {
        return "$productName Price: $productPrice"
    }

    override fun toString(): String {
        return "ProductDTO(productName='$productName', productPrice=$productPrice, stock=$stock)"
    }
}