package com.lgs.laziv.lesson2_junit;

public class MyLinkedList<E> {
    private int size;
    private Node<E> first;
    private Node<E> last;

    public void add(E element) {
        Node<E> node = new Node<>(element, last, null);
        if (last != null) {
            last.next = node;
        } else {
            first = node;
        }
        last = node;
        size++;
    }

    public void addFirst(E element) {
        Node<E> node = new Node<>(element, null, first);
        if (first != null) {
            first.prev = node;
        } else {
            last = node;
        }
        first = node;
        size++;
    }


    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            addFirst(element);
        } else if (index == size) {
            add(element);
        } else {
            Node<E> node = getNode(index - 1);
            Node<E> newNode = new Node<E>(element, node, node.next);
            node.next = newNode;
            newNode.next.prev = newNode;
            size++;
        }
    }

    public E get(int index) {
        checkIndex(index);
        return getNode(index).element;
    }

    public E set(int index, E element) {
        checkIndex(index);
        Node<E> node = getNode(index);

        E oldElement = node.element;
        node.element = element;
        return oldElement;
    }

    public E remove(int index) {
        checkIndex(index);
        Node<E> node = getNode(index);

        if (node.prev == null) {
            first = node.next;
        } else if (node.next == null) {
            last = node.prev;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        E remoteElement = node.element;
        node = null;
        size--;
        return remoteElement;
    }

    public int size() {
        return size;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }
    }

    private Node<E> getNode(int index) {
        Node<E> node;

        if (index <= (size / 2)) {
            node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node;
    }

    private static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }
}