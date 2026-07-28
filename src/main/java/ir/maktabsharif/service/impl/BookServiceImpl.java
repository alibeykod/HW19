package ir.maktabsharif.service.impl;

import ir.maktabsharif.exception.BookNotFoundException;
import ir.maktabsharif.exception.InvalidDataException;
import ir.maktabsharif.model.Book;
import ir.maktabsharif.repository.BookRepositoryInterface;
import ir.maktabsharif.repository.impl.BookRepositoryImpl;
import ir.maktabsharif.service.BookService;

import java.util.List;


public class BookServiceImpl implements BookService {

BookRepositoryImpl bookRepository = new BookRepositoryImpl();

    @Override
    public void save(Book book) {
        validation(book);
        bookRepository.save(book);
    }

    @Override
    public void update(Book book) {
        validation(book);
        bookRepository.update(book);
    }

    @Override
    public void delete(Long id) throws BookNotFoundException {
        bookRepository.delete(id);
    }

    @Override
    public Book findById(Long id) throws BookNotFoundException {
        return bookRepository.findById(id).orElseThrow(
                () -> new BookNotFoundException("Book Did Not Found")
        );
    }

    private void validation(Book book) {
        if (book.getTitle() == null || book.getTitle().isBlank()){
            throw new InvalidDataException("Title Can Not Be Null Or Empty");
        }
        if (book.getAuthor() == null || book.getAuthor().isBlank()){
            throw new InvalidDataException("Author Can Not Be Null Or Empty");
        }
        if (book.getPrice() < 0){
            throw new InvalidDataException("Price Can Not Be Negative");
        }
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }
}
