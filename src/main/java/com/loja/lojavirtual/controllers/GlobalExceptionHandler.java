package com.loja.lojavirtual.controllers;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handlerMethodArgummentNotValid(MethodArgumentNotValidException ex) {

        Map<String, String> errorsMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(erro -> {
            errorsMap.put(erro.getField(), erro.getDefaultMessage());
        });

        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("error", "Validation Error");
        response.put("message", errorsMap);
        response.put("timestemp", LocalDate.now());

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, Object>> handlerConstraintViolation(ConstraintViolationException ex) {

        Map<String, String> errorsMap = new HashMap<>();
        ex.getConstraintViolations().forEach(violacao -> {
            errorsMap.put(violacao.getPropertyPath().toString(), violacao.getMessage());
        });

        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("error", "Validation Error");
        response.put("message", errorsMap);
        response.put("timestemp", LocalDate.now());

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(org.hibernate.exception.ConstraintViolationException.class)
    public ResponseEntity<String> handlerDataBaseConstraintViolation(
            org.hibernate.exception.ConstraintViolationException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("Erro de violação. Constraint: " + exception.getConstraintName());
    }

}
