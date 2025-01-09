package com.loja.lojavirtual.entities.pessoa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class PessoaJuridica extends Pessoa {

    @Column(nullable = false)
    private String cnpj;

    @Column(nullable = false)
    private String inscEstadual;

    @Column(nullable = false)
    private String inscMunicipal;

    @Column(nullable = false)
    private String nomeFantasia;

    @Column(nullable = false)
    private String razaoSocial;

    private String categoria;

}
