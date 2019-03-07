package com.greenfoxacademy.printer;

import com.greenfoxacademy.printer.models.MyColor;
import com.greenfoxacademy.printer.models.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrinterApplication implements CommandLineRunner {

    private Printer printer;
    private MyColor color;

    @Autowired
    PrinterApplication(Printer printer, MyColor color) {
        this.printer = printer;
        this.color = color;
    }

    @Override
    public void run(String... args) throws Exception {
        printer.log(this.color);
    }

    public static void main(String[] args) {
        SpringApplication.run(PrinterApplication.class, args);
    }
}
