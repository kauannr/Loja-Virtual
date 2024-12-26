package com.loja.lojavirtual.entities.enums;

public enum TipoEndereço {

    RESIDENCIAL("Residencial"),
    COMERCIAL("Comercial"),
    INDUSTRIAL("Industrial"),
    COBRANÇA("Cobrança"),
    ENTREGA("Entrega");

    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    private TipoEndereço(String decricao) {
        this.descricao = decricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}
