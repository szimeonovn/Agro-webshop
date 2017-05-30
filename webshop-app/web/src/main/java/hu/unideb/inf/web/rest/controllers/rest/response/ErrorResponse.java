package hu.unideb.inf.web.rest.controllers.rest.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class ErrorResponse {
    private List<ErrorDetails> errorDetailsList;

}
