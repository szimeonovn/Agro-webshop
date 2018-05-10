package hu.unideb.inf.web.rest.controllers.rest.response;

import lombok.Builder;
import lombok.Data;

/**
 * This class represents a key value pair.
 */
@Data
@Builder
public class ErrorDetails {

    private String key;
    private String value;
}
