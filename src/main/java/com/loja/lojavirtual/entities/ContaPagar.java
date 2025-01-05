package com.loja.lojavirtual.entities;

import java.time.LocalDate;

import com.loja.lojavirtual.entities.enums.StatusContaPagar;
import com.loja.lojavirtual.entities.pessoa.Pessoa;

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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContaPagar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusContaPagar status;

    @Temporal(TemporalType.DATE)
    private LocalDate dataVencimento;

    @Temporal(TemporalType.DATE)
    private LocalDate dataPagamento;

    private Double valorTotal;
    private Double valorDesconto;

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
