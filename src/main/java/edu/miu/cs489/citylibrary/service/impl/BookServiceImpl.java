package edu.miu.cs489.citylibrary.service.impl;

import edu.miu.cs489.citylibrary.model.Book;
import edu.miu.cs489.citylibrary.repository.BookRepository;
import edu.miu.cs489.citylibrary.service.BookService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Optional<Book> addNewBook(Book book) {
        Book savedBook= bookRepository.save(book);
        return Optional.of(savedBook);
    }

    @Override
    public Optional<Book> findBookByISBN(String ISBN) {
        return bookRepository.findBookByISBN(ISBN);
    }
}
