package hu.unideb.inf.web.rest.controllers.rest.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * This class wraps the list of the error details.
 */
@Data
@Builder
public class ErrorResponse {
    private List<ErrorDetails> errorDetailsList;

}
