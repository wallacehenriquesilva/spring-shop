package br.wallace.curso.spring.curso.spring.services;


import br.wallace.curso.spring.curso.spring.data.entities.CategoryEntity;
import br.wallace.curso.spring.curso.spring.data.repositories.CategoryRepository;
import br.wallace.curso.spring.curso.spring.services.exceptions.CategoryNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryEntity> findAllCategories() {
        return categoryRepository.findAll();
    }

    public CategoryEntity findCategoryById(final long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(String.format("Categoria %s não encontrada!", id)));
    }
}
