package com.greenfoxacademy.printer.models;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class Printer {
    public void log(MyColor color) {
        System.out.print(LocalDateTime.now() + " MY PRINTER SAYS --- ");
        color.printColor();
    }
}
