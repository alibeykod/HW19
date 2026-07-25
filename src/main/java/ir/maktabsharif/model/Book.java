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
}
