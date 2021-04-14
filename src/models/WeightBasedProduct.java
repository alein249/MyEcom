package models;

public class WeightBasedProduct extends Product {
    float minQty, pricePerKg;
    public WeightBasedProduct(String name, String imageUrl, float minQty, float pricePerKg){
        super(name, imageUrl);
        this.minQty = minQty;
        this.pricePerKg = pricePerKg;
    }

    @Override
    public String toString() {
        return "WeightBasedProduct{" +
                "name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", minQty=" + minQty +
                ", pricePerKg=" + pricePerKg +
                '}';
    }
}
