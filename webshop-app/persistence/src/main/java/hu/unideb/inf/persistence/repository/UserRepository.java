package hu.unideb.inf.persistence.repository;

import hu.unideb.inf.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface is responsible for providing the user related operations.
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);
}
