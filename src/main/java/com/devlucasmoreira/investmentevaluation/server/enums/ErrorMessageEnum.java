package com.devlucasmoreira.investmentevaluation.server.enums;

public enum ErrorMessageEnum {

    COIN_ALREADY_EXISTS("JÁ EXISTE UMA MOEDA COM ESSE NOME."),
    COIN_NOT_FOUND("NÃO FOI ENCONTRADO NENHUMA MOEDA COM O ID INFORMADO."),
    ACTIVE_ALREADY_EXISTS("JÁ EXISTE UM ATIVO COM ESSE NOME."),
    ACTIVE_NOT_FOUND("NÃO FOI ENCONTRADO NENHUM ATIVO COM O ID/NOME INFORMADO.");

    private final String message;

    ErrorMessageEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
