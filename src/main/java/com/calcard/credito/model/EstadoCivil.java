package com.calcard.credito.model;

public enum EstadoCivil {

    SOLTEIRO("S"), CASADO("C"), DIVORCIADO("D"), VIUVA("V");

    private final String valor;

    EstadoCivil(String valor) {
        this.valor = valor;
    }

    public EstadoCivil getValor() {
        return EstadoCivil.valueOf(this.valor);
    }
}
