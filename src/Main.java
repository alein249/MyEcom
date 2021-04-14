import models.Product;
import models.Variant;
import models.VariantBasedProduct;
import models.WeightBasedProduct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Create products
        Product apple = new WeightBasedProduct("Apple","",10F,50F);
        Product banana = new VariantBasedProduct("Banana","",new ArrayList<>(
                Arrays.asList(
                        new Variant("500gF",20f)
                ,new Variant("1KgF",40f)
                )
        ));
        //Add them in a list
        List<Product> products = new ArrayList<>(
                Arrays.asList(apple,banana)
        );
        System.out.println(products);
    }
}
