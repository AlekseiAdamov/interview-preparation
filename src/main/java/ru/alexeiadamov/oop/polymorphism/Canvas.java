package ru.alexeiadamov.oop.polymorphism;

public class Canvas {
    public void draw(Shape shape, Point point) {
        shape.draw(point);
    }

    public void draw(Shape shape) {
        shape.draw();
    }
}
