package hu.unideb.inf.web.rest.exceptionhandling;

import hu.unideb.inf.service.exception.EmailAlreadyUsedException;
import hu.unideb.inf.web.creator.ErrorResponseCreator;
import hu.unideb.inf.web.rest.controller.RegistrationController;
import hu.unideb.inf.web.rest.response.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by Szimi7 on 2017.05.16..
 */
@RestControllerAdvice
public class RESTExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(RESTExceptionHandler.class);

    @Autowired
    private ErrorResponseCreator errorResponseCreator;

    @ExceptionHandler(EmailAlreadyUsedException.class)
    protected ResponseEntity<ErrorResponse> handleEmailAlreadyUsedException(final EmailAlreadyUsedException e) {
        LOGGER.error("{}", e.getMessage(), e);
        return ResponseEntity.badRequest().body(errorResponseCreator.createErrorResponse(e.getExceptionDetails()));
    }
}
