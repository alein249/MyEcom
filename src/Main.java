
import models.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    //creating the WBP
    static Product apple = new Product("apple", "", 0.7f, 40), banana = new Product("banana", "", 0.4f, 50)

            //creating the VBP
            , Kiwi = new Product("kiwi", "", new ArrayList<>(
            Arrays.asList(
                    new Variant("500g", 70)
                    , new Variant("1Kg", 150)
            )));

    public static void main(String[] args) {
        listOfProduct();
        Cart cart = new Cart();
        while (true) {
            Scanner sc = new Scanner(System.in);
            char ch = sc.next().charAt(0);
            switch (ch) {
                case 'a':
                    addWBProduct(apple, sc, cart);
                    break;
                case 'b':
                    addWBProduct(banana, sc, cart);
                    break;
                case 'c':
                    addVBProduct(cart, sc, Kiwi);
                    break;
                case 'd':
                    while (true) {
                        System.out.println(cart);
                        if (cart.totalCost == 0f) {
                            System.out.println("Cart is Empty\n");
                            break;
                        }
                        System.out.println("0)Go back");
                        System.out.println("1)To select the item ");
                        int opt = sc.nextInt();
                        if (opt == 0) {
                            break;
                        } else {
                            System.out.println("Select which item you want to edit or remove:-");
                            editMyCart(cart, sc);
                        }
                    }
                    break;
                case 'f':
                    return;

            }
            listOfProduct();
        }


    }

    private static void editMyCart(Cart cart, Scanner sc) {
        int selectItem = sc.nextInt();
        int count = 1;
        for (CartItem cartItem : cart.cartItems.values()) {
            if (count++ == selectItem) {
                if (cartItem.product.type == ProductType.TYPE_WB) {
                    String str = "0)To remove the item\n" +
                            "1)To edit the item";
                    System.out.println(str);
                    int option = sc.nextInt();
                    switch (option) {
                        case 0:
                            cart.remove(cartItem.product);
                            System.out.println("Product is successfully remove ");
                            return;

                        case 1:
                            addWBProduct(cartItem.product, sc, cart);
                            return;
                    }
                } else {
                    String str = "0)To remove the item completely\n" +
                            "1)To edit the item";
                    System.out.println(str);

                    int option = sc.nextInt();
                    switch (option) {
                        case 0:
                            cart.remove(cartItem.product);
                            System.out.println("Product is successfully remove ");
                            return;

                        case 1:
                            System.out.println("Variants are" + cartItem.product);
                            System.out.println("Enter which variant you want to edit ");
                            int variant = sc.nextInt();
                            System.out.println("1)To add single quantity of  variant \n2)To decrease only single quantity of variant");
                            int options = sc.nextInt();

                            if (options == 1) {
                                cart.addVBProduct(cartItem.product, cartItem.product.variants.get(variant - 1));
                            } else if (options == 2) {
                                try {
                                    cart.decrementVBP(cartItem.product, cartItem.product.variants.get(variant - 1));
                                    System.out.println("Product is successfully edited");
                                } catch (Exception e) {
                                    System.out.println("Variant is already remove from the cart");
                                }
                            }
                            return;
                    }
                }
            }
        }
    }

    private static void addVBProduct(Cart cart, Scanner sc, Product product) {
        System.out.println("Enter which variant you want to add" + product);
        int variant = sc.nextInt();
        cart.addVBProduct(product, product.variants.get(variant - 1));

    }

    private static void addWBProduct(Product product, Scanner sc, Cart cart) {
        System.out.println("Enter the quantity of product");
        int qty = sc.nextInt();
        cart.addWBProduct(product, qty);


    }

    private static void listOfProduct() {

        String str = "The list of products:-\n" +
                "a) To add Apple (" + apple + ")\n" +
                "b) To add Banana(" + banana + ")\n" +
                "c) To add Kiwi( Variants are" + Kiwi + ")\n" +
                "d) Show my cart\n" +
                "e) Do you want to Exit\n\n" +
                " Choose any option :-";
        System.out.println(str);
    }


}