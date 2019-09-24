package br.wallace.curso.spring.curso.spring.data.repositories;

import br.wallace.curso.spring.curso.spring.data.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
