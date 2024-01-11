package org.example.service;


import org.springframework.stereotype.Service;

@Service
public class Triangle {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
