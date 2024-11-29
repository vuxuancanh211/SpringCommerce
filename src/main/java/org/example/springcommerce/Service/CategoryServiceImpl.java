package org.example.springcommerce.Service;

import org.example.springcommerce.Model.Category;
import org.example.springcommerce.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> showCategory() {
        return categoryRepository.findAll();
    }
}
