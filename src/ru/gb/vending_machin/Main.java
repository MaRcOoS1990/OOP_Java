package ru.gb.vending_machin;

import ru.gb.vending_machin.product.Bottle;
import ru.gb.vending_machin.product.Product;
import ru.gb.vending_machin.vending.VendingMachine;

public class Main {
    public static void main(String[] args){
        int index = 0;
        VendingMachine vendingMachine= new VendingMachine();

        Product product1= new Product(index++,"Twix",80);
        Product product2= new Bottle(index++,"Coca-cola",100,1.5);
        Product product3= new Product(index++,"Lays",90);

        vendingMachine.addProduct(product1);
        vendingMachine.addProduct(product2);
        vendingMachine.addProduct(product3);

        System.out.println(vendingMachine.getProductListInfo());

    }

}