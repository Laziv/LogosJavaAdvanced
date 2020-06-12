package com.lgs.laziv.lesson4_jdbc.dao;

import com.lgs.laziv.lesson4_jdbc.entity.Book;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private Connection connection;

    public BookDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Book getBookById(int id) {
        Book book = new Book();

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM books WHERE id = " + id)) {
            resultSet.next();
            book = createBook(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public List<Book> getListBooks() {
        List<Book> books = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM books");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                books.add(createBook(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public void addBook(Book book) {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO books (name, description, date_of_publication, author, category) VALUE(?, ?, ?, ?, ?)")) {
            insertBook(book, statement);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateBook(Book book) {
        try (PreparedStatement statement = connection.prepareStatement(
                "UPDATE books SET name = ?, description = ? , date_of_publication = ?, author = ?, category = ? WHERE id = ?")) {
            statement.setInt(6, book.getId());
            insertBook(book, statement);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void removeBookById(int id) {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM books WHERE id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Book createBook(ResultSet resultSet) throws SQLException {
        Book book = new Book();
        book.setId(resultSet.getInt("id"));
        book.setName(resultSet.getString("name"));
        book.setDescription(resultSet.getString("description"));
        book.setDateOfPublication(LocalDate.parse(resultSet.getString("date_of_publication")));
        book.setAuthor(resultSet.getString("author"));
        book.setCategory(resultSet.getString("category"));
        return book;
    }

    private void insertBook(Book book, PreparedStatement statement) throws SQLException {
        statement.setString(1, book.getName());
        statement.setString(2, book.getDescription());
        statement.setString(3, book.getDateOfPublication().toString());
        statement.setString(4, book.getAuthor());
        statement.setString(5, book.getCategory());
    }
}
