package com.example.library.bookshelf;

public class BookshelfResponse {
    private long id;
    private int numberOfBooks;
    private String country;
    private boolean isFull;

    public BookshelfResponse(long id, int numberOfBooks, String country, boolean isFull) {
        this.id = id;
        this.numberOfBooks = numberOfBooks;
        this.country = country;
        this.isFull = isFull;
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

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }
}
