package com.epam.spring.boot.SpringHomework4Web.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    @NotNull(message = "Should be not null")
    private String firstName;
    @NotNull(message = "Should be not null")
    private String lastName;
    @NotNull(message = "Should be not null")
    @Size(message = "min 6 symbols",min = 6)
    private String login;
    @NotNull(message = "Should be not null")
    @ValidPassword(message = "invalid password")
    private String password;
    @NotNull(message = "Should be not null")
    @ValidPassword(message = "invalid password")
    private String repeatPassword;
}
