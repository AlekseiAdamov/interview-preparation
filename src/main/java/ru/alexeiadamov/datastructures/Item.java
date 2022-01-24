package ru.alexeiadamov.datastructures;

public class Item implements Comparable<Item> {
    private final String name;

    public Item(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Item o) {
        return this.name.compareTo(o.name);
    }
}
