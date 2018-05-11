package hu.unideb.inf.web.rest.controllers.rest.response;

import lombok.Builder;
import lombok.Data;

/**
 * This class represents a key value pair which contains the reason why the given validation constraint is failed.
 */
@Data
@Builder
public class ErrorDetails {

    private String key;
    private String value;
}
