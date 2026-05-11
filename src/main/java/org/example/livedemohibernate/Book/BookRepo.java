package org.example.livedemohibernate.Book;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, Long> {

    public List<Book> findBooksByAuthorIgnoreCase(String author);

    @Modifying
    @Transactional
    @Query ("update Book set author=:newAuthor where author=:oldAuthor")
    public void updateAuthorName(String oldAuthor, String newAuthor);

    //select author, count(*) from Books group by author
    @Query (value = "select new org.example.livedemohibernate.Book.StatUtilDTO(author, count(author) )" +
            " from Book group by author")
    public List<StatUtilDTO> getAmountsOfBooks();

}
