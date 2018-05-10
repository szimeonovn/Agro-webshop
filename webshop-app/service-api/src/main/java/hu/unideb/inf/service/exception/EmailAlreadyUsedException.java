package hu.unideb.inf.service.exception;

import lombok.Getter;

/**
 * This class represents the exception that invokes when the email address to save already exist in the database.
 */
public class EmailAlreadyUsedException extends RuntimeException {

    @Getter
    private ExceptionDetails exceptionDetails;

    /**
     * This exception invokes when the email address to save already exist in the database.
     *
     * @param message
     * @param exceptionDetails
     */
    public EmailAlreadyUsedException(String message, ExceptionDetails exceptionDetails) {
        super(message);
        this.exceptionDetails = exceptionDetails;
    }
}
