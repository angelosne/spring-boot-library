package com.example.library.book;

import com.example.library.bookshelf.Bookshelf;


public class BookInput {

    private String title;
    private String description;
    private String authorName;
    private String authorLastname;
    private BookGenre genre;
    private int numberOfPages;
    private Bookshelf bookshelf;

    public BookInput(String title, String description, String authorName, String authorLastname, BookGenre genre, int numberOfPages, Bookshelf bookshelf) {
        this.title = title;
        this.description = description;
        this.authorName = authorName;
        this.authorLastname = authorLastname;
        this.genre = genre;
        this.numberOfPages = numberOfPages;
        this.bookshelf = bookshelf;
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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorLastname() {
        return authorLastname;
    }

    public void setAuthorLastname(String authorLastname) {
        this.authorLastname = authorLastname;
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

    public Bookshelf getBookshelf() {
        return bookshelf;
    }

    public void setBookshelf(Bookshelf bookshelf) {
        this.bookshelf = bookshelf;
    }
}
