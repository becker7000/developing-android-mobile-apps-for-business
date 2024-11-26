package mx.com.cst.mobile.activitynavigation;

import java.io.Serializable;

public class ProductDTO implements Serializable {

    private String productName;
    private double productPrice;
    private int stock;

    // Constructor por defecto
    public ProductDTO() {
        this.productName = "";
        this.productPrice = 0.0;
        this.stock = 0;
    }

    // Constructor con parámetros
    public ProductDTO(String productName, double productPrice, int stock) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.stock = stock;
    }

    // Getter y Setter para productName
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    // Getter y Setter para productPrice
    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    // Getter y Setter para stock
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String fullName() {
        return productName + " Price: " + productPrice;
    }

    // Sobrescribir el método toString()
    @Override
    public String toString() {
        return "ProductDTO(productName='" + productName + "', productPrice=" + productPrice + ", stock=" + stock + ")";
    }
}
