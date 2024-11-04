package edu.miu.cs489.citylibrary.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="author_id")
    private Integer authorId;
    private String firstName;
    private String lastName;
    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

    public Author(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
