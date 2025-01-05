package com.loja.lojavirtual.entities;

import java.time.LocalDate;

import javax.validation.constraints.Min;

import com.loja.lojavirtual.entities.enums.StatusContaReceber;
import com.loja.lojavirtual.entities.pessoa.Pessoa;

import jakarta.persistence.Column;
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
public class ContaReceber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusContaReceber status;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private LocalDate dataVencimento;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private LocalDate dataPagamento;

    @Column(nullable = false)
    @Min(value = 0, message = "Valor total não pode ser negativo")
    private Double valorTotal;

    @Column(nullable = false)
    @Min(value = 0, message = "Valor de desconto não pode ser negativo")
    private Double valorDesconto;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(name = "pessoa_fk"))
    private Pessoa pessoa;
}
