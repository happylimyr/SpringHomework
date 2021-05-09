package com.nulp.bat.travelagency.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nulp.bat.travelagency.model.PersonalData;
import com.nulp.bat.travelagency.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {


    @NotNull(message = "should by not null")
    private String loginUser;
    @NotNull(message = "should by not null")
    private String passwordUser;
    @NotNull(message = "should by not null")
    private PersonalData personalData;
    @NotNull(message = "should by not null")
    private String role;
    @NotNull(message = "should by not null")
    private Integer activeStatus;
}
