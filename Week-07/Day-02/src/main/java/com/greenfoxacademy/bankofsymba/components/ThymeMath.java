package com.greenfoxacademy.bankofsymba.components;

import org.springframework.stereotype.Component;

import java.text.DecimalFormat;

@Component
public class ThymeMath {
    public String roundToTwoDecimals(int a) {
        return new DecimalFormat("####0.00").format(a);
    }
}
