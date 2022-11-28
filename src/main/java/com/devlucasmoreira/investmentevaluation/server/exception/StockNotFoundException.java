package com.devlucasmoreira.investmentevaluation.server.exception;

import com.devlucasmoreira.investmentevaluation.server.enums.ErrorMessageEnum;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class StockNotFoundException extends StandardException {

    public StockNotFoundException() {
        super(ErrorMessageEnum.STOCK_NOT_FOUND.getMessage(), HttpStatus.NOT_FOUND.value());
    }

}
