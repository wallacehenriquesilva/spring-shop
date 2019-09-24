package br.wallace.curso.spring.curso.spring;

import br.wallace.curso.spring.curso.spring.data.entities.CategoryEntity;
import br.wallace.curso.spring.curso.spring.data.entities.ProductEntity;
import br.wallace.curso.spring.curso.spring.data.repositories.CategoryRepository;
import br.wallace.curso.spring.curso.spring.data.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class CursoSpringApplication implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public CursoSpringApplication(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CursoSpringApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        CategoryEntity categoryEntity1 = CategoryEntity.builder().name("Informática").products(new ArrayList<>()).build();
        CategoryEntity categoryEntity2 = CategoryEntity.builder().name("Escritório").products(new ArrayList<>()).build();

        ProductEntity productEntity1 = ProductEntity.builder().name("Computador").price(2000.00).categories(new ArrayList<>()).build();
        ProductEntity productEntity2 = ProductEntity.builder().name("Impressora").price(800.00).categories(new ArrayList<>()).build();
        ProductEntity productEntity3 = ProductEntity.builder().name("Mouse").price(80.40).categories(new ArrayList<>()).build();

        categoryEntity1.getProducts().addAll(Arrays.asList(productEntity1, productEntity2, productEntity3));
        categoryEntity2.getProducts().addAll(Arrays.asList(productEntity2));

        productEntity1.getCategories().addAll(Arrays.asList(categoryEntity1));
        productEntity2.getCategories().addAll(Arrays.asList(categoryEntity1, categoryEntity2));
        productEntity3.getCategories().addAll(Arrays.asList(categoryEntity1));

        categoryRepository.saveAll(Arrays.asList(categoryEntity1, categoryEntity2));
        productRepository.saveAll(Arrays.asList(productEntity1, productEntity2, productEntity3));
    }
}
