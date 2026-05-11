package org.example.livedemohibernate.Book;

import jakarta.websocket.server.PathParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookRepo repo ;
    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    public BookController(BookRepo bookRepo) {
        repo = bookRepo;
    }

    @PostMapping("/book")
    public Book addBook(@RequestBody Book book) {
        repo.save(book);
        log.info("Book added successfully");
        return book;
    }


    @GetMapping("/books")
    public List<Book> getBooks() {
        return repo.findAll();
    }

    @DeleteMapping("/book/{id}")
    public List<Book> deleteBook(@PathVariable Long id) {
        repo.deleteById(id);
        log.info("Book deleted with id "+ id);
        return repo.findAll();
    }

    @GetMapping("/books/{author}")
    public List<Book> getBooksByAuthor(@PathVariable String author) {
        return repo.findBooksByAuthorIgnoreCase(author);
    }

    @GetMapping("/books/{oldAuthor}/{newAuthor}")
    public List<Book> getBooksByAuthor(@PathVariable String oldAuthor, @PathVariable String newAuthor) {
        repo.updateAuthorName(oldAuthor, newAuthor);
        return repo.findAll();
    }

    @GetMapping("/books/getAmount")
    public List<StatUtilDTO> getAMountOfBooks() {
        return repo.getAmountsOfBooks();

    }




}
