package com.loja.lojavirtual.entities;

import javax.validation.constraints.Min;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, columnDefinition = "text", length = 2000)
    private String descricao;

    private String tipoUnidade;

    private Double pesoEmGramas;
    private Double largura;
    private Double altura;
    private Double profundidade;

    @Column(nullable = false)
    @Min(value = 0, message = "Valor da venda não deve ser negativo")
    private Double valorVenda;

    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    @Min(value = 0, message = "Qauntiade de estoque não deve ser negativa")
    private Integer qtdEstoque;

    @Column(columnDefinition = "INTEGER DEFAULT 0")
    private Integer qtddAlertaEstoque;

    private String linkYoutube;

    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    @Min(value = 0, message = "Qauntiade de cliques não deve ser negativo")
    private Integer quantidadeClique;

    private Boolean alertaQtdEstoque = false;

}