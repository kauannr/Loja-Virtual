package com.loja.lojavirtual.entities;

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
    private Double valorVenda;

    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private Integer qtdEstoque;

    @Column(columnDefinition = "INTEGER DEFAULT 0")
    private Integer qtddAlertaEstoque;

    private String linkYoutube;

    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private Integer quantidadeClique;

    private Boolean alertaQtdEstoque = false;

}