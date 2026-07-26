package ir.maktabsharif.repository.impl;

import ir.maktabsharif.exception.DatabaseOperationException;
import ir.maktabsharif.model.Member;
import ir.maktabsharif.repository.MemberRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.Optional;

public class MemberRepositoryImpl implements MemberRepository {
    private final EntityManagerFactory emf;

    public MemberRepositoryImpl(EntityManagerFactory emf){
        this.emf = emf;
    }
    @Override
    public void save(Member member) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try(em) {
            tx.begin();
            em.persist(member);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
            throw new DatabaseOperationException("Member Did Not Save " + e.getMessage());
        }
    }

    @Override
    public void update(Member member) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try (em){
            tx.begin();
            Member oldMember = em.find(Member.class , member.getId());
            oldMember.setFullName(member.getFullName());
            oldMember.setPhoneNumber(member.getPhoneNumber());
            tx.commit();
        }catch (Exception e){
            tx.rollback();
            throw new DatabaseOperationException("Member Did Not Update " + e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try (em){
            tx.begin();
            em.remove(findById(id));
            tx.commit();
        }catch (Exception e){
            tx.rollback();
            throw new DatabaseOperationException("Member Did Not Delete " + e.getMessage());
        }
    }

    @Override
    public Optional<Member> findById(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try (em){
            tx.begin();
            Optional<Member> member = Optional.ofNullable(em.find(Member.class , id));
            tx.commit();
            return member;
        }catch (Exception e){
            tx.rollback();
            throw new DatabaseOperationException("Member Has Not Been Found " + e.getMessage());
        }
    }
}
