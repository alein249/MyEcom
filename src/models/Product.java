package models;

import java.util.List;
public class Product {
    //Common for WBP and VBP
    public String name;       // Contains name of the product
    public String imageUrl;   // Location of Image of the Product
    public int type;        // Type of the Product - Weight Based Product and Variant Based Product

    //For VBP Only
    public List<Variant> variants;

    //For WBP Only
    public float minQty;
    public float pricePerKg;

    public Product(String name,String imageUrl,float minQty,float pricePerKg) {
        type = ProductType.TYPE_WB;
        this.name = name;
        this.imageUrl = imageUrl;
        this.minQty = minQty;
        this.pricePerKg = pricePerKg;
    }
    public Product(String name,String imageUrl,List<Variant> variants) {
        type = ProductType.TYPE_VB;
        this.name = name;
        this.imageUrl = imageUrl;
        this.variants = variants;
    }

    @Override
    public String toString() {
        if (type == ProductType.TYPE_WB) {
            return String.format("1kg price of %s is %f and minQty is %f",
                    name, pricePerKg, minQty);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            int count = 1;
            for (Variant variant : variants) {
                stringBuilder.append("\n" + "  " + count + ")" + variant.toString() + ", ");
                count++;
            }
            return stringBuilder.toString();
        }
    }
}
