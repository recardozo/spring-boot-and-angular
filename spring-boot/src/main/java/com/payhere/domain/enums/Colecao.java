package com.payhere.domain.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

public enum Colecao implements Serializable {

    PRIMAVERA_VERAO("Primavera/Verão"), OUTONO_INVERNO("Outono/Inverno");

    private String value;

    private Colecao (String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
