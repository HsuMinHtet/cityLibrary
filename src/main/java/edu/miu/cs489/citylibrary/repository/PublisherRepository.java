package edu.miu.cs489.citylibrary.repository;

import edu.miu.cs489.citylibrary.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PublisherRepository extends JpaRepository<Publisher,Integer> {

    Optional<Publisher> findByPublisherName(String publisherName);
}
