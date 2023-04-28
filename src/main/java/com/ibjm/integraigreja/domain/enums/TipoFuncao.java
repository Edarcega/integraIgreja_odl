package com.ibjm.integraigreja.domain.enums;

public enum TipoFuncao {
    VOLUNTARIO(0),
    REMUNERADO(1);

    private final int valor;

    TipoFuncao(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
