package edu.miu.cs489.citylibrary.service;

import edu.miu.cs489.citylibrary.model.Book;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface BookService {
    Optional<Book> addNewBook(Book book);
    Optional<Book> findBookByISBN(String ISBN);
}
