package com.example.library.book;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    private BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping(path = "books")
    public ResponseEntity getAllBooks(){
        return new ResponseEntity(service.getAllBooks(), HttpStatus.OK);
    }


}
