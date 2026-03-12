package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.entity.User;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.UserRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepo;

    @Autowired
    private UserRepository userRepo;

    // ADD CATEGORY
    public Category addCategory(Category category) {

        if (category.getCreatedBy() == null || category.getCreatedBy().getId() == null) {
            throw new RuntimeException("User ID is required to create category");
        }

        Integer userId = category.getCreatedBy().getId();

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        category.setCreatedBy(user);

        return categoryRepo.save(category);
    }

    // GET ALL CATEGORIES BY USER
    public List<Category> getAllCategories(int userId) {
        return categoryRepo.findByCreatedByIdAndIsActiveTrue(userId);
    }

    // SOFT DELETE CATEGORY
    public void deleteCategory(int id) {

        Category category = categoryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        category.setIsActive(false);

        categoryRepo.save(category);
    }
}