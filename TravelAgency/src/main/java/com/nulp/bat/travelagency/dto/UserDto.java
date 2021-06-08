package com.nulp.bat.travelagency.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nulp.bat.travelagency.model.PersonalData;
import com.nulp.bat.travelagency.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NotNull(message = "login should by not null")
    @Column(unique = true)
    private String loginUser;
    @NotNull(message = "pass should by not null")
    private String passwordUser;
    @NotNull(message = "pers.data should by not null")
    private PersonalData personalData;
    @NotNull(message = "role should by not null")
    private Role role;
    @NotNull(message = "active status should by not null")
    private Integer activeStatus;
}
