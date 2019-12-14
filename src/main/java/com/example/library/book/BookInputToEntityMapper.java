package com.example.library.book;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class BookInputToEntityMapper implements Function<BookInput , Book> {

    @Override
    public Book apply(BookInput bookInput) {
        return new Book(
                bookInput.getTitle(),
                bookInput.getDescription(),
                bookInput.getAuthorName(),
                bookInput.getAuthorLastname(),
                bookInput.getGenre(),
                bookInput.getNumberOfPages(),
                bookInput.getBookshelf()
        );
    }
}
