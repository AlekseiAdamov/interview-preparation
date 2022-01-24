package ru.alexeiadamov.datastructures;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    @Test
    void add() {
        final MyArrayList<Item> list = new MyArrayList<>();
        list.add(new Item("item 1"));
        list.add(new Item("item 2"));
        list.add(new Item("item 3"));
        assertEquals(3, list.size());
    }

    @Test
    void remove() {
        final Item item1 = new Item("item 1");
        final Item item2 = new Item("item 2");
        final Item item3 = new Item("item 3");
        final Item[] items = new Item[] {item1, item2, item3};
        final MyArrayList<Item> list = new MyArrayList<>(items);
        assertTrue(list.contains(item2));
        list.remove(item2);
        assertFalse(list.contains(item2));
    }

    @Test
    void contains() {
        final Item item1 = new Item("item 1");
        final Item item2 = new Item("item 2");
        final Item item3 = new Item("item 3");
        final Item[] items = new Item[] {item1, item2, item3};
        final MyArrayList<Item> list = new MyArrayList<>(items);
        assertTrue(list.contains(item2));
    }

    @Test
    void indexOf() {
        final MyArrayList<Item> list = new MyArrayList<>();
        final Item item1 = new Item("item 1");
        final Item item2 = new Item("item 2");
        final Item item3 = new Item("item 3");
        list.add(item1);
        list.add(item2);
        list.add(item3);
        assertEquals(0, list.indexOf(item1));
        assertEquals(1, list.indexOf(item2));
        assertEquals(2, list.indexOf(item3));
    }

    @Test
    void isEmpty() {
        final MyArrayList<Item> list = new MyArrayList<>();
        assertTrue(list.isEmpty());
        list.add(new Item("item 1"));
        assertFalse(list.isEmpty());
    }

    @Test
    void size() {
        final MyArrayList<Item> list = new MyArrayList<>();
        assertEquals(0, list.size());
        list.add(new Item("item 1"));
        list.add(new Item("item 2"));
        list.add(new Item("item 3"));
        list.add(new Item("item 4"));
        assertEquals(4, list.size());
    }

    @Test
    void iterator() {
        final MyArrayList<Item> list = new MyArrayList<>();
        final Item item1 = new Item("item 1");
        final Item item2 = new Item("item 2");
        final Item item3 = new Item("item 3");
        list.add(item1);
        list.add(item2);
        list.add(item3);
        final Iterator<Item> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(item1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(item2, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(item3, iterator.next());
        assertFalse(iterator.hasNext());
    }
}
