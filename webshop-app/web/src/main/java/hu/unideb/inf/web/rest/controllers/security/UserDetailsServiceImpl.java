package hu.unideb.inf.web.rest.controllers.security;

import hu.unideb.inf.service.UserService;
import hu.unideb.inf.service.domain.User;
import hu.unideb.inf.web.rest.controllers.exception.EmailNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

/**
 * Implementatin of {@link UserDetailsService}.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userService.findUserByEmail(email);
        if (user == null) {

            throw new EmailNotFoundException(String.format("Email=%s not found", email));
        }
        return new org.springframework.security.core.userdetails.User(email, user.getPassword(), Collections.emptyList());
    }
}
