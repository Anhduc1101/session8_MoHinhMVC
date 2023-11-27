package com.ra.model.service;

import com.ra.model.dao.CategoryDAO;
import com.ra.model.dao.CategoryDAOImpl;
import com.ra.model.entity.Category;

import java.util.List;

public class CategoryServiceImpl implements CategoryService{
    private final CategoryDAO categoryDAO = new CategoryDAOImpl();
    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public boolean saveOrUpdate(Category category) {
        return categoryDAO.saveOrUpdate(category);
    }

    @Override
    public Category findById(Integer integer) {
        return categoryDAO.findById(integer);
    }

    @Override
    public void delete(Integer integer) {

    }
}
