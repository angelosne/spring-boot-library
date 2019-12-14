package com.example.library.book;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<BookResponse> getAllBooks(){
        Iterable<Book> bookIterable = repository.findAll();
        List<BookResponse> booksToReturn = new ArrayList<>();
        for (Book book: bookIterable) {
            booksToReturn.add(bookEntityToResponseMapper.apply(book));
        }
        return booksToReturn;
    }

    public BookResponse createBook(BookInput input){

        Book bookToBeSaved = bookInputToEntityMapper.apply(input);

        return bookEntityToResponseMapper.apply(repository.save(bookToBeSaved));
    }

}
