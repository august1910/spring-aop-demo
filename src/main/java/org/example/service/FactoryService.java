package org.example.service;

public class FactoryService {


    public Object getBean(String beanType) {
        if (beanType.equals("shapeService")) {
            return new ShapeServiceProxy();
        } else if (beanType.equals("circle")) {
            return new Circle();
        } else if (beanType.equals("triangle")) {
            return new Triangle();
        }
        return null;
    }
}
