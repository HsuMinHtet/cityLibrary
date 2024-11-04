package edu.miu.cs489.citylibrary.service.impl;

import edu.miu.cs489.citylibrary.model.Address;
import edu.miu.cs489.citylibrary.model.Publisher;
import edu.miu.cs489.citylibrary.repository.PublisherRepository;
import edu.miu.cs489.citylibrary.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {

    private  final PublisherRepository publisherRepository;
    @Override
    public Optional<Publisher> addNewPublisher(Publisher publisher) {
       Publisher savePublisher= publisherRepository.save(publisher);
        return Optional.of(savePublisher);
    }

    @Override
    public Optional<Publisher> findByPublisherName(String publisherName) {
        return publisherRepository.findByPublisherName(publisherName);
    }

    @Override
    public void deletePublisher(String publisherName) {
        //check publisher is present
        publisherRepository.findByPublisherName(publisherName).ifPresent(
                publisher ->   publisherRepository.delete(publisher)
        );

    }

    @Override
    public Optional<Publisher> modifyPublisherName(String existingPublisherName, String newPublisherName) {
        Optional<Publisher> foundPublisher=publisherRepository.findByPublisherName(existingPublisherName);
        foundPublisher.ifPresent(
                publisher -> publisher.setPublisherName(newPublisherName)
        );
        return foundPublisher;
    }

    @Override
    public Optional<Publisher> modifyPublisherAddress(String existingPublisherName, Address address) {
        Optional<Publisher> foundPublisher=publisherRepository.findByPublisherName(existingPublisherName);
        foundPublisher.ifPresent(publisher -> publisher.setPrimaryAddress(address));
        return foundPublisher;
    }

}
