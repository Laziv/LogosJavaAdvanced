package com.lgs.laziv.lesson4_jdbc.entity;

import java.time.LocalDate;

public class Book {
    private int id;
    private String name;
    private String description;
    private LocalDate dateOfPublication;
    private String author;
    private String category;

    public Book(int id, String name, String description, LocalDate dateOfPublication, String author, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateOfPublication = dateOfPublication;
        this.author = author;
        this.category = category;
    }

    public Book(String name, String description, LocalDate dateOfPublication, String author, String category) {
        this.name = name;
        this.description = description;
        this.dateOfPublication = dateOfPublication;
        this.author = author;
        this.category = category;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(LocalDate dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dateOfPublication=" + dateOfPublication +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

