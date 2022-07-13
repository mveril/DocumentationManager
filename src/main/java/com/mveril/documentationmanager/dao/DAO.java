package com.mveril.documentationmanager.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public abstract class DAO<T> {

    private Class<T> type;

    protected final EntityManager entityManager;

    public DAO(Class<T> type,EntityManager entityManager) {
        this.type = type;
        this.entityManager = entityManager;
    }

    public void create(T itemToCreate) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(itemToCreate);
        tx.commit();
    }

    public Optional<T> findById(long id) {
        T item = entityManager.find(type, id);
        return Optional.of(item);
    }

    public List<T> findAll() {
        Query findAllQuery = entityManager.createQuery("select i from "+type.getName()+" i");
        return findAllQuery.getResultList();
    }

    public void delete(T item) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(item);
        tx.commit();
    }

    public boolean delete(int id) {
        Optional<T> itemToDelete = findById(id);
        if(itemToDelete.isPresent()){
            delete(itemToDelete.get());
            return true;
        }
        return false;
    }

    public void update(T item) {
        EntityTransaction tx = null;
        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(item);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
    }
}
