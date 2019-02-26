package com.greenfoxacademy.springtable.controllers;

import com.greenfoxacademy.springtable.ColorPicker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller

public class TableController {

    private ArrayList<String[]> saleList = new ArrayList<>() {{

        add(new String[] {"January", "50,000.00"});
        add(new String[] {"February", "10,000.00"});
        add(new String[] {"March", "85,000.00"});
        add(new String[] {"April", "56,000.00"});
        add(new String[] {"May", "98,000.00"});
    }};

    @RequestMapping("/sales")
    public String makeTable(Model model) {
        model.addAttribute("sales", saleList);
        model.addAttribute("rowColor", new ColorPicker());
        return "sales";
    }
}
