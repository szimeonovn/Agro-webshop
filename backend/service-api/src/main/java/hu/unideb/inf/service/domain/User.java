package hu.unideb.inf.service.domain;

import javax.validation.constraints.NotNull;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"password", "passwordConfirmation"})
public class User {

    private Long id;

    @NotNull
    private String firstname;

    @NotNull
    private String lastname;

    @NotNull
    private String email;

    @NotNull
    private String address;

    @NotNull
    private String password;


}
