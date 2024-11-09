package com.apenasnagelo.api_rest.Exceptions;

public class RequiredFieldException extends BusinessException {
    public RequiredFieldException(String field) {
        super("O campo %s é obrigatório.", field);
    }
}