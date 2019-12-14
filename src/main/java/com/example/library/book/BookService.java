package com.example.library.book;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<BookResponse> getAllBooks() {
        Iterable<Book> bookIterable = repository.findAll();
        List<BookResponse> booksToReturn = new ArrayList<>();
        for (Book book : bookIterable) {
            booksToReturn.add(bookEntityToResponseMapper.apply(book));
        }
        return booksToReturn;
    }

    public BookResponse createBook(BookInput input) {
        Book bookToBeSaved = bookInputToEntityMapper.apply(input);
        return bookEntityToResponseMapper.apply(repository.save(bookToBeSaved));
    }

    public BookResponse updateBook(BookInput input, long id) throws BookNotFoundException {
        Optional<Book> retrievedBook = repository.findById(id);
        if (retrievedBook.isEmpty())
            throw new BookNotFoundException();

        else {
            Book bookToUpdate = retrievedBook.get();
            if (input.getTitle() != null)
                bookToUpdate.setTitle(input.getTitle());
            if (input.getDescription() != null)
                bookToUpdate.setDescription(input.getDescription());
            if (input.getAuthorName() != null)
                bookToUpdate.setAuthorName(input.getAuthorName());
            if (input.getAuthorLastname() != null)
                bookToUpdate.setAuthorLastname(input.getAuthorLastname());
            if (input.getGenre() != null)
                bookToUpdate.setGenre(input.getGenre());
            if (input.getBookshelf() != null)
                bookToUpdate.setBookshelf(input.getBookshelf());
            if (input.getNumberOfPages() != null)
                bookToUpdate.setNumberOfPages(input.getNumberOfPages());

            Book savedBook = repository.save(bookToUpdate);
            return bookEntityToResponseMapper.apply(savedBook);
        }

    }

    public BookResponse deleteBook(long id) throws BookNotFoundException {
        Optional<Book> retrievedBook = repository.findById(id);
        if (retrievedBook.isEmpty())
            throw new BookNotFoundException();

        else {
            Book bookToDelete = retrievedBook.get();
            repository.deleteById(id);
            return bookEntityToResponseMapper.apply(bookToDelete);
        }
    }

}
