package ir.maktabsharif.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DatabaseConfig {
    public static EntityManagerFactory getEmf(){
        return Persistence.createEntityManagerFactory("postgres-pu");
    }
}
