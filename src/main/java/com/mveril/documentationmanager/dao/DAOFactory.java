package com.mveril.documentationmanager.dao;

import javax.persistence.*;

public class DAOFactory {
    private static EntityManager entityManager;

    public static EntityManager getEntityManager() {

        if(entityManager == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("doc");
            entityManager = emf.createEntityManager();
        }

        return entityManager;
    }

    private static CategoryDAO categoryDAO = null;
    public static CategoryDAO getCategoryDAO() {

        if(categoryDAO == null) {
            categoryDAO = new CategoryDAO(getEntityManager());
        }
        return  categoryDAO;
    }

    private static DocumentationDAO documentationDAO = null;
    public static DocumentationDAO getDocumentationDAO() {

        if(documentationDAO == null) {
            documentationDAO = new DocumentationDAO(getEntityManager());
        }
        return documentationDAO;
    }
}

