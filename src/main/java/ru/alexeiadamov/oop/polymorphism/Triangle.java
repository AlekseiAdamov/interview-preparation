package ru.alexeiadamov.oop.polymorphism;

public class Triangle extends Shape {
    private final double height;
    private final double base;

    public Triangle(double height, double base) {
        this.height = height;
        this.base = base;
    }

    @Override
    public void draw(Point point) {
        System.out.printf("Drawing triangle at %s...\n", point);
    }

    @Override
    public double area() {
        return (height * base) / 2;
    }
}
