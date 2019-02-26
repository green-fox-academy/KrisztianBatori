package com.greenfoxacademy.springtable;

public class ColorPicker {
    private int rowColorPicker = 0b01;

    public String pickColor() {
        rowColorPicker = rowColorPicker ^ 0b11;
        return rowColorPicker == 2 ? "#d3d3d3" : "#f5f5f5";
    }
}
