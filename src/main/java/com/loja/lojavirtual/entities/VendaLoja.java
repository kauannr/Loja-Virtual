package com.loja.lojavirtual.entities;

import java.time.LocalDate;

import javax.validation.constraints.Min;

import com.loja.lojavirtual.entities.notas_fiscais.NotaFiscalVenda;
import com.loja.lojavirtual.entities.pessoa.Pessoa;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class VendaLoja {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "pessoa_fk", value = ConstraintMode.CONSTRAINT))
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "endereco_entrega_fk", value = ConstraintMode.CONSTRAINT))
    private Endereco enderecoEntrega;

    @ManyToOne
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "endereco_cobranca_fk", value = ConstraintMode.CONSTRAINT))
    private Pessoa enderecoCobranca;

    @Column(nullable = false)
    @Min(value = 0, message = "Valor total na entidade VendaLoja não pode ser negativo")
    private Double valorTotal;

    @Column(nullable = false)
    @Min(value = 0, message = "Valor do desconto na entidade VendaLoja não pode ser negativo")
    private Double valorDesconto;

    @ManyToOne
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "forma_pagamento_fk", value = ConstraintMode.CONSTRAINT))
    private FormaPagamento formaPagamento;

    @OneToOne
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "notaFiscalVenda_fk", value = ConstraintMode.CONSTRAINT))
    private NotaFiscalVenda notaFiscalVenda;

    @ManyToOne
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "cupom_desconto_fk", value = ConstraintMode.CONSTRAINT))
    private CupomDesconto cupomDesconto;

    @Column(nullable = false)
    @Min(value = 0, message = "Valor do frete na entidade VendaLoja não pode ser negativo")
    private Double valorFrete;

    @Column(nullable = false)
    private Integer diasEntrega;

    @Column(nullable = false, updatable = false)
    private LocalDate dataVenda;

    @Column(nullable = false)
    private LocalDate dataEntrega;








}
