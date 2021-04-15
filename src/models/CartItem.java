package models;

import java.util.HashMap;

public class CartItem {
    String name;
    float costPerUnit;
    float qty;

    public CartItem(String name, float costPerUnit, float qty) {
        this.name = name;
        this.costPerUnit = costPerUnit;
        this.qty = qty;
    }

    // Returns Cost of Cart Item
    float cost(){
        return costPerUnit * qty;
    }

    @Override
    public String toString() {
        return "\n" + name + String.format("(%f X %f = %f)",costPerUnit,qty,cost());
    }
}
