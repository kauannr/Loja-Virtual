package com.loja.lojavirtual.entities.pessoa;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class PessoaFisica extends Pessoa {

    @Column(nullable = false)
    private String cpf;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private LocalDate dataNascimento;
}
