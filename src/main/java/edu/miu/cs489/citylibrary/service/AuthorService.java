package edu.miu.cs489.citylibrary.service;

import edu.miu.cs489.citylibrary.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorService  {
    Optional<Author> addNewAuthor(Author author);
}
