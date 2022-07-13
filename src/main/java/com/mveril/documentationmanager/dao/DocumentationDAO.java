package com.mveril.documentationmanager.dao;

import com.mveril.documentationmanager.entity.Documentation;
import javax.persistence.EntityManager;
import org.mveril.documentationmanager.dao.DAO;

public class DocumentationDAO extends DAO<Documentation> {
    public DocumentationDAO(EntityManager entityManager) {
        super(Documentation.class, entityManager);
    }
}
