package edu.miu.cs489.citylibrary.repository;

import edu.miu.cs489.citylibrary.model.Book;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Integer> {

    Optional<Book> findBookByISBN(String ISBN);
}
