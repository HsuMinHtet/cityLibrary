package edu.miu.cs489.citylibrary;

import edu.miu.cs489.citylibrary.model.Address;
import edu.miu.cs489.citylibrary.model.Author;
import edu.miu.cs489.citylibrary.model.Book;
import edu.miu.cs489.citylibrary.model.Publisher;
import edu.miu.cs489.citylibrary.repository.PublisherRepository;
import edu.miu.cs489.citylibrary.service.AuthorService;
import edu.miu.cs489.citylibrary.service.BookService;
import edu.miu.cs489.citylibrary.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RequiredArgsConstructor
public class CitylibraryApplication {

    //private  final PublisherRepository publisherRepository;
    private final PublisherService publisherService;
    private final BookService bookService;
    private final AuthorService authorService;

    public static void main(String[] args) {
        SpringApplication.run(CitylibraryApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            //create a publisher object
            Publisher publisher= new Publisher("Apes");
            Address address= new Address("2000 N","Fairfield","IA",52556);
            publisher.setPrimaryAddress(address);
            publisherService.addNewPublisher(publisher);
           // System.out.println(publisher1);

            //Find a publisher by Name
//            Optional<Publisher> foundPublisher= publisherRepository.findByPublisherName("Apes");
//            if(foundPublisher.isPresent()){
//                System.out.println(foundPublisher.get());
//            }

//            publisherRepository.findByPublisherName("Apes").ifPresent(
//                    publisher -> {
//                        System.out.println("Publisher "+publisher.getPublisherName()+" is found");
//                    }
//            );
           //Update the publisher by Name
//            publisherRepository.findByPublisherName("Apes").ifPresent(
//                    publisher -> {
//                        publisher.setPublisherName("Apress");
//                        publisherRepository.save(publisher);
//                    }
//            );
            //Delete the publisher
//            publisherRepository.findByPublisherName("Apress").ifPresent(
//                    publisher -> {
//                        publisherRepository.delete(publisher);
//                    }
//            );

            //1.Create books
            Book book1= new Book("Java","123456789");
            Book book2= new Book("Koltin","987654321");
            //2.Set existing publisher for the newly created books
            publisherService.findByPublisherName("Apes").ifPresent(
                    publisher1 -> book1.setPublisher(publisher1)
            );
            publisherService.findByPublisherName("Apes").ifPresent(
                    publisher1 -> book2.setPublisher(publisher1)
            );
            //3. Create a few authors
            List<Author> authors= List.of(
                    new Author("Tin","Lu"),
                    new Author("John","Lewis"),
                    new Author("Apple","Lewis")
            );
            //save Author
            for(Author author: authors){
                authorService.addNewAuthor(author);
            }
            //4. Set multiple authors for every book
            book1.setAuthors(authors);
            book2.setAuthors(authors);
            //5. save Book
            bookService.addNewBook(book1);
            bookService.addNewBook(book2);
            //6. Display book with book title, isbn, authors and publisher details
            System.out.println(bookService.findBookByISBN("123456789"));
        };

    }

}
