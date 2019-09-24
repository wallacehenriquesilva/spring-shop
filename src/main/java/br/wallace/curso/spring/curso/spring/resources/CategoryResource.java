package br.wallace.curso.spring.curso.spring.resources;

import br.wallace.curso.spring.curso.spring.data.entities.CategoryEntity;
import br.wallace.curso.spring.curso.spring.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryResource {
    private final CategoryService categoryService;

    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryEntity>> getCategories() {
        return ResponseEntity.ok().body(categoryService.findAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryEntity> getCategoriesFromId(@Valid @PathVariable("id") long id) {
        return ResponseEntity.ok().body(categoryService.findCategoryById(id));
    }
}
