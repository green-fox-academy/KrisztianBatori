package com.greenfoxacademy.frontend.models;

import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;
import java.util.List;

public class LogEntry {
    private List<ObjectNode> entries = new ArrayList<>();
    private int entry_count;

    public LogEntry() {

    }

    public LogEntry(List<ObjectNode> entries, int entry_count) {
        this.entries = entries;
        this.entry_count = entry_count;
    }

    public List<ObjectNode> getEntries() {
        return entries;
    }

    public void setEntries(List<ObjectNode> entries) {
        this.entries = entries;
    }

    public int getEntry_count() {
        return entry_count;
    }

    public void setEntry_count(int entry_count) {
        this.entry_count = entry_count;
    }
}
