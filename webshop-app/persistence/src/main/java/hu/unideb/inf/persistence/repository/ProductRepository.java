package hu.unideb.inf.persistence.repository;

import hu.unideb.inf.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface is responsible for providing the product related operations.
 */
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
