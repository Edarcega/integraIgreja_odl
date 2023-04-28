package com.ibjm.integraigreja.domain.enums;

public enum StatusGrupo {
    ATIVO(1), INATIVO(2);

    private final int valor;

    StatusGrupo(int valorOpcao) {
        valor = valorOpcao;
    }

    public int getValor() {
        return valor;
    }

}
