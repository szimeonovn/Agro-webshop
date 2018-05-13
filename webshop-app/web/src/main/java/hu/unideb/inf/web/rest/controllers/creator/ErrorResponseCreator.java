package hu.unideb.inf.web.rest.controllers.creator;

import hu.unideb.inf.service.exception.ExceptionDetails;
import hu.unideb.inf.web.rest.controllers.rest.response.ErrorDetails;
import hu.unideb.inf.web.rest.controllers.rest.response.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class provides the error response objects.
 */
@Component
public class ErrorResponseCreator {
    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorResponse.class);

    /**
     * Returns an error response object.
     *
     * @param exceptionDetails It contains the base key value pairs in case of breaking the validation restrictions.
     * @return an error response object
     */
    public ErrorResponse createErrorResponse(ExceptionDetails exceptionDetails) {
        return ErrorResponse.builder().errorDetailsList(Collections.singletonList(
                ErrorDetails.builder().key(exceptionDetails.getKey()).value(exceptionDetails.getValue()).build()
        )).build();
    }

    /**
     * Returns an error response object made from the bindingresult.
     *
     * @param bindingResult the bindingresult
     * @return an error response object made from the bindingresult
     */
    public ErrorResponse createErrorResponse(BindingResult bindingResult) {
        Assert.notNull(bindingResult, "Binding Result can not be null");
        List<ErrorDetails> errorDetailsList = null;
        if (bindingResult.hasErrors()) {
            errorDetailsList = bindingResult.getAllErrors()
                    .stream()
                    .map(objectError -> createErrorDetails(objectError))
                    .collect(Collectors.toList());
        }
        LOGGER.warn("Error details list : {}", errorDetailsList);
        return ErrorResponse.builder().errorDetailsList(errorDetailsList).build();
    }

    private ErrorDetails createErrorDetails(ObjectError objectError) {
        if (objectError instanceof FieldError) {
            FieldError fieldError = (FieldError) objectError;
            return ErrorDetails.builder().key(fieldError.getField()).value(fieldError.getDefaultMessage()).build();
        }

        return ErrorDetails.builder().key(objectError.getObjectName()).value(objectError.getDefaultMessage()).build();
    }
}
