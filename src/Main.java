

import models.Cart;
import models.Product;
import models.ProductType;
import models.Variant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Creating WBP
        Product kiwi = new Product("Kiwi","",1,50);
        Product banana = new Product("Banana","",1,30);

        // ArrayList of Variants of Our Product
        ArrayList<Variant> alm = new ArrayList<>(Arrays.asList(new Variant("500g",500), new Variant("1kg",900)));
        // Creating VBP
        Product almond = new Product("Almond","", alm);

        Cart cart = new Cart();
        cart.add(kiwi,5);
        cart.add(banana,3);
        cart.add(almond,alm.get(0));
        cart.add(almond,alm.get(0));

        System.out.println(cart);
        System.out.println();

        cart.removeAllVBP(almond);
        System.out.println(cart);
        System.out.println();

        cart.add(almond,alm.get(0));
        cart.add(almond,alm.get(0));
        cart.removeWBP(kiwi);
        System.out.println(cart);
        System.out.println();

        cart.decrementVBP(almond,alm.get(0));
        System.out.println(cart);

    }
}