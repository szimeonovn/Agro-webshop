package hu.unideb.inf.web.rest.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDetails {

    private String key;
    private String value;
}
