package ru.alexeiadamov.javacore.pingpong;

public enum Turn {
    PING("ping"),
    PONG("pong");

    private final String name;

    Turn(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
