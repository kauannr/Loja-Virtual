package com.loja.lojavirtual.entities;

import javax.validation.constraints.Min;

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
public class ItemVendaLoja {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "produto_fk", value = ConstraintMode.CONSTRAINT))
    private Produto produto;

    @ManyToOne
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "venda_loja_fk", value = ConstraintMode.CONSTRAINT))
    private VendaLoja vendaLoja;

    @Column(nullable = false)
    @Min(value = 0, message = "Quantidade na entidade ItemVendaLoja não pode ser negativa")
    private Integer quantidade;

    


}
