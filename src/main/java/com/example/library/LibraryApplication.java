package com.example.library;

import com.example.library.book.BookRepository;
import com.example.library.bookshelf.BookshelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner {

	@Autowired
	BookRepository bookRepository;
	@Autowired
	BookshelfRepository bookshelfRepository;

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
