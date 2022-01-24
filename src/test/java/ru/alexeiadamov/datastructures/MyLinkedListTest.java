package ru.alexeiadamov.datastructures;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    @Test
    void addFirst() {
        final MyLinkedList<Item> list = new MyLinkedList<>();
        final Item item1 = new Item("some item");
        final Item item2 = new Item("another item");
        list.addFirst(item1);
        list.addFirst(item2);
        assertEquals(item2, list.getFirst());
    }

    @Test
    void addLast() {
        final MyLinkedList<Item> list = new MyLinkedList<>();
        final Item item1 = new Item("some item");
        final Item item2 = new Item("another item");
        list.addLast(item1);
        list.addLast(item2);
        assertEquals(item2, list.getLast());
    }

    @Test
    void removeFirst() {
        final MyLinkedList<Item> list = new MyLinkedList<>();
        final Item item1 = new Item("some item");
        final Item item2 = new Item("another item");
        final Item item3 = new Item("item too");
        list.add(item1);
        list.add(item2);
        list.add(item3);
        assertEquals(item1, list.removeFirst());
        assertEquals(item2, list.getFirst());
    }

    @Test
    void removeLast() {
        final MyLinkedList<Item> list = new MyLinkedList<>();
        final Item item1 = new Item("some item");
        final Item item2 = new Item("another item");
        final Item item3 = new Item("item too");
        list.add(item1);
        list.add(item2);
        list.add(item3);
        assertEquals(item3, list.removeLast());
        assertEquals(item2, list.getLast());
    }

    @Test
    void pollFirst() {
        removeFirst();
    }

    @Test
    void pollLast() {
        removeLast();
    }

    @Test
    void getFirst() {
        addFirst();
    }

    @Test
    void getLast() {
        addLast();
    }

    @Test
    void peekFirst() {
        getFirst();
    }

    @Test
    void peekLast() {
        getLast();
    }

    @Test
    void removeFirstOccurrence() {
        final MyLinkedList<Item> list = new MyLinkedList<>();
        final Item item1 = new Item("some item");
        final Item item2 = new Item("another item");
        final Item item3 = new Item("item too");
        list.add(item1);
        list.add(item2);
        list.add(item1);
        list.add(item3);
        assertTrue(list.removeFirstOccurrence(item1));
        assertTrue(list.removeFirstOccurrence(item1));
        assertFalse(list.removeFirstOccurrence(item1));
    }

    @Test
    void removeLastOccurrence() {
        final MyLinkedList<Item> list = new MyLinkedList<>();
        final Item item1 = new Item("some item");
        final Item item2 = new Item("another item");
        final Item item3 = new Item("item too");
        list.add(item1);
        list.add(item2);
        list.add(item1);
        list.add(item3);
        assertTrue(list.removeLastOccurrence(item1));
        assertTrue(list.removeLastOccurrence(item1));
        assertFalse(list.removeLastOccurrence(item1));
    }

    @Test
    void add() {
        addLast();
    }

    @Test
    void remove() {
        removeLast();
    }

    @Test
    void poll() {
        removeFirst();
    }

    @Test
    void peek() {
        getFirst();
    }

    @Test
    void addAll() {
        final MyLinkedList<Item> list = new MyLinkedList<>();
        final Item item1 = new Item("some item");
        final Item item2 = new Item("another item");
        final Item item3 = new Item("item too");
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        list.addAll(items);
        assertEquals(items.size(), list.size());
        assertTrue(list.containsAll(items));
    }

    @Test
    void removeAll() {
        final MyLinkedList<Item> list = new MyLinkedList<>();
        final Item item1 = new Item("some item");
        final Item item2 = new Item("another item");
        final Item item3 = new Item("item too");
        list.add(item1);
        list.add(item2);
        list.add(item3);
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        list.removeAll(items);
        assertEquals(1, list.size());
        assertEquals(item3, list.getFirst());
    }

    @Test
    void clear() {
        final MyLinkedList<Item> list = new MyLinkedList<>();
        final Item item1 = new Item("some item");
        final Item item2 = new Item("another item");
        final Item item3 = new Item("item too");
        list.add(item1);
        list.add(item2);
        list.add(item3);
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    void push() {
        addFirst();
    }

    @Test
    void pop() {
        removeFirst();
    }

    @Test
    void containsAll() {
        final MyLinkedList<Item> list = new MyLinkedList<>();
        final Item item1 = new Item("some item");
        final Item item2 = new Item("another item");
        final Item item3 = new Item("item too");
        list.add(item1);
        list.add(item2);
        list.add(item3);
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        assertTrue(list.containsAll(items));
    }

    @Test
    void contains() {
        final MyLinkedList<Item> list = new MyLinkedList<>();
        final Item item1 = new Item("some item");
        final Item item2 = new Item("another item");
        final Item item3 = new Item("item too");
        list.add(item1);
        list.add(item2);
        list.add(item3);
        assertTrue(list.contains(new Item("some item")));
        assertFalse(list.contains(new Item("some stuff")));
    }

    @Test
    void size() {
        final MyLinkedList<Item> list = new MyLinkedList<>();
        assertEquals(0, list.size());
        list.add(new Item("some item"));
        assertEquals(1, list.size());
    }

    @Test
    void isEmpty() {
        final MyLinkedList<Item> list = new MyLinkedList<>();
        assertTrue(list.isEmpty());
    }

    @Test
    void iterator() {
        final MyLinkedList<Item> list = new MyLinkedList<>();
        final Item item1 = new Item("some item");
        final Item item2 = new Item("another item");
        final Item item3 = new Item("item too");
        list.add(item1);
        list.add(item2);
        list.add(item3);
        final Iterator<Item> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), item1);
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), item2);
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), item3);
        assertFalse(iterator.hasNext());
    }

    @Test
    void toArray() {
        final MyLinkedList<Item> list = new MyLinkedList<>();
        list.add(new Item("some item"));
        list.add(new Item("another item"));
        list.add(new Item("item too"));
        final Item[] items = list.toArray(new Item[list.size()]);
        assertNotNull(items);
        assertEquals(3, items.length);
    }

    @Test
    void descendingIterator() {
        final MyLinkedList<Item> list = new MyLinkedList<>();
        final Item item1 = new Item("some item");
        final Item item2 = new Item("another item");
        final Item item3 = new Item("item too");
        list.add(item1);
        list.add(item2);
        list.add(item3);
        final Iterator<Item> iterator = list.descendingIterator();
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), item3);
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), item2);
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), item1);
        assertFalse(iterator.hasNext());
    }
}
