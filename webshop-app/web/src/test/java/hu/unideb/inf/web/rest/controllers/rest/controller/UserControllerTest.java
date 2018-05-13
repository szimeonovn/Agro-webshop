package hu.unideb.inf.web.rest.controllers.rest.controller;


import hu.unideb.inf.service.ProductService;
import hu.unideb.inf.service.UserService;
import hu.unideb.inf.service.domain.Product;
import hu.unideb.inf.web.rest.controllers.rest.response.UserResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.security.Principal;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;


@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {


    @Mock
    private UserResponse UserResponse;

    @Mock
    private Principal principal;

    @InjectMocks
    private UserController controllerUnderTest;

    @Test
    public void userShouldRespondOK() {
        //Given
        given(principal.getName()).willReturn("testName");

        //When
        ResponseEntity<UserResponse> result = controllerUnderTest.getCurrentUser(principal);

        //Then
        assertThat(result, notNullValue());
        assertThat(result.getStatusCode(), equalTo(HttpStatus.OK));

    }

}