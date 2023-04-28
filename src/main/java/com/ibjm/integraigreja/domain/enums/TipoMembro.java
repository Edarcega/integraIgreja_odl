package com.ibjm.integraigreja.domain.enums;

public enum TipoMembro {
    MEMBRO(0), FREQUENTANTE(1);

    private final int valor;

    TipoMembro(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
