package ir.maktabsharif.repository.impl;

import ir.maktabsharif.exception.DatabaseOperationException;
import ir.maktabsharif.model.Book;
import ir.maktabsharif.repository.BookRepositoryInterface;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.Optional;

public class BookRepositoryImpl implements BookRepositoryInterface {
    private final EntityManagerFactory emf;

    public BookRepositoryImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void save(Book book) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try (em) {
            tx.begin();
            em.persist(book);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new DatabaseOperationException("Book Did Not Save In DataBase" + e.getMessage());
        }
    }

    @Override
    public void update(Book book) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try (em) {
            tx.begin();
            Book oldBook = em.find(Book.class, book.getId());
            oldBook.setTitle(book.getTitle());
            oldBook.setAuthor(book.getAuthor());
            oldBook.setPrice(book.getPrice());
            oldBook.setAvailableCopies(book.getAvailableCopies());
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new DatabaseOperationException("Book Did Not Update" + e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try (em) {
            tx.begin();
            em.remove(findById(id));
            tx.commit();
        }catch (Exception e){
            tx.rollback();
            throw new DatabaseOperationException("Book did not Deleted !"+ e.getMessage());
        }
    }

    @Override
    public Optional<Book>  findById(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try (em){
            tx.begin();
            Optional<Book> book = Optional.ofNullable(em.find(Book.class , id));
            tx.commit();
            return book;
        }catch (Exception e){
            tx.rollback();
            throw new DatabaseOperationException("Book not Found"+ e.getMessage());
        }
    }
}
