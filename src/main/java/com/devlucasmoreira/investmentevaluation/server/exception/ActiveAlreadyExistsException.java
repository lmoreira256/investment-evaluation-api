package com.devlucasmoreira.investmentevaluation.server.exception;

import com.devlucasmoreira.investmentevaluation.server.enums.ErrorMessageEnum;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.SEE_OTHER)
public class ActiveAlreadyExistsException extends StandardException {

    public ActiveAlreadyExistsException() {
        super(ErrorMessageEnum.ACTIVE_ALREADY_EXISTS.getMessage(), HttpStatus.SEE_OTHER.value());
    }

}
