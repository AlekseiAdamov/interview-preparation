package ru.alexeiadamov.datastructures;

import java.util.Collection;
import java.util.Iterator;

public class MyLinkedList<E> implements Iterable<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    public void addFirst(E data) {
        final Node<E> node = new Node<>(data);
        if (this.isEmpty()) {
            this.last = node;
        } else {
            this.first.previous = node;
            node.next = this.first;
        }
        this.first = node;
        size++;
    }

    public void addLast(E data) {
        final Node<E> node = new Node<>(data);
        if (this.isEmpty()) {
            this.first = node;
        } else {
            this.last.next = node;
            node.previous = this.last;
        }
        this.last = node;
        this.size++;
    }

    public E removeFirst() {
        E data = this.first.data;
        this.first = this.first.next;
        this.first.previous = null;
        this.size--;
        return data;
    }

    public E removeLast() {
        if (this.size == 0) {
            return null;
        }
        E data = this.last.data;
        if (this.last.previous != null) {
            this.last = this.last.previous;
            this.last.next = null;
        } else {
            this.last = null;
        }
        this.size--;
        return data;
    }

    public E pollFirst() {
        return this.removeFirst();
    }

    public E pollLast() {
        return this.removeLast();
    }

    public E getFirst() {
        return this.first.data;
    }

    public E getLast() {
        return this.last.data;
    }

    public E peekFirst() {
        return this.getFirst();
    }

    public E peekLast() {
        return this.getLast();
    }

    public boolean removeFirstOccurrence(E data) {
        Node<E> currentNode = this.first;
        while (currentNode != null) {
            E currentData = currentNode.data;
            if (currentData.equals(data)) {
                if (currentNode.previous == null) {
                    this.first = currentNode.next;
                    this.first.previous = null;
                    return true;
                } else if (currentNode.next == null) {
                    this.last = currentNode.previous;
                    this.last.next = null;
                    return true;
                } else {
                    currentNode.next.previous = currentNode.previous;
                    currentNode.previous.next = currentNode.next;
                    return true;
                }
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public boolean removeLastOccurrence(E data) {
        Node<E> currentNode = this.last;
        while (currentNode != null) {
            E currentData = currentNode.data;
            if (currentData.equals(data)) {
                if (currentNode.next == null) {
                    this.last = currentNode.previous;
                    this.last.next = null;
                    this.size--;
                    return true;
                } else if (currentNode.previous == null) {
                    this.first = currentNode.next;
                    this.first.previous = null;
                    this.size--;
                    return true;
                } else {
                    currentNode.previous.next = currentNode.next;
                    currentNode.next.previous = currentNode.previous;
                    this.size--;
                    return true;
                }
            }
            currentNode = currentNode.previous;
        }
        return false;
    }

    public void add(E data) {
        this.addLast(data);
    }

    public E remove() {
        return this.removeLast();
    }

    public E poll() {
        return this.removeFirst();
    }

    public E peek() {
        return this.getFirst();
    }

    public void addAll(Collection<? extends E> collection) {
        collection.forEach(this::add);
    }

    public void removeAll(Collection<E> collection) {
        for (E data : collection) {
            if (this.contains(data)) {
                this.remove(data);
            }
        }
    }

    public void clear() {
        //noinspection StatementWithEmptyBody
        while (this.removeLast() != null) {
            // Using side effect.
        }
    }

    public void push(E data) {
        this.addFirst(data);
    }

    public E pop() {
        return this.removeFirst();
    }

    public boolean remove(E data) {
        if (!this.contains(data)) {
            return false;
        }
        while (this.contains(data)) {
            this.removeLastOccurrence(data);
        }
        return true;
    }

    public boolean containsAll(Collection<E> collection) {
        for (E data : collection) {
            if (!this.contains(data)) {
                return false;
            }
        }
        return true;
    }

    public boolean contains(E data) {
        Node<E> currentNode = this.first;
        while (currentNode != null) {
            if (currentNode.data.equals(data)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public Iterator<E> iterator() {
        return new Iterator<>() {
            Node<E> currentNode = first;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public E next() {
                E data = currentNode.data;
                currentNode = currentNode.next;
                return data;
            }
        };
    }

    public E[] toArray(E[] array) {
        if (array.length == 0) {
            return array;
        }
        Node<E> currentNode = this.first;
        for (int i = 0; i < this.size; i++) {
            array[i] = currentNode.data;
            currentNode = currentNode.next;
        }
        return array;
    }

    public Object[] toArray() {
        Object[] array = new Object[this.size];
        Node<E> currentNode = this.first;
        for (int i = 0; i < this.size; i++) {
            array[i] = currentNode.data;
            currentNode = currentNode.next;
        }
        return array;
    }

    public Iterator<E> descendingIterator() {
        return new Iterator<>() {
            Node<E> currentNode = last;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public E next() {
                E data = currentNode.data;
                currentNode = currentNode.previous;
                return data;
            }
        };
    }

    private static class Node<E> {
        private Node<E> next;
        private Node<E> previous;
        private final E data;

        private Node(E data) {
            if (data == null) {
                throw new IllegalArgumentException("Data must not be null");
            }
            this.data = data;
        }
    }
}
