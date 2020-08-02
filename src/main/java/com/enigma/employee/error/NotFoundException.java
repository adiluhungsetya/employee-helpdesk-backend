package com.enigma.employee.error;

import com.enigma.employee.constant.ExceptionMessage;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String id) {
        super(String.format(ExceptionMessage.SOURCE_NOT_FOUND,id));
    }
}
