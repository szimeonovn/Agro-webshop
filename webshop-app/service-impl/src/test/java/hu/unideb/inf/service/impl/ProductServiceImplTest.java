package hu.unideb.inf.service.impl;

import hu.unideb.inf.persistence.entity.ProductEntity;
import hu.unideb.inf.persistence.repository.ProductRepository;
import hu.unideb.inf.service.ProductService;
import hu.unideb.inf.service.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.BDDMockito.given;


@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    public void getAllProductShouldReturnEmptyList() {
        // Given
        given(productRepository.findAll()).willReturn(Collections.emptyList());

        // When
        List<Product> result = productService.getAllProduct();

        // Then
        assertThat(result, notNullValue());
        assertThat(result.isEmpty(), is(true));
    }

    @Test
    public void getAllProductShouldReturnWithSingleElementList() {
        // Given
        ProductEntity productEntity = ProductEntity.builder()
                .id(1L)
                .build();

        Product product = Product.builder()
                .id(1L)
                .build();

        List<ProductEntity> products = Collections.singletonList(productEntity);

        given(productRepository.findAll()).willReturn(products);
        given(modelMapper.map(productEntity, Product.class)).willReturn(product);

        // When
        List<Product> result = productService.getAllProduct();

        // Then

    }
}

