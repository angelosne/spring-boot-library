package com.example.library.bookshelf;

import org.springframework.stereotype.Service;

@Service
public class BookshelfService {
    private BookshelfRepository repository;
    private BookshelfEntityToResponseMapper bookshelfEntityToResponseMapper;
    private BookshelfInputToEntityMapper bookshelfInputToEntityMapper;

    public BookshelfService(BookshelfRepository repository, BookshelfEntityToResponseMapper bookshelfEntityToResponseMapper, BookshelfInputToEntityMapper bookshelfInputToEntityMapper) {
        this.repository = repository;
        this.bookshelfEntityToResponseMapper = bookshelfEntityToResponseMapper;
        this.bookshelfInputToEntityMapper = bookshelfInputToEntityMapper;
    }
}
