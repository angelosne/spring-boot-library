package com.example.library.bookshelf;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookshelfController {
    private BookshelfService service;

    public BookshelfController(BookshelfService service) {
        this.service = service;
    }
}
