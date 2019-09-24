package br.wallace.curso.spring.curso.spring.data.repositories;

import br.wallace.curso.spring.curso.spring.data.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
