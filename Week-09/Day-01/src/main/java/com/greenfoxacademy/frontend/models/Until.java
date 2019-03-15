package com.greenfoxacademy.frontend.models;

public class Until {
    private int result = 0;

    public Until() {

    }

    public Until(int baseNumber, String action) {
        if (action.equals("sum")) {
            while (baseNumber != 0) {
                this.result += baseNumber;
                baseNumber--;
            }
        }
        else if (action.equals("factor")) {
            this.result = 1;
            while (baseNumber != 1) {
                this.result *= baseNumber;
                baseNumber--;
            }
        }
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
