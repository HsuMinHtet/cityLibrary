package edu.miu.cs489.citylibrary.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name="books")
@NoArgsConstructor
@Setter
@Getter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="book_id")
    private Integer bookId;
    private String title;
    @NotBlank(message = "Not null - No empty - No Blank")
    private String ISBN;
    //Book has publisher
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="publisher_id")
    private Publisher publisher;//Book->---||-Publisher
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="book_authors",
            joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn(name="author_id")
    )
    private List<Author> authors;

    public Book(String title, String ISBN) {
        this.title = title;
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", publisher=" + publisher +
                '}';
    }
}
