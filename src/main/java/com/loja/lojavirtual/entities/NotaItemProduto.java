package com.loja.lojavirtual.entities;

import com.loja.lojavirtual.entities.notas_fiscais.NotaFiscalCompra;

import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "notaFiscalCompra_id", "produto_id" }))
public class NotaItemProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne
    @JoinColumn(name = "notaFiscalCompra_id", nullable = false, foreignKey = @ForeignKey(name = "nota_fiscal_compra_fk", value = ConstraintMode.CONSTRAINT))
    private NotaFiscalCompra notaFiscalCompra;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false, foreignKey = @ForeignKey(name = "produto_fk", value = ConstraintMode.CONSTRAINT))
    private Produto produto;

    private Integer quantidade;
}
