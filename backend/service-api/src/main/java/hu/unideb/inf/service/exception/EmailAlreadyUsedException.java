package hu.unideb.inf.service.exception;

import lombok.Getter;

public class EmailAlreadyUsedException extends RuntimeException {

    @Getter
    private ExceptionDetails exceptionDetails;

    public EmailAlreadyUsedException(String message, ExceptionDetails exceptionDetails) {
        super(message);
        this.exceptionDetails = exceptionDetails;
    }
}
