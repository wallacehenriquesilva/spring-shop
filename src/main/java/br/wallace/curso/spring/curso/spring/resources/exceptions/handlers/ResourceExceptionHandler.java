package br.wallace.curso.spring.curso.spring.resources.exceptions.handlers;

import br.wallace.curso.spring.curso.spring.resources.exceptions.handlers.model.StandardExceptionModel;
import br.wallace.curso.spring.curso.spring.services.exceptions.CategoryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<StandardExceptionModel> categoryNotFoundException(CategoryNotFoundException categoryNotFoundException,
                                                                            HttpServletRequest httpServletRequest) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(StandardExceptionModel
                .builder()
                .status(HttpStatus.NO_CONTENT.value())
                .message(categoryNotFoundException.getMessage())
                .timestamp(System.currentTimeMillis())
                .build());

    }
}
