package org.example.config;

import org.example.service.FactoryService;
import org.example.service.ShapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class Config {

    @Autowired
    private ShapeService service;

    @PostConstruct
    public void test() {
//        service.getCircle().getName();
//        service.getTriangle().getName();
//
//        service.getCircle().setName("_circle");
//        service.getCircle().setNameAndReturn("_circle");
//        service.getTriangle().setName("_triangle");


        // proxies
        FactoryService factoryService  = new FactoryService();
        ShapeService shapeService = (ShapeService) factoryService.getBean("shapeService");
    }
}
