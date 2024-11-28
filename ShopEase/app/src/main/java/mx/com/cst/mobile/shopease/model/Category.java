package mx.com.cst.mobile.shopease.model;

public class Category {
    private String name;
    private String imageUrl;

    // Constructor
    public Category(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    // Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
