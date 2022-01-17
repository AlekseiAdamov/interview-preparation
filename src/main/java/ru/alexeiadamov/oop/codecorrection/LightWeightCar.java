package ru.alexeiadamov.oop.codecorrection;

class LightWeightCar extends Car {
    public LightWeightCar(String name, Color color, Engine engine) {
        super(name, color, engine);
    }

    @Override
    void open() {
        System.out.printf("%s is opening...\n", this.getClass().getSimpleName());
    }
}
