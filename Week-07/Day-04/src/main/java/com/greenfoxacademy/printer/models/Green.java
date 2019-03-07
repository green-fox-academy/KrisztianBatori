package com.greenfoxacademy.printer.models;

//import org.springframework.stereotype.Service;

public class Green implements MyColor {
    @Override
    public void printColor() {
        System.out.println("It is in green color...");
    }
}
