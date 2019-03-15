package com.greenfoxacademy.frontend.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysResult {
    private Object result;

    public ArraysResult() {

    }

    public ArraysResult(String action, List<String> textNumbers) {
        if (action.equals("sum")) {
            result = textNumbers.stream()
                    .mapToInt(number -> Integer.parseInt(number))
                    .sum();
        }
        else if (action.equals("multiply")) {
            result = textNumbers.stream()
                    .mapToInt(number -> Integer.parseInt(number))
                    .reduce(1, (a, b) -> a * b);
        }
        else if (action.equals("double")) {
            result = new ArrayList<>(textNumbers.stream()
                    .mapToInt(number -> Integer.parseInt(number))
                    .map(number -> number *= 2)
                    .boxed()
                    .collect(Collectors.toList())
            );
        }
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
