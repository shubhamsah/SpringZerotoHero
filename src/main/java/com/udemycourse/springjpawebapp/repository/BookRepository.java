package com.udemycourse.springjpawebapp.repository;

import com.udemycourse.springjpawebapp.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
