package br.wallace.curso.spring.curso.spring.data.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category")
public class CategoryEntity implements Serializable {
    private static final long SERIAL_VERSION_UID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 40, nullable = false)
    private String name;


    @JsonManagedReference
    //Faz referência ao mapeamento criado na classe ProductEntity
    @ManyToMany(mappedBy = "categories")
    private List<ProductEntity> products = new ArrayList<>();
}

