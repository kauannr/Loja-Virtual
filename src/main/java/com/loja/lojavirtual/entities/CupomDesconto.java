package com.loja.lojavirtual.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CupomDesconto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false, unique = true)
    private String codigo;

    @Column(nullable = false)
    private String descricao;

    @Min(value = 0, message = "Desconto fixo não pode ser negativo")
    private Double valorDescontoFixo;

    @Column(nullable = false) 
    @Min(value = 0, message = "Porcentagem de desconto nao pode ser negativa")
    @Max(value = 90, message = "Porcentagem excede o valor máximo")
    private Double porcentagemDesconto;

    @Column(nullable = false)
    @FutureOrPresent(message = "Data de vencimento não pode ser no passado")
    private LocalDate dataVencimento;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @UpdateTimestamp
    private LocalDateTime dataAtualizacao;

    private boolean ativo = true;

}
