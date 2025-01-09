package com.loja.lojavirtual.entities.contas;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;

import com.loja.lojavirtual.entities.FormaPagamento;
import com.loja.lojavirtual.entities.enums.StatusContaPagar;
import com.loja.lojavirtual.entities.pessoa.Pessoa;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ContaPagar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusContaPagar status;

    @Column(nullable = false)
    @FutureOrPresent
    private LocalDate dataVencimento;

    @Column(nullable = false)
    private LocalDate dataPagamento;

    @Column(nullable = false)
    @Min(value = 0, message = "valor total na entidade ContaPagar não pode ser negativo")
    private Double valorTotal;

    @Column(nullable = false)
    @Min(value = 0, message = "valor do desconto na entidade ContaPagar não pode ser negativo")
    private Double valorDesconto = 0.0;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(name = "pessoa_fk"))
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "pessoa_forn_id", nullable = false, foreignKey = @ForeignKey(name = "pessoa_forn_fk"))
    private Pessoa pessoa_fonercedor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "forma_pagamento_id", nullable = false, foreignKey = @ForeignKey(name = "forma_pagamento_fk", value = ConstraintMode.CONSTRAINT))
    private FormaPagamento formaPagamento;
}
