package com.mrmodise.domain;

/**
 * Created by mrmodise on 2017/07/13.
 * @Class Order
 * @author mrmodise
 * Defines the order properties
 */
public class Order {
    private int id;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
