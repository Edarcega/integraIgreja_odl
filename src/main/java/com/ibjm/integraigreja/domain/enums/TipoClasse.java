package com.ibjm.integraigreja.domain.enums;

public enum TipoClasse {
    INFANTIL(0), ADOLESCENTES(1), JOVEM(2), ADULTO(3),MELHOR_IDADE(4);

    private final int valor;

    TipoClasse(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
