package com.nulp.bat.travelagency.controller.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.nulp.bat.travelagency.dto.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class RoleModel extends RepresentationModel<RoleModel> {
    @JsonUnwrapped
    private RoleDto roleDto;
}
