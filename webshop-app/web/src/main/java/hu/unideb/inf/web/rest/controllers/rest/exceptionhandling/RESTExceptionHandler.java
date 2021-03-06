package hu.unideb.inf.web.rest.controllers.rest.exceptionhandling;

import hu.unideb.inf.service.exception.EmailAlreadyUsedException;
import hu.unideb.inf.web.rest.controllers.creator.ErrorResponseCreator;
import hu.unideb.inf.web.rest.controllers.rest.response.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * This class provides the exception handling in the application.
 */
@RestControllerAdvice
public class RESTExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(RESTExceptionHandler.class);

    @Autowired
    private ErrorResponseCreator errorResponseCreator;

    /**
     * This handles the invoked exception when an already saved email address wants to be registered.
     * @param e an exception
     * @return ResponseEntity a response entity
     */
    @ExceptionHandler(EmailAlreadyUsedException.class)
    protected ResponseEntity<ErrorResponse> handleEmailAlreadyUsedException(final EmailAlreadyUsedException e) {
        LOGGER.error("{}", e.getMessage(), e);
        return ResponseEntity.badRequest().body(errorResponseCreator
                .createErrorResponse(e.getExceptionDetails()));
    }
}
