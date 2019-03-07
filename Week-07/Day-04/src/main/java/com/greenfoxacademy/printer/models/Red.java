package com.greenfoxacademy.printer.models;

import com.greenfoxacademy.printer.models.MyColor;
import org.springframework.stereotype.Service;

@Service
public class Red implements MyColor {
    @Override
    public void printColor() {
        System.out.println("It is in red color...");
    }
}
