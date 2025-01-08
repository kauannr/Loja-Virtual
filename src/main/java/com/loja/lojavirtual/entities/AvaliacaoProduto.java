package com.loja.lojavirtual.entities;

import javax.validation.constraints.Min;

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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AvaliacaoProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    @Min(value = 0, message = "Nota na entidade AvaliacaoProduto deve estar entre 0 e 10")
    private Integer nota;

    @ManyToOne
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "pessoa_fk", value = ConstraintMode.CONSTRAINT))
    private Pessoa Pessoa;

    @ManyToOne
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "produto_fk", value = ConstraintMode.CONSTRAINT))
    private Produto produto;
}
