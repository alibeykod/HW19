package ir.maktabsharif.util;

import ir.maktabsharif.exception.BookNotFoundException;
import ir.maktabsharif.model.Book;
import ir.maktabsharif.repository.impl.BookRepositoryImpl;

import java.util.Comparator;

public class StreamReports {
BookRepositoryImpl bookRepository = new BookRepositoryImpl();

    //total Number Of Books
    public int totalNumberOfBooks(){
        return  bookRepository.findAll().size() ;
    }

    //Average Book Price
    public double averageBookPrice(){
        return bookRepository.findAll().stream()
                .mapToDouble(Book::getPrice)
                .average()
                .orElse(0.0);
    }

    //Most Expensive Book
    public Book mostExpensiveBook() throws BookNotFoundException {
        return bookRepository.findAll().stream()
                .max(Comparator.comparingDouble(Book::getPrice))
                .orElseThrow(
                        ()->new BookNotFoundException("Book Not Found ")
                );
    }
}
