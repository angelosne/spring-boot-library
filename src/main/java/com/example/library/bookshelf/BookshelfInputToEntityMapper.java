package com.example.library.bookshelf;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class BookshelfInputToEntityMapper implements Function<BookshelfInput, Bookshelf> {
    @Override
    public Bookshelf apply(BookshelfInput bookshelfInput) {
        return new Bookshelf(
                bookshelfInput.getNumberOfBooks(),
                bookshelfInput.getCountry(),
                bookshelfInput.getBookCapacity()
        );
    }
}
