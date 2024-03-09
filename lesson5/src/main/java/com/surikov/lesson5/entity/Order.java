package com.surikov.lesson5.entity;

import java.util.Date;

public class Order{
    int id;
    int number_order;
    Date date;

    public Order() {
    }

    public Order(int id, int number_order, Date date) {
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

    public int getNumber_order() {
        return number_order;
    }

    public void setNumber_order(int number_order) {
        this.number_order = number_order;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
