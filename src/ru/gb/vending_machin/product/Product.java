package ru.gb.vending_machin.product;

public class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "id: "+id+", name: "+name+", price: "+price+" rub.";
    }
}
