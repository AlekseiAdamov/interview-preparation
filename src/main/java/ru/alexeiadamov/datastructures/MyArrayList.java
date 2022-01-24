package ru.alexeiadamov.datastructures;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<E> implements Iterable<E> {
    private Object[] elements;
    private int size;

    public MyArrayList(Object[] elements) {
        this.elements = Arrays.copyOf(elements, elements.length);
    }

    public MyArrayList(int initialCapacity) {
        this.elements = new Object[initialCapacity];
    }

    public MyArrayList() {
        this(10);
    }

    public void add(E element) {
        if (this.size + 1 > this.elements.length) {
            this.elements = Arrays.copyOf(elements, elements.length * 2);
        }
        elements[size] = element;
        this.size++;
    }

    public void remove(E element) {
        final int removeIndex = this.indexOf(element);
        if (removeIndex >= 0) {
            if (removeIndex < this.elements.length - 1) {
                System.arraycopy(
                        this.elements,
                        removeIndex + 1,
                        this.elements,
                        removeIndex,
                        this.elements.length - 1 - removeIndex
                );
            } else {
                this.elements = Arrays.copyOf(elements, elements.length - 1);
            }
            this.size--;
        }
    }

    public boolean contains(E element) {
        return this.indexOf(element) >= 0;
    }

    public int indexOf(E element) {
        Object[] objects = this.elements;
        for (int i = 0; i < objects.length; i++) {
            //noinspection unchecked
            E e = (E) objects[i];
            if (e.equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int next = 0;

            @Override
            public boolean hasNext() {
                return next < size;
            }

            @Override
            public E next() {
                //noinspection unchecked
                return (E) elements[next++];
            }
        };
    }
}
