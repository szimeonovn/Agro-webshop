package hu.unideb.inf.web.rest.controllers.rest.controller;


import hu.unideb.inf.service.ProductService;
import hu.unideb.inf.service.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This class defines and provides the product related resources.
 */
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * Returns the queried products.
     *
     * @return an HTTP Status code and a list of the products
     */
    @GetMapping(path = "/product")
    public ResponseEntity<List<Product>> getAllProduct() {

        return ResponseEntity.ok(productService.getAllProduct());
    }
}
