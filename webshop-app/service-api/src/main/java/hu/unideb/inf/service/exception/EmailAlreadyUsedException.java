package hu.unideb.inf.service.exception;

import lombok.Getter;

/**
 * This class represents the exception that invokes when the email address to save already exist in the database.
 */
public class EmailAlreadyUsedException extends RuntimeException {

    private static final long serialVersionUID = -2413213075285048591L;

    @Getter
    private ExceptionDetails exceptionDetails;

    /**
     * Constructor to help creating a new instance of the ${@link EmailAlreadyUsedException}
     *
     * @param message
     * @param exceptionDetails
     */
    public EmailAlreadyUsedException(String message, ExceptionDetails exceptionDetails) {
        super(message);
        this.exceptionDetails = exceptionDetails;
    }
}
