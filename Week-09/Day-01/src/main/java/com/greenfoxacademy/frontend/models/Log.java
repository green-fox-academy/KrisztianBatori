package com.greenfoxacademy.frontend.models;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date createdAt;
    private String endpoint;
    private String data;

    Log() {

    }

    public Log(Date createdAt, String endpoint, String data) {
        this.createdAt = createdAt;
        this.endpoint = endpoint;
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
