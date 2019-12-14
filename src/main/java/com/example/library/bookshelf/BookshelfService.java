package com.example.library.bookshelf;

import com.example.library.book.Book;
import com.example.library.book.BookResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<BookshelfResponse> getAllBookshelves() {
        Iterable<Bookshelf> bookIterable = repository.findAll();
        List<BookshelfResponse> bookshelvesToReturn = new ArrayList<>();
        for (Bookshelf bookshelf : bookIterable) {
            bookshelvesToReturn.add(bookshelfEntityToResponseMapper.apply(bookshelf));
        }
        return bookshelvesToReturn;

    }

    public BookshelfResponse createBookshelf(BookshelfInput input) {
        Bookshelf createdBook = repository.save(bookshelfInputToEntityMapper.apply(input));
        return bookshelfEntityToResponseMapper.apply(createdBook);
    }

    public BookshelfResponse updateBookshelf(BookshelfInput input, long id) throws BookshelfNotFoundException {
        Optional<Bookshelf> retrievedBookshelf = repository.findById(id);
        if (retrievedBookshelf.isEmpty())
            throw new BookshelfNotFoundException();
        else {
            Bookshelf bookshelfToUpdate = retrievedBookshelf.get();
            if (input.getNumberOfBooks() != null)
                bookshelfToUpdate.setNumberOfBooks(input.getNumberOfBooks());
            if (input.getBookCapacity() != null)
                bookshelfToUpdate.setBookCapacity(input.getBookCapacity());
            if (input.getCountry() != null)
                bookshelfToUpdate.setCountry(input.getCountry());
            Bookshelf savedBookshelf = repository.save(bookshelfToUpdate);
            return bookshelfEntityToResponseMapper.apply(savedBookshelf);
        }
    }

    public BookshelfResponse deleteBookshelf(long id) throws BookshelfNotFoundException {
        Optional<Bookshelf> retrievedBookshelf = repository.findById(id);
        if (retrievedBookshelf.isEmpty())
            throw new BookshelfNotFoundException();
        else {
            Bookshelf bookshelfToDelete = retrievedBookshelf.get();
            repository.deleteById(id);
            return bookshelfEntityToResponseMapper.apply(bookshelfToDelete);
        }

    }

}

