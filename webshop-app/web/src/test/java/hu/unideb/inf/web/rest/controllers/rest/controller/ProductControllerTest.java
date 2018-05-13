package hu.unideb.inf.web.rest.controllers.rest.controller;

import hu.unideb.inf.service.ProductService;
import hu.unideb.inf.service.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Matchers.anyList;


@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

    @Mock
    private ProductService productService;
    @Mock
    private Product product;

    @Mock
    private List<Product> productList;
    @InjectMocks
    private ProductController controllerUnderTest;

    @Test
    public void productShouldRespondOK() {
        //Given
        given(productService.getAllProduct()).willReturn(Arrays.asList(product));
        //When
        ResponseEntity<List<Product>> result = controllerUnderTest.getAllProduct();

        //Then
        assertThat(result, notNullValue());
        assertThat(result.getStatusCode(), equalTo(HttpStatus.OK));

    }

}
