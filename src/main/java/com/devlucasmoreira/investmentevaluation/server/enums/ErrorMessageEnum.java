package com.devlucasmoreira.investmentevaluation.server.enums;

public enum ErrorMessageEnum {

    COIN_ALREADY_EXISTS("JÁ EXISTE UMA MOEDA COM ESSE NOME."),
    COIN_NOT_FOUND("NÃO FOI ENCONTRADO NENHUMA MOEDA COM O ID INFORMADO."),
    STOCK_ALREADY_EXISTS("JÁ EXISTE UMA AÇÂO COM ESSE NOME."),
    STOCK_NOT_FOUND("NÃO FOI ENCONTRADO NENHUMA AÇÂO COM O ID INFORMADO.");

    private String message;

    ErrorMessageEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
