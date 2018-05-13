package hu.unideb.inf.web.rest.controllers.rest.exceptionhandling;


import hu.unideb.inf.service.exception.EmailAlreadyUsedException;
import hu.unideb.inf.web.rest.controllers.creator.ErrorResponseCreator;
import hu.unideb.inf.web.rest.controllers.rest.response.ErrorResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;

@RunWith(MockitoJUnitRunner.class)

public class RESTExceptionHandlerTest {

    @Mock
    private ErrorResponseCreator errorResponseCreator;

    @Mock
    private EmailAlreadyUsedException emailAlreadyUsedException;

    @Mock
    private ErrorResponse errorResponse;

    @InjectMocks
    private RESTExceptionHandler restExceptionHandler;

    @Test
    public void emailAlreadyUsedExceptionRespondBadRequest() {
        //Given
        given(errorResponseCreator
                .createErrorResponse(emailAlreadyUsedException.getExceptionDetails()))
                .willReturn(errorResponse);

        //When
        ResponseEntity<ErrorResponse> result = restExceptionHandler.handleEmailAlreadyUsedException(emailAlreadyUsedException);
        //Then
        assertThat(result, notNullValue());
        assertThat(result.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
        assertThat(result.getBody(), equalTo(errorResponse));
    }

}
