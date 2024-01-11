package org.example.service;

import org.example.aspectj.Loggable;
import org.springframework.stereotype.Service;

@Service
public class Circle {

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Called setter Circle");
        throw(new RuntimeException());
    }

    public String setNameAndReturn(String name) {
        this.name = name;
        System.out.println("Called setter Circle");
        return name;
    }
}
