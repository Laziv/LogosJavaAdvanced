package com.lgs.laziv.lesson2_junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyLinkedListTest {
    private MyLinkedList<String> linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new MyLinkedList<>();
    }

    @Test
    void newMyLinkedListShouldHaveZeroSize() {
        Assertions.assertEquals(0, linkedList.size());
    }

    @Test
    void testAddElements() {
        linkedList.add("test");
        linkedList.add("test2");
        linkedList.add("test3");
        Assertions.assertEquals("test", linkedList.get(0));
        Assertions.assertEquals("test2", linkedList.get(1));
        Assertions.assertEquals("test3", linkedList.get(2));
    }

    @Test
    void testAddFirstElement() {
        linkedList.addFirst("test");
        Assertions.assertEquals("test", linkedList.get(0));
        linkedList.addFirst("test2");
        Assertions.assertEquals("test2", linkedList.get(0));
    }

    @Test
    void AddWithIncorrectIndexShouldThrowException() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.add(1, "test"));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.add(-1, "test"));
    }

    @Test
    void testAddElementsWithIndex() {
        linkedList.add("test0");
        linkedList.add("test2");
        linkedList.add("test3");
        linkedList.add(1, "test1");
        Assertions.assertEquals("test1", linkedList.get(1));
        Assertions.assertEquals("test3", linkedList.get(3));
    }

    @Test
    void testGetElement() {
        linkedList.add("test");
        Assertions.assertEquals("test", linkedList.get(0));
    }

    @Test
    void getWithIncorrectIndexShouldThrowException() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(-1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(linkedList.size()));
    }

    @Test
    void testSetElement() {
        linkedList.add("test");
        linkedList.set(0, "new");
        Assertions.assertEquals("new", linkedList.get(0));
    }

    @Test
    void testRemoveElement() {
        linkedList.add("test");
        linkedList.add("test1");
        Assertions.assertEquals("test", linkedList.remove(0));
        Assertions.assertEquals("test1", linkedList.get(0));
    }
}