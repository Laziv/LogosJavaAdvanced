package com.lgs.laziv.lesson4_jdbc.dao;

import com.lgs.laziv.lesson4_jdbc.entity.Book;

import java.util.List;

public interface BookDao {

    Book getBookById(int id);

    List<Book> getListBooks();

    void addBook(Book book);

    void updateBook(Book book);

    void removeBookById(int id);
}
