package com.devlucasmoreira.investmentevaluation.server.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StandardException extends RuntimeException {

    private String message;

    private Integer status;

}
