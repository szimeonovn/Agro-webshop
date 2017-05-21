package hu.unideb.inf.service.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private Long id;
    @NotNull
    private String title;
    @NotNull
    private Integer price;
    @NotNull
    private String description;
}

