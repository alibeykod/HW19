package ir.maktabsharif.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Book {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String title;
    private String author;
    private Integer availableCopies;
    private double price;

    public Book(Long id, String title, String author, Integer availableCopies, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.availableCopies = availableCopies;
        this.price = price;
    }

    public Book(String title, String author, Integer availableCopies , double price) {
        this.title = title;
        this.author = author;
        this.availableCopies = availableCopies;
        this.price =price;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(Integer availableCopies) {
        this.availableCopies = availableCopies;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, availableCopies , price);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", availableCopies=" + availableCopies +
                ", price = " + price +
                '}';
    }
}
