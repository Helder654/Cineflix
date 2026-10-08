package br.com.cineflix.mapper;

import br.com.cineflix.controller.request.CategoryRequest;
import br.com.cineflix.controller.response.CategoryResponse;
import br.com.cineflix.entity.Category;
import lombok.experimental.UtilityClass;

@UtilityClass 
public class CategoryMapper {

    public static Category toCategory(CategoryRequest categoryRequest){
        return Category
                .builder()
                .name(categoryRequest.name())
                .build();

    }

    public static CategoryResponse toCategoryResponse(Category category){
        return CategoryResponse
                .builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

}
