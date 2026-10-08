package br.com.cineflix.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.cineflix.entity.Category;
import br.com.cineflix.repository.CategoryRepository;

@Service 
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }
    
    public Optional<Category> findById(Long id){
        return categoryRepository.findById(id);
    }

    public void deleteById(Long id){
        categoryRepository.deleteById(id);
    }
}
