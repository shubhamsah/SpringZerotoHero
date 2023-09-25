package com.udemycourse.springjpawebapp.repository;

import com.udemycourse.springjpawebapp.entity.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
        }
