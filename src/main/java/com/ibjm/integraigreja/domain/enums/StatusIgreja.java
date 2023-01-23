package com.ibjm.integraigreja.domain.enums;

public enum StatusIgreja {
    ATIVO(1), INATIVO(2);

    private final int valor;

    StatusIgreja(int valorOpcao) {
        valor = valorOpcao;
    }

    public int getValor() {
        return valor;
    }

}
