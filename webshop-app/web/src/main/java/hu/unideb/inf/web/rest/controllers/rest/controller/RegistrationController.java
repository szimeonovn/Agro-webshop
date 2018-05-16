package hu.unideb.inf.web.rest.controllers.rest.controller;

import hu.unideb.inf.service.UserService;
import hu.unideb.inf.service.domain.User;
import hu.unideb.inf.web.rest.controllers.creator.ErrorResponseCreator;
import hu.unideb.inf.web.rest.controllers.rest.response.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * This controller is responsible for creating the user account.
 */
@RestController
public class RegistrationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private ErrorResponseCreator errorResponseCreator;

    /**
     * This method creates the account with the given data.
     *
     * @param user          the user
     * @param bindingResult the bindingresult
     * @return a HTTP Status code with in case of an error - an error response object
     */
    @PostMapping(path = "/register")
    public ResponseEntity<Object> register(@Valid @RequestBody User user, BindingResult bindingResult) {
        LOGGER.info("Received user request : {} ", user);
        if (bindingResult.hasErrors()) {
            ErrorResponse errorResponse = errorResponseCreator.createErrorResponse(bindingResult);
            return ResponseEntity.badRequest().body(errorResponse);
        }

        userService.registerUser(user);

        return ResponseEntity.ok().build();
    }
}
