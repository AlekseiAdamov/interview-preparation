package ru.alexeiadamov.oop.polymorphism;

public abstract class Shape {
    public abstract void draw(Point point);

    public void draw() {
        System.out.printf("Drawing %s at (0, 0)...\n", this.getClass().getSimpleName().toLowerCase());
    }

    public abstract double area();
}
