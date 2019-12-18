package com.example.library.book;

import com.example.library.bookshelf.Bookshelf;


public class BookResponse {

    private long id;
    private String title;
    private String description;
    private String authorFullName;
    private BookGenre genre;
    private int numberOfPages;
    private BookSize size;
    private Bookshelf bookshelf;

    public BookResponse(long id, String title, String description, String authorFullName, BookGenre genre, int numberOfPages, BookSize size, Bookshelf bookshelf) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.authorFullName = authorFullName;
        this.genre = genre;
        this.numberOfPages = numberOfPages;
        this.size = size;
        this.bookshelf = bookshelf;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthorFullName() {
        return authorFullName;
    }

    public void setAuthorFullName(String authorFullName) {
        this.authorFullName = authorFullName;
    }

    public BookGenre getGenre() {
        return genre;
    }

    public void setGenre(BookGenre genre) {
        this.genre = genre;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public BookSize getSize() {
        return size;
    }

    public void setSize(BookSize size) {
        this.size = size;
    }

    public Bookshelf getBookshelf() {
        return bookshelf;
    }

    public void setBookshelf(Bookshelf bookshelf) {
        this.bookshelf = bookshelf;
    }
}