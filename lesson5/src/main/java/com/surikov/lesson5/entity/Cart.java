package com.surikov.lesson5.entity;

public class Cart {
    int numberOrder;
    String name;
    String description;
    int count;
    int price;


    public Cart(String name, String description, int count, int price) {
        this.name = name;
        this.description = description;
        this.count = count;
        this.price = price;
    }

    public Cart(int numberOrder, String name, String description, int count, int price) {
        this.numberOrder = numberOrder;
        this.name = name;
        this.description = description;
        this.count = count;
        this.price = price;
    }

    public int getNumberOrder() {
        return numberOrder;
    }

    public void setNumberOrder(int numberOrder) {
        this.numberOrder = numberOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
