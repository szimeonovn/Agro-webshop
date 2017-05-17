package hu.unideb.inf.persistence.repository;

import hu.unideb.inf.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

    UserEntity findByEmail(String email); //visszaad egy parasztot email alapján
}
