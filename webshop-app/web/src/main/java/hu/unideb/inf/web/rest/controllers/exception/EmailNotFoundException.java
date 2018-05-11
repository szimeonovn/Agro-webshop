package hu.unideb.inf.web.rest.controllers.exception;


import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * This class provides an exception that invokes at retrieving an account from the database,
 * which has not belong to the given email address.
 */
public class EmailNotFoundException extends UsernameNotFoundException {
    /**
     * Constructor that helps to create a new instance of the ${@link EmailNotFoundException }
     *
     * @param message the description of the error message
     */
    public EmailNotFoundException(String message) {

        super(message);
    }
}
