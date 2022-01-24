package ru.alexeiadamov.oop.polymorphism;

public class ShapeDemo {
    public static void main(String[] args) {
        final Shape circle = new Circle(2.0);
        final Shape square = new Square(3.0);
        final Shape triangle = new Triangle(3.0, 3.0);

        final Canvas canvas = new Canvas();
        canvas.draw(circle, new Point(2, 7));
        canvas.draw(square);
        canvas.draw(triangle, new Point(1,3));
    }
}
