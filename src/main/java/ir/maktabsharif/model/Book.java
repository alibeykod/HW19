package ir.maktabsharif.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    private Long id;
    private String title;
    private String author;
    private Integer availableCopies;

    public Book(Long id, String title, String author, Integer availableCopies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public Book(String title, String author, Integer availableCopies) {
        this.title = title;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public Book() {
    }
}
