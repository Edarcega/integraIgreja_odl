package com.ibjm.integraigreja.domain.enums;

public enum EstadoCivil {
    SOLTEIRO(0), CASADO(1), SEPARADO(2), SIVORCIADO(3), VIUVO(4);

    private final int valor;

    EstadoCivil(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
