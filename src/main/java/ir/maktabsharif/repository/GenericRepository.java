package ir.maktabsharif.repository;

import java.util.Optional;

public interface GenericRepository <T> {
    void save(T t);
    void update(T t);
    void delete(Long id);
    Optional<T> findById(Long id);

}
