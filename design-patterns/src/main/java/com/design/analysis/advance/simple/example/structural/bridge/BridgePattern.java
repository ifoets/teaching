package com.design.analysis.advance.simple.example.structural.bridge;

public class BridgePattern {
}
interface Color {
    String fill();
}
 class Blue implements Color {
    @Override
    public String fill() {
        return "Color is Blue";
    }
}
abstract class Shape {
    protected Color color;
    abstract public String draw();
}
class Square extends Shape {

    public Square(Color color) {
        super();
        super.color=color;
    }

    @Override
    public String draw() {
        return "Square drawn. " + color.fill();
    }
}
