package com.example.library.bookshelf;

import org.springframework.data.repository.CrudRepository;

public interface BookshelfRepository extends CrudRepository<Bookshelf , Long> {
}
