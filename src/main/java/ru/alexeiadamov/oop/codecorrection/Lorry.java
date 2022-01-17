package ru.alexeiadamov.oop.codecorrection;

public class Lorry extends Car {
    public Lorry(String name, Color color, Engine engine) {
        super(name, color, engine);
    }

    @Override
    void open() {
        System.out.printf("%s is opening...\n", this.getClass().getSimpleName());
    }
}
