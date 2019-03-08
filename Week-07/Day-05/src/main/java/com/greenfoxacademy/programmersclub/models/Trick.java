package com.greenfoxacademy.programmersclub.models;

import java.util.List;

public class Trick {
    private List<String> tricks;

    Trick(List<String> tricks) {
        this.tricks = tricks;
    }

    public List<String> getTricks() {
        return tricks;
    }
}
