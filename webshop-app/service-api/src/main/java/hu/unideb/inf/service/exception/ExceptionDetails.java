package hu.unideb.inf.service.exception;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * This class represents a key value pair which contains the reason why the given exception occurred.
 */
@Data
@Builder
public class ExceptionDetails implements Serializable {

    private static final long serialVersionUID = 1004889344596041296L;

    private String key;
    private String value;
}
