package br.com.cineflix.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cineflix.entity.Category;
import br.com.cineflix.repository.CategoryRepository;

@Service 
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepositor) {
        this.categoryRepository = categoryRepositor;
    }

    public List<Category> findAll(){
        return findAll();
    }

}
