package com.surikov.lesson5.entity;

public class ProductOrder {
    int product_id;
    int order_id;
    int count;

    public ProductOrder() {
    }

    public ProductOrder(int product_id, int order_id, int count) {
        this.product_id = product_id;
        this.order_id = order_id;
        this.count = count;
    }

    public int getProductId() {
        return product_id;
    }

    public void setProductId(int product_id) {
        this.product_id = product_id;
    }

    public int getOrderId() {
        return order_id;
    }

    public void setOrderId(int order_id) {
        this.order_id = order_id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
