package ru.alexeiadamov.oop.polymorphism;

public class Square extends Shape {
    private final double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public void draw(Point point) {
        System.out.printf("Drawing square at %s...\n", point);
    }

    @Override
    public double area() {
        return side * side;
    }
}
