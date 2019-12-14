package com.example.library.bookshelf;

public class BookshelfInput {

    private int numberOfBooks;
    private String country;
    private int bookCapacity;

    public BookshelfInput(int numberOfBooks, String country, int bookCapacity) {
        this.numberOfBooks = numberOfBooks;
        this.country = country;
        this.bookCapacity = bookCapacity;
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
