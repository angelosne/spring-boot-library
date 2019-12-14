package com.example.library.bookshelf;

public class BookshelfInput {

    private Integer numberOfBooks;
    private String country;
    private Integer bookCapacity;

    public BookshelfInput(Integer numberOfBooks, String country, Integer bookCapacity) {
        this.numberOfBooks = numberOfBooks;
        this.country = country;
        this.bookCapacity = bookCapacity;
    }

    public Integer getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(Integer numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getBookCapacity() {
        return bookCapacity;
    }

    public void setBookCapacity(Integer bookCapacity) {
        this.bookCapacity = bookCapacity;
    }
}
