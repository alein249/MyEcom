package models;

import java.util.List;
public class Product {
    //Common for WBP and VBP
    public String name;       // Contains name of the product
    public String imageUrl;   // Location of Image of the Product
    public float type;        // Type of the Product - Weight Based Product and Variant Based Product

    //For VBP Only
    List<Variant> variants;

    //For WBP Only
    public float minQty;
    public float pricePerKg;

    public Product(String name,String imageUrl,float minQty,float pricePerKg) {
        type = ProductType.TYPE_WBP;
        this.name = name;
        this.imageUrl = imageUrl;
        this.minQty = minQty;
        this.pricePerKg = pricePerKg;
    }
    public Product(String name,String imageUrl,List<Variant> variants) {
        type = ProductType.TYPE_VBP;
        this.name = name;
        this.imageUrl = imageUrl;
        this.variants = variants;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
