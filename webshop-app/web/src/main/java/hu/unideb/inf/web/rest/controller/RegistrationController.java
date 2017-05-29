package hu.unideb.inf.web.rest.controller;

import hu.unideb.inf.service.UserService;
import hu.unideb.inf.service.domain.User;
import hu.unideb.inf.web.creator.ErrorResponseCreator;
import hu.unideb.inf.web.rest.response.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RegistrationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private ErrorResponseCreator errorResponseCreator;

    @PostMapping(path = "/register")
    public ResponseEntity<Object> register(@Valid @RequestBody User user, BindingResult bindingResult) {
        LOGGER.info("User password: {}", user.getPassword());

        LOGGER.info("Received user request : {} ", user);
        if (bindingResult.hasErrors()) {
            ErrorResponse errorResponse = errorResponseCreator.createErrorResponse(bindingResult);
            return ResponseEntity.badRequest().body(errorResponse);
        }

        userService.registerUser(user);

        return ResponseEntity.ok().build();
    }
}
