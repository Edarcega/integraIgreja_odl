package com.ibjm.integraigreja.domain.enums;

public enum Perfil {
    ADMINISTRADORGLOBAL(0), ADMINISTRADORIGREJA(1), MEMBRO(2), FREQUENTADOR(3);

    private final int valor;

    Perfil(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
