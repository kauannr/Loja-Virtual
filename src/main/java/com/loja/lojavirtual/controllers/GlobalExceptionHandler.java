package com.loja.lojavirtual.controllers;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handlerConstraintViolation(ConstraintViolationException exception) {

        StringBuilder mensagensErro = new StringBuilder("Erros de validação: ");

        exception.getConstraintViolations().forEach(violacao -> {
            mensagensErro.append(violacao.getPropertyPath())
                    .append(" - ")
                    .append(violacao.getMessage())
                    .append("; ");
        });

        return ResponseEntity.badRequest().body(mensagensErro.toString());
    }

    @ExceptionHandler(org.hibernate.exception.ConstraintViolationException.class)
    public ResponseEntity<String> handlerDataBaseConstraintViolation(
            org.hibernate.exception.ConstraintViolationException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("Erro de violação. Constraint: " + exception.getConstraintName());
    }

}
