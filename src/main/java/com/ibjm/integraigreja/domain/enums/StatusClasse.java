package com.ibjm.integraigreja.domain.enums;

public enum StatusClasse {
    ATIVO(0), INATIVO(1);

    private final int valor;

    StatusClasse(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
