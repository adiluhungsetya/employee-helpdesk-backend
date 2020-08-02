package com.enigma.employee.error;

import com.enigma.employee.constant.ExceptionMessage;

public class ResourceEmptyException extends RuntimeException{
    public ResourceEmptyException() {
        super(ExceptionMessage.EMPTY_RESOURCE);
    }
}
