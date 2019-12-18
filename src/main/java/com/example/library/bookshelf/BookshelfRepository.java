package com.example.library.bookshelf;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookshelfRepository extends CrudRepository<Bookshelf , Long> {
}
