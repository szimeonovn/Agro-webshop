package hu.unideb.inf.web.rest.controllers.creator;

import hu.unideb.inf.service.domain.User;
import hu.unideb.inf.service.exception.ExceptionDetails;
import hu.unideb.inf.web.rest.controllers.rest.response.ErrorDetails;
import hu.unideb.inf.web.rest.controllers.rest.response.ErrorResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyObject;

@RunWith(MockitoJUnitRunner.class)

public class ErrorResponseCreatorTest {


    @Mock
    private BindingResult bindingResult;
    @Mock
    private User user;
    @Mock
    private ErrorResponse errorResponse;
    @Mock
    private ExceptionDetails exceptionDetails;

    @InjectMocks
    private ErrorResponseCreator errorResponseCreator;

    @Test
    public void createErrorResponseShouldReturnErrorResponse() {
        ErrorResponse result = errorResponseCreator.createErrorResponse(exceptionDetails);
        assertThat(result, notNullValue());
    }

    @Test
    public void createErrorResponseShouldReturnErrorResponseFromBindingResult() {
        given(bindingResult.hasErrors()).willReturn(true);
        ErrorResponse result = errorResponseCreator.createErrorResponse(bindingResult);
        assertThat(result, notNullValue());
    }

    @Test
    public void createErrorResponseShouldNotReturnErrorResponseFromBindingResult() {
        given(bindingResult.hasErrors()).willReturn(false);
        ErrorResponse result = errorResponseCreator.createErrorResponse(bindingResult);
        assertThat(result, notNullValue());
    }

}
