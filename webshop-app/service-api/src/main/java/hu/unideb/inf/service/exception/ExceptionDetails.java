package hu.unideb.inf.service.exception;

import lombok.Builder;
import lombok.Data;

/**
 * This class represents a key value pair which contains the reason why the given exception occurred.
 */
@Data
@Builder
public class ExceptionDetails {
    private String key;
    private String value;
}
