package hu.unideb.inf.web.exception;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class EmailNotFoundException extends UsernameNotFoundException{

    public EmailNotFoundException(String message) {
        super(message);
    }
}
