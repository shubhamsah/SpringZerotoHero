package com.udemycourse.springjpawebapp.repository;

import com.udemycourse.springjpawebapp.entity.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
