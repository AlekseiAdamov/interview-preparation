package ru.alexeiadamov.oop.codecorrection;

public abstract class Car implements Movable {
    private Engine engine;
    private Color color;
    private String name;

    public Car(String name, Color color, Engine engine) {
        this.name = name;
        this.color = color;
        this.engine = engine;
    }

    @Override
    public void move() {
        System.out.printf("%s is moving...\n", this.getClass().getSimpleName());
    }

    @Override
    public void stop() {
        System.out.printf("%s is stopping...\n", this.getClass().getSimpleName());
    }

    @Override
    public void start() {
        System.out.printf("%s is starting...\n", this.getClass().getSimpleName());
    }

    abstract void open();

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
