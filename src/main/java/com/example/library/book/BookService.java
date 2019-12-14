package com.example.library.book;

import org.springframework.stereotype.Service;

@Service
public class BookService {
    private BookRepository repository;
    private BookEntityToResponseMapper bookEntityToResponseMapper;
    private BookInputToEntityMapper bookInputToEntityMapper;

    public BookService(BookRepository repository, BookEntityToResponseMapper bookEntityToResponseMapper, BookInputToEntityMapper bookInputToEntityMapper) {
        this.repository = repository;
        this.bookEntityToResponseMapper = bookEntityToResponseMapper;
        this.bookInputToEntityMapper = bookInputToEntityMapper;
    }

}
