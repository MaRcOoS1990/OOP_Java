package ru.gb.vending_machin.vending;

import ru.gb.vending_machin.product.Product;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private List<Product> productList;

    public VendingMachine() {
        productList =new ArrayList<>();
    }

    public Product getProductByName(String productName){
        for (Product product: productList){
            if (product.getName().equals(productName)){
                productList.remove(product);
                return product;

            }
        }
        return null;
    }
    public void addProduct(Product product){
        productList.add(product);
    }
    public String getProductListInfo(){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("Список продуктов: \n");
        for(Product product: productList){
            stringBuilder.append(product);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
