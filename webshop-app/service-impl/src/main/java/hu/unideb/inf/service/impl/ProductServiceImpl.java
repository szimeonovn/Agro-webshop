package hu.unideb.inf.service.impl;

import hu.unideb.inf.persistence.repository.ProductRepository;
import hu.unideb.inf.service.ProductService;
import hu.unideb.inf.service.domain.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of {@link ProductService}.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductRepository productRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<Product> getAllProduct() {
        return productRepository.findAll()
                .stream()
                .map(productEntity -> modelMapper.map(productEntity, Product.class))
                .collect(Collectors.toList());
    }


}
