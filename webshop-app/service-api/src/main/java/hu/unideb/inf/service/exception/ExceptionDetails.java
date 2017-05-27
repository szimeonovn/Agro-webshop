package hu.unideb.inf.service.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionDetails {
    private String key;
    private String value;
}
