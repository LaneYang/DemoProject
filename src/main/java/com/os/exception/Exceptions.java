package com.os.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Exceptions extends RuntimeException {

    private ExceptionCode code;

    private String message;
}
