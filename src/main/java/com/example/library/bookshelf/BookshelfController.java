package com.example.library.bookshelf;

import com.example.library.CustomError;
import com.example.library.book.BookInput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookshelfController {
    private BookshelfService service;

    public BookshelfController(BookshelfService service) {
        this.service = service;
    }

    @GetMapping(path = "bookshelves")
    public ResponseEntity getAllBookselves() {
        return new ResponseEntity(service.getAllBookshelves(), HttpStatus.OK);
    }

    @PostMapping(path = "bookshelf")
    public ResponseEntity createBookshelf(@RequestBody BookshelfInput input) {
        return new ResponseEntity(service.createBookshelf(input), HttpStatus.CREATED);
    }

    @PatchMapping(path = "bookshelf/{id}")
    public ResponseEntity updateBookshelf(@RequestBody BookshelfInput input,
                                          @PathVariable long id){
        try {
            return new ResponseEntity(service.updateBookshelf(input,id),HttpStatus.OK);
        } catch (BookshelfNotFoundException e) {
            return new ResponseEntity(new CustomError(0, "Bookshelf not found", "The id you gave does not apply to bookshelf"),HttpStatus.BAD_REQUEST);
        }
    }
}
