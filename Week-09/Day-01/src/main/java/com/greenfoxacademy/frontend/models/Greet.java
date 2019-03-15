package com.greenfoxacademy.frontend.models;

public class Greet {
    private String welcome_message;

    Greet() {

    }

    public Greet(String name, String title) {
        this.welcome_message = String.format("Oh, hi there %s, my dear %s!", name, title);
    }

    public String getWelcome_message() {
        return welcome_message;
    }

    public void setWelcome_message(String name, String title) {
        this.welcome_message = String.format("Oh, hi there %s, my dear %s!", name, title);
    }
}
