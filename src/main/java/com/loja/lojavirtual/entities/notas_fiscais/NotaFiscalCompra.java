package com.loja.lojavirtual.entities.notas_fiscais;

import java.time.LocalDate;

import javax.validation.constraints.Min;

import com.loja.lojavirtual.entities.contas.ContaPagar;
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
public class NotaFiscalCompra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String numero;

    @Column(nullable = false)
    private String serie;

    private Boolean ativo = true;

    private String descricao;

    @Column(nullable = false)
    @Min(value = 0, message = "valor total não deve ser negativo")
    private Double valorTotal;

    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    @Min(value = 0, message = "valor do desconto não deve ser negativo")
    private Double valorDesconto;

    @Column(nullable = false)
    @Min(value = 0, message = "valor ICMS não deve ser negativo")
    private Double valorICMS;

    @Column(nullable = false)
    private LocalDate dataCompra;

    @ManyToOne
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "pessoa_fk", value = ConstraintMode.CONSTRAINT))
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "pessoa_fk", value = ConstraintMode.CONSTRAINT))
    private ContaPagar contaPagar;

}
