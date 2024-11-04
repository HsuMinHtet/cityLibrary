package edu.miu.cs489.citylibrary.repository;

import edu.miu.cs489.citylibrary.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {

}
