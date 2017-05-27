package hu.unideb.inf.service.impl;

import hu.unideb.inf.persistence.entity.UserEntity;
import hu.unideb.inf.persistence.repository.UserRepository;
import hu.unideb.inf.service.domain.User;
import hu.unideb.inf.service.exception.EmailAlreadyUsedException;
import hu.unideb.inf.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

/**
 * Created by Szimi7 on 2017.05.26..
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test(expected = IllegalArgumentException.class)
    public void findUserByEmailShouldThrowIllegalArgumentExceptionWhenParameterEmailIsNull() {
        // Given

        // When
        userService.findUserByEmail(null);

        // Then
    }

    @Test
    public void findUserByEmailShouldReturnNullWhenParameterEmailDoesNotExist() {
        // Given
        String nonExistentEmail = "nonExistentEmail";

        given(userRepository.findByEmail(nonExistentEmail)).willReturn(null);

        // When
        User result = userService.findUserByEmail(nonExistentEmail);

        // Then
        assertThat(result, nullValue());
    }

    @Test
    public void findUserByEmailShouldReturnNonNullWhenParameterEmailExist() {
        // Given
        String existentEmail = "cat@gmail.com";

        UserEntity userEntity = UserEntity.builder()
                .email(existentEmail)
                .build();

        User user = User.builder()
                .email(existentEmail)
                .build();

        given(userRepository.findByEmail(existentEmail)).willReturn(userEntity);
        given(modelMapper.map(userEntity, User.class)).willReturn(user);

        // When
        User result = userService.findUserByEmail(existentEmail);

        // Then
        assertThat(result, notNullValue());
        assertThat(result, equalTo(user));
    }

    @Test(expected = IllegalArgumentException.class)
    public void registerUserShouldThrowIllegalArgumentExceptionWhenParameterUserIsNull() {
        // Given

        // When
        userService.registerUser(null);

        // Then
    }

    @Test(expected = EmailAlreadyUsedException.class)
    public void registerUserShouldThrowEmailAlreadyUsedExceptionWhenParameterUserHasExistentEmail() {
        // Given
        String existentEmail = "existentEmail";

        UserEntity userEntity = UserEntity.builder()
                .email(existentEmail)
                .build();

        User user = User.builder()
                .email(existentEmail)
                .build();

        given(userRepository.findByEmail(existentEmail)).willReturn(userEntity);

        // When
        userService.registerUser(user);

        // Then
    }

    @Test
    public void registerUserShouldRegisterSuccessfullyWhenParameterUserHasNonExistentEmail() {
        // Given
        String nonExistentEmail = "nonExistentEmail";

        UserEntity userEntity = UserEntity.builder()
                .email(nonExistentEmail)
                .build();

        User user = User.builder()
                .email(nonExistentEmail)
                .build();

        given(userRepository.findByEmail(nonExistentEmail)).willReturn(null);
        given(modelMapper.map(user, UserEntity.class)).willReturn(userEntity);

        // When
        userService.registerUser(user);

        // Then
        then(modelMapper).should().map(user, UserEntity.class);
        then(userRepository).should().save(userEntity);
    }
}
