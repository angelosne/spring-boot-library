package com.example.library.bookshelf;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
