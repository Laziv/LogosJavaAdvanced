package com.lgs.laziv.lesson4_jdbc;

import com.lgs.laziv.lesson4_jdbc.dao.BookDao;
import com.lgs.laziv.lesson4_jdbc.dao.BookDaoImpl;
import com.lgs.laziv.lesson4_jdbc.entity.Book;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        BookDao bookDao = new BookDaoImpl(ConnectionManager.createConnection());

        bookDao.addBook(new Book("Коли впаде темрява", "", LocalDate.now(), "Стівен Кінг", "Фантастика"));
        bookDao.addBook(new Book("Психологія впливу", "", LocalDate.now(), "Роберт Чалдіні", "Психологія"));
        System.out.println(bookDao.getListBooks());
        bookDao.removeBookById(2);
        System.out.println(bookDao.getBookById(1));
        bookDao.updateBook(new Book(1, "Людина розумна", "", LocalDate.parse("2016-01-05"), "Ювал Ной Харарі", "Навчальна література"));
        System.out.println(bookDao.getBookById(1));

        ConnectionManager.closeConnection();
    }
}
