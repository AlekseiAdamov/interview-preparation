package ru.alexeiadamov.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class Storage {
    private final EntityManager entityManager;

    private Storage() {
        final EntityManagerFactory factory = SessionFactoryFactory.create();
        entityManager = factory.createEntityManager();
    }

    public static Storage createStorage() {
        return new Storage();
    }

    public void create(Object entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    public Object find(Class<? extends Object> cls, long id) {
        entityManager.getTransaction().begin();
        Object entity = entityManager.find(cls, id);
        entityManager.getTransaction().commit();
        return entity;
    }

    public void update(Object entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    public void delete(Object entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    public List findAll(Class<? extends Object> cls) {
        final String entityName = cls.getSimpleName();
        final String queryText = String.format("from %s", entityName);
        entityManager.getTransaction().begin();
        final Query query = entityManager.createQuery(queryText);
        final List entityList = query.getResultList();
        entityManager.getTransaction().commit();
        return entityList;
    }
}
