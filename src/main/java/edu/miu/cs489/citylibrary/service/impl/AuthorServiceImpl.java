package edu.miu.cs489.citylibrary.service.impl;

import edu.miu.cs489.citylibrary.model.Author;
import edu.miu.cs489.citylibrary.repository.AuthorRepository;
import edu.miu.cs489.citylibrary.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    @Override
    public Optional<Author> addNewAuthor(Author author) {
        Author savedAuthor= authorRepository.save(author);
        return Optional.of(savedAuthor);
    }
}
