package com.example.library.bookshelf;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bookshelf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int numberOfBooks;
    private String country;
    private int bookCapacity;

    public Bookshelf(int numberOfBooks, String country, int bookCapacity) {
        this.numberOfBooks = numberOfBooks;
        this.country = country;
        this.bookCapacity = bookCapacity;
    }

    public Bookshelf() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getBookCapacity() {
        return bookCapacity;
    }

    public void setBookCapacity(int bookCapacity) {
        this.bookCapacity = bookCapacity;
    }
}
