package br.wallace.curso.spring.curso.spring.resources.exceptions.handlers.model;

import lombok.*;

import javax.persistence.Entity;
import java.io.Serializable;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class StandardExceptionModel implements Serializable {
    private static final long SERIAL_VERSION_UID = 1L;

    private int status;
    private String message;
    private long timestamp;
}
