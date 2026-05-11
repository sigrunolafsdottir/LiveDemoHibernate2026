package org.example.livedemohibernate.Book;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @NotEmpty(message="Title is mandatory")
    @Size(min=3, message="At least 3 characters")
    private String title;

    @NotEmpty(message="Author is mandatory")
    private String author;

    @Id
    @GeneratedValue
    private Long id;

}