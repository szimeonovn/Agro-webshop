package hu.unideb.inf.web.rest.controllers.rest.controller;

import hu.unideb.inf.service.UserService;
import hu.unideb.inf.service.domain.User;
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
import org.springframework.validation.BindingResult;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;

/**
 * Created by Szimi7 on 2018.05.12..
 */
@RunWith(MockitoJUnitRunner.class)
public class RegistrationControllerTest {

    @Mock
    private UserService userService;
    @Mock
    private ErrorResponseCreator errorResponseCreator;
    @Mock
    private BindingResult bindingResult;
    @Mock
    private User user;
    @Mock
    private ErrorResponse errorResponse;

    @InjectMocks
    private RegistrationController controllerUnderTest;

    @Test
    public void registerShouldRespondBadRequestWhenUserRequestHasValidationErrors() {
        // Given
        given(bindingResult.hasErrors()).willReturn(true);
        given(errorResponseCreator.createErrorResponse(bindingResult)).willReturn(errorResponse);

        // When
        ResponseEntity<Object> result = controllerUnderTest.register(user, bindingResult);

        // Then
        assertThat(result, notNullValue());
        assertThat(result.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
        assertThat(result.getBody(), equalTo(errorResponse));
    }

    @Test(expected = EmailAlreadyUsedException.class)
    public void registerShouldThrowEmailAlreadyUsedException() {
        // Given
        given(bindingResult.hasErrors()).willReturn(false);
        doThrow(EmailAlreadyUsedException.class).when(userService).registerUser(user);

        // When
        ResponseEntity<Object> result = controllerUnderTest.register(user, bindingResult);

        // Then
        // expected exception
    }

    @Test
    public void registerShouldRespondOK() {
        // Given
        given(bindingResult.hasErrors()).willReturn(false);

        // When
        ResponseEntity<Object> result = controllerUnderTest.register(user, bindingResult);

        // Then
        assertThat(result, notNullValue());
        assertThat(result.getStatusCode(), equalTo(HttpStatus.OK));
    }
}
