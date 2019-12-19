package com.example.library.book;

import com.example.library.bookshelf.Bookshelf;
import com.example.library.bookshelf.BookshelfNotFoundException;
import com.example.library.bookshelf.BookshelfNullException;
import com.example.library.bookshelf.BookshelfRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BookRepository repository;
    private BookshelfRepository bookshelfRepository;
    private BookEntityToResponseMapper bookEntityToResponseMapper;
    private BookInputToEntityMapper bookInputToEntityMapper;

    public BookService(BookRepository repository, BookshelfRepository bookshelfRepository, BookEntityToResponseMapper bookEntityToResponseMapper, BookInputToEntityMapper bookInputToEntityMapper) {
        this.repository = repository;
        this.bookshelfRepository = bookshelfRepository;
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

    public BookResponse createBook(BookInput input) throws BookshelfNotFoundException {
        Optional<Bookshelf> retrievedBookshelf = bookshelfRepository.findById(input.getBookshelfId());
        if (retrievedBookshelf.isEmpty())
            throw new BookshelfNotFoundException();

        Book bookToBeSaved = bookInputToEntityMapper.apply(input);
        bookToBeSaved.setBookshelf(retrievedBookshelf.get());
        return bookEntityToResponseMapper.apply(repository.save(bookToBeSaved));
    }

    public BookResponse updateBook(BookInput input, Long id) throws BookNotFoundException, BookshelfNotFoundException {

        Optional<Book> retrievedBook = repository.findById(id);

        if (retrievedBook.isEmpty())
            throw new BookNotFoundException();

        Book bookToUpdate = retrievedBook.get();
        bookToUpdate.setBookshelf(retrievedBook.get().getBookshelf());
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
        if (input.getBookshelfId() != null) {
            Optional<Bookshelf> retrievedBookshelf = bookshelfRepository.findById(input.getBookshelfId());
            if (retrievedBookshelf.isEmpty()) {
                throw new BookshelfNotFoundException();
            }
            bookToUpdate.setBookshelf(retrievedBookshelf.get());
        }

        if (input.getNumberOfPages() != null)
            bookToUpdate.setNumberOfPages(input.getNumberOfPages());

        Book savedBook = repository.save(bookToUpdate);
        return bookEntityToResponseMapper.apply(savedBook);


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

    public List<BookResponse> selectBooksByGenre(BookGenre genre) {
        Iterable<Book> bookIterable = repository.findAll();
        List<BookResponse> booksToReturn = new ArrayList<>();
        for (Book book : bookIterable) {
            if (book.getGenre() == genre)
                booksToReturn.add(bookEntityToResponseMapper.apply(book));
        }
        return booksToReturn;
    }

}
