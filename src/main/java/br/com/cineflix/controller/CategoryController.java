package br.com.cineflix.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cineflix.entity.Category;
import br.com.cineflix.service.CategoryService;

@RestController
@RequestMapping("/cineflix/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public List<Category> getAllCategory(){
        return categoryService.findAll();
    } 

    @PostMapping 
    public Category saveCategory(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }
}
