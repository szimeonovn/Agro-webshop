package hu.unideb.inf.service;

import hu.unideb.inf.service.domain.Product;

import java.util.List;

/**
 * This interface is responsible for providing the product related operations.
 */
public interface ProductService {

    /**
     * Returns the products in list representation.
     * @return a list that contains the products
     */
    List<Product> getAllProduct();
}
