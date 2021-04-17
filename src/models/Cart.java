package models;

import java.util.HashMap;

public class Cart {
    public HashMap<String, CartItem> cartItems = new HashMap<>();
    public float totalCost;
    public float totalItems;

    // Add WBP to the cart
    public void addWBProduct(Product product, float qty){
        // If item is already in the cart
        if (cartItems.containsKey(product.name)){
            totalCost -= cartItems.get(product.name).cost();
            cartItems.get(product.name).qty = qty;
            System.out.println("Product is successfully edited");
        }
        // Adding item for the first time to the cart
        else {
            CartItem cartItem = new CartItem(product,product.name, qty, product.pricePerKg);
            cartItems.put(product.name,cartItem);
            System.out.println("Order is successfully added in your cart\n");
            totalItems++;
        }
        totalCost += cartItems.get(product.name).cost();
    }

    // Add VBP  to our cart
    public void addVBProduct(Product product, Variant variant){
        String key = product.name + " " + variant.name;  // Key for VBD concatenating product and variant name
        // If item is already in the cart
        if (cartItems.containsKey(key)){
            cartItems.get(key).qty++;
            System.out.println("Product is successfully edited");
            totalItems++;
            totalCost+= variant.price;
        }
        // Adding item for the first time to the cart
        else {
            CartItem cartItem = new CartItem(product,product.name, 1, variant.price);
            System.out.println("Order is successfully added in your cart\n");
            cartItems.put(key,cartItem);
            totalItems++;
            totalCost+= variant.price;
        }
    }

    // Remove VBP/WBP to our cart
    public void remove(Product product){
        if (product.type == 0) removeWBProduct(product);
        else removeAllVBP(product);
    }

    // Remove WBP from the cart
    public void removeWBProduct(Product product){
        // update cart summary
        totalCost -= cartItems.get(product.name).cost();
        totalItems--;

        cartItems.remove(product.name);
    }

    // Remove all variants of a VBP from the cart
    public void removeAllVBP(Product product){
        // Iterate all variants of our VBP
        for (Variant variant:product.variants) {
            String key = product.name + " " + variant.name;

            if (cartItems.containsKey(key)) {
                // update cart summary
                totalCost -= cartItems.get(key).cost();
                totalItems -= cartItems.get(key).qty;

                cartItems.remove(key);
            }
        }
    }

    // Decrement variant of a VBP
    public void decrementVBP(Product product, Variant variant){
        String key = product.name + " " + variant.name;

        // update qty of variant
        cartItems.get(key).qty--;

        //update cart summary
        totalCost -= variant.price;
        totalItems--;

        // remove from cart if qty = 0
        if (cartItems.get(key).qty == 0) cartItems.remove(key);
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        int count=1;
        for (CartItem cartItem:cartItems.values()){
            stringBuilder.append("\n"+count+")"+cartItem);
            count++;
        }
        return "MyCart :-" +
                "  "+ stringBuilder +
                String.format("\ntotal %.0f items (Rs. %.2f)", totalItems, totalCost);
    }
}
