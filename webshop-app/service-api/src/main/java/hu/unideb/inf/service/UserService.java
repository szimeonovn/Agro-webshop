package hu.unideb.inf.service;


import hu.unideb.inf.service.domain.User;
import hu.unideb.inf.service.exception.EmailAlreadyUsedException;

/**
 * This interface is responsible for providing the user related operations.
 */
public interface UserService {

    /**
     * This method registers the user received as a parameter and saves its data to the database.
     *
     * @param user
     * @throws EmailAlreadyUsedException
     */
    void registerUser(User user) throws EmailAlreadyUsedException;

    /**
     * This method provides the user object for the given email address.
     * If there is no matching user object based on email address then it returns null.
     *
     * @param email
     * @return a User object
     */
    User findUserByEmail(String email);
}
