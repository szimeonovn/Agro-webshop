package hu.unideb.inf.persistence.repository;

import hu.unideb.inf.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface is responsible for providing the user related operations.
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    /**
     * This method returns a user entity based on email address. If the user does not exist, then it returns null.
     *
     * @param email the user's email
     * @return a UserEntity
     */
    UserEntity findByEmail(String email);
}
