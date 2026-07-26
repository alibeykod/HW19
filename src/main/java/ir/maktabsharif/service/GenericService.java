package ir.maktabsharif.service;

import ir.maktabsharif.exception.BusinessException;

import java.util.Optional;

public interface GenericService<T> {
    void save(T t);
    void update(T t);
    void delete(Long id) throws BusinessException;
    T findById(Long id) throws BusinessException;
}
