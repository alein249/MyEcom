package models;

public class CartItem {
    public String name;
    public Product product;
    float qty, unitPrice;

    public CartItem(Product product, String name, float qty, float unitPrice) {
        this.product = product;
        this.name = name;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    // Returns Cost of Cart Item
    float cost(){
        return unitPrice * qty;
    }

    @Override
    public String toString() {
        return name + "  (" + String.format("%.2f X %.2f = %.2f", unitPrice, qty, cost()) +
                ")\n";
    }
}
