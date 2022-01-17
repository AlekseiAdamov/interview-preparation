package ru.alexeiadamov.oop.polymorphism;

public class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw(Point point) {
        System.out.printf("Drawing circle at %s...\n", point);
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
