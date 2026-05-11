package org.example.livedemohibernate;

import org.example.livedemohibernate.Book.Book;
import org.example.livedemohibernate.Book.BookRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LiveDemoHibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiveDemoHibernateApplication.class, args);
    }

/*
    @Bean
    public CommandLineRunner demo(BookRepo repo){
        return (args) -> {
            repo.save(new Book("Röda rummet", "Strindberg"));
            repo.save(new Book("Inferno", "Strindberg"));
            repo.save(new Book("Hemsöborna", "Strindberg"));
            repo.save(new Book("Herr Arnes Penningar", "Lagerlöf"));
        };
    }
    */

}
