package models;

import java.util.List;

public class VariantBasedProduct extends Product {
    List<Variant> variants;
    public VariantBasedProduct(List<Variant> variants){
        this.variants = variants;
    }
    public VariantBasedProduct(String name, String imageUrl, List<Variant> variants){
        super(name, imageUrl);
        this.variants = variants;
    }

    @Override
    public String toString() {
        return "VariantBasedProduct{" +
                "name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", variants=" + variants +
                '}';
    }
}
