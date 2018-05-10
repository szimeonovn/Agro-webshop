package hu.unideb.inf.service;


import hu.unideb.inf.service.domain.User;

/**
 * This interface is responsible for providing the user related operations.
 */
public interface UserService {
    /**
     * This method registers the user received as a parameter and saves its data to the database.
     *
     * @param user
     */
    void registerUser(User user);

    /**
     * This method provides the user object for the given email address.
     * If there is no matching user object then it returns null.
     *
     * @param email
     * @return a User object
     */
    User findUserByEmail(String email);
}
