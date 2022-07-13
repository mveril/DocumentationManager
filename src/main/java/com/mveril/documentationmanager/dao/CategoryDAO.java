package com.mveril.documentationmanager.dao;

import com.mveril.documentationmanager.entity.Category;
import javax.persistence.EntityManager;
import com.mveril.documentationmanager.dao.DAO;

public class CategoryDAO extends DAO<Category> {
    public CategoryDAO(EntityManager entityManager) {
        super(Category.class, entityManager);
    }
}
