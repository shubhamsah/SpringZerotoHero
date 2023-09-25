package com.udemycourse.springjpawebapp.bootstrap;

import com.udemycourse.springjpawebapp.entity.Author;
import com.udemycourse.springjpawebapp.entity.Book;
import com.udemycourse.springjpawebapp.entity.Publisher;
import com.udemycourse.springjpawebapp.repository.AuthorRepository;
import com.udemycourse.springjpawebapp.repository.BookRepository;
import com.udemycourse.springjpawebapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("Penguin publications");
        publisher.setCity("Mumbai");
        publisher.setState("Maharashtra");
        publisher.setZip("400000");

        publisherRepository.save(publisher);


        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "121221212");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rodJohnson = new Author("Rod", "Johnson");
        Book noEjb = new Book("J2EE Development without EJB", "121221000212");

        rodJohnson.getBooks().add(noEjb);
        noEjb.getAuthors().add(rodJohnson);

        noEjb.setPublisher(publisher);
        publisher.getBooks().add(noEjb);

        authorRepository.save(rodJohnson);
        bookRepository.save(noEjb);
        publisherRepository.save(publisher);


        System.out.println("Number of books: "+ bookRepository.count());

        System.out.println("Number of Books for publisher : "+ publisher.getBooks().size());
    }
}
