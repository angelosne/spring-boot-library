package com.example.library.bookshelf;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class BookshelfEntityToResponseMapper implements Function<Bookshelf, BookshelfResponse> {

    @Override
    public BookshelfResponse apply(Bookshelf bookshelf) {
        return new BookshelfResponse(
                bookshelf.getId(),
                bookshelf.getNumberOfBooks(),
                bookshelf.getCountry(),
                mapToisFull(bookshelf)
        );
    }

    private boolean mapToisFull(Bookshelf bookshelf){
        if (bookshelf.getBookCapacity()==bookshelf.getNumberOfBooks())
            return true;
        else
            return false;

    }
}
