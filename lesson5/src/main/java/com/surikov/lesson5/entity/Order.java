package com.surikov.lesson5.entity;

import java.util.Date;

public class Order{
    int id;
    int number_order;
    String  date;

    public Order() {
    }

    public Order(int id, int number_order, String date) {
        this.id = id;
        this.number_order = number_order;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOrder() {
        return number_order;
    }

    public void setNumberOrder(int number_order) {
        this.number_order = number_order;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
