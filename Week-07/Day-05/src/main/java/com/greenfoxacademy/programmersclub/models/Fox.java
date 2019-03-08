package com.greenfoxacademy.programmersclub.models;

import java.util.ArrayList;
import java.util.List;

public class Fox {
    private String name;
    private List<Trick> tricks = new ArrayList<>();
    private Food food;
    private Drink drink;


    public Fox(String name, List<String> tricks, String foodName, String drinkName) {
        this.name = name;
        this.tricks.add(new Trick(tricks));
        this.food = new Food(foodName);
        this.drink = new Drink(drinkName);
    }

    public String getName() {
        return name;
    }

    public List<String> getTricks() {
        return tricks.get(0).getTricks();
    }

    public String getFood() {
        return food.getFoodName();
    }

    public String getDrink() {
        return drink.getDrinkName();
    }
}
