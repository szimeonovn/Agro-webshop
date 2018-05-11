package hu.unideb.inf.web.rest.controllers.rest.controller;

import hu.unideb.inf.web.rest.controllers.rest.response.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * This controller provides the user account related resources.
 */

@RestController
public class UserController {

    /**
     * Returns the authenticated user's email address.
     *
     * @param principal the principal
     * @return a HTTP Status code with the authenticated user"s email
     */
    @GetMapping(path = "/user")
    public ResponseEntity<UserResponse> getCurrentUser(Principal principal) {
        return new ResponseEntity<UserResponse>(new UserResponse("email", principal.getName()), HttpStatus.OK);
    }
}
