package hu.unideb.inf.web.rest.controllers.security;

import hu.unideb.inf.service.UserService;
import hu.unideb.inf.service.exception.EmailAlreadyUsedException;
import hu.unideb.inf.web.rest.controllers.exception.EmailNotFoundException;
import org.hibernate.service.spi.InjectService;
import org.hibernate.validator.constraints.Email;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.notNull;
import static org.mockito.Matchers.startsWith;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

public class UserDetailsServiceImplTest {

    @Mock
    private UserService userService;

    @Mock
    private User user;

    @Mock
    private UsernameNotFoundException usernameNotFoundException;

    @Mock
    private EmailNotFoundException emailNotFoundException;


    @InjectMocks
    private UserDetailsServiceImpl controllerUnderTest;
    

    @Test(expected = UsernameNotFoundException.class)
    public void loadByUserNameShouldReturnUserDetail() {
        given(userService.findUserByEmail(user.getUsername())).willReturn(null);
        UserDetails result = controllerUnderTest.loadUserByUsername(user.getUsername());
        assertThat(result, notNullValue());

    }

}
