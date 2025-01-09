package com.loja.lojavirtual.entities.notas_fiscais;

import com.loja.lojavirtual.entities.VendaLoja;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class NotaFiscalVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String numero;

    @Column(nullable = false)
    private String serie;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false, columnDefinition = "text")
    private String xml;

    @Column(nullable = false, columnDefinition = "text")
    private String pdf;

    @OneToOne
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "vendaLoja_fk", value = ConstraintMode.CONSTRAINT))
    private VendaLoja vendaLoja;

}
