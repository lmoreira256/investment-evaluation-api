package com.devlucasmoreira.investmentevaluation.server.exception;

import com.devlucasmoreira.investmentevaluation.server.enums.ErrorMessageEnum;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.SEE_OTHER)
public class CoinAlreadyExistsException extends StandardException {

    public CoinAlreadyExistsException() {
        super(ErrorMessageEnum.COIN_ALREADY_EXISTS.getMessage(), HttpStatus.BAD_GATEWAY.value());
    }

}
