package edu.miu.cs489.citylibrary.service;

import edu.miu.cs489.citylibrary.model.Address;
import edu.miu.cs489.citylibrary.model.Publisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PublisherService {
    Optional<Publisher> addNewPublisher(Publisher publisher);
    Optional<Publisher> findByPublisherName(String publisherName);
    void deletePublisher(String publisherName);
    Optional<Publisher> modifyPublisherName(String existingPublisherName, String newPublisherName);
    Optional<Publisher> modifyPublisherAddress(String existingPublisherName, Address address);
}
