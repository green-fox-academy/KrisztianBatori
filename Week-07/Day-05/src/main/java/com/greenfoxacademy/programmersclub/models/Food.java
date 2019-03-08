package com.greenfoxacademy.programmersclub.models;

public class Food {
    private String foodName;
    Food(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodName() {
        return foodName;
    }
}
