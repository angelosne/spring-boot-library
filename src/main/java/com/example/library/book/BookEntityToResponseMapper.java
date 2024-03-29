package com.example.library.book;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class BookEntityToResponseMapper implements Function<Book, BookResponse> {
    @Override
    public BookResponse apply(Book book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getDescription(),
                mapFullName(book),
                book.getGenre(),
                book.getNumberOfPages(),
                mapBookSize(book.getNumberOfPages()),
                book.getBookshelf()
        );
    }

    private String mapFullName(Book book) {
        return book.getAuthorName() + " " + book.getAuthorLastname();
    }

    private BookSize mapBookSize(int numberOfPages) {
        if (numberOfPages<= 100)
            return BookSize.SMALL;
        else if (numberOfPages<= 200)
            return BookSize.MEDIUM;
        else
            return BookSize.LARGE;
    }
}
