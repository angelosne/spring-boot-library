package com.example.library.book;

import com.example.library.CustomError;
import com.example.library.bookshelf.BookshelfNotFoundException;
import com.example.library.bookshelf.BookshelfNullException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    private BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping(path = "books")
    public ResponseEntity getAllBooks() {
        return new ResponseEntity(service.getAllBooks(), HttpStatus.OK);
    }

    @PostMapping(path = "book")
    public ResponseEntity createBook(@RequestBody BookInput input) {
        try {
            return new ResponseEntity(service.createBook(input), HttpStatus.CREATED);
        } catch (BookshelfNotFoundException e) {
            return new ResponseEntity(new CustomError(0, "Bookshelf not found", "The id you gave does not apply to bookshelf"), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping(path = "book/{id}")
    public ResponseEntity updateBook(@RequestBody BookInput input,
                                     @PathVariable Long id) {
        try {
            return new ResponseEntity(service.updateBook(input, id), HttpStatus.OK);
        } catch (BookNotFoundException e) {
            return new ResponseEntity(new CustomError(0, "Book not found", "The id you gave does not apply to book"), HttpStatus.BAD_REQUEST);
        } catch (BookshelfNotFoundException e) {
            return new ResponseEntity(new CustomError(0, "Bookshelf not found", "The id you gave does not apply to bookshelf"), HttpStatus.BAD_REQUEST);
        }
    }



    @DeleteMapping(path = "book/{id}")
    public ResponseEntity deleteBook(@PathVariable long id) {
        try {
            return new ResponseEntity(service.deleteBook(id), HttpStatus.OK);
        } catch (BookNotFoundException e) {
            return new ResponseEntity(new CustomError(0, "Book not found", "The id you gave does not apply to book"), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "books/{genre}")
    public ResponseEntity selectBooksByGenre(@PathVariable BookGenre genre) {
        return new ResponseEntity(service.selectBooksByGenre(genre) , HttpStatus.OK);
    }
}