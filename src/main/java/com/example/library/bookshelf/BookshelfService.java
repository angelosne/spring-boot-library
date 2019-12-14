package com.example.library.bookshelf;

import com.example.library.book.Book;
import com.example.library.book.BookResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<BookshelfResponse> getAllBookshelves(){
        Iterable<Bookshelf> bookIterable = repository.findAll();
        List<BookshelfResponse> bookshelvesToReturn = new ArrayList<>();
        for (Bookshelf bookshelf : bookIterable) {
            bookshelvesToReturn.add(bookshelfEntityToResponseMapper.apply(bookshelf));
        }
        return bookshelvesToReturn;

    }

    public BookshelfResponse createBookshelf(BookshelfInput input){
        Bookshelf createdBook = repository.save(bookshelfInputToEntityMapper.apply(input));
        return bookshelfEntityToResponseMapper.apply(createdBook);
    }
}

