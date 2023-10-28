package ru.gb.vending_machin.product;

public class Bottle extends Product {
    private double volume;

    public Bottle(int id, String name, double price, double volume) {
        super(id, name, price);
        this.volume=volume;
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return super.toString()+ ", volume: "+ volume+" l.";
    }
}
