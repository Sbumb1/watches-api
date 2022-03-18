package com.watches.watches.dto;

import com.sun.istack.NotNull;

public class WatchDTO {

    @NotNull
    private String Brand;

    @NotNull
    private String model;

    private double price;

    private String color;

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

        public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString(){
        return Brand+ " "+ model;
    }
}
