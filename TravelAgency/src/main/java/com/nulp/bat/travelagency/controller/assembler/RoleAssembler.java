package com.nulp.bat.travelagency.controller.assembler;

import com.nulp.bat.travelagency.controller.RoleController;
import com.nulp.bat.travelagency.controller.model.RoleModel;
import com.nulp.bat.travelagency.dto.RoleDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class RoleAssembler extends RepresentationModelAssemblerSupport<RoleDto, RoleModel> {
    public RoleAssembler(){super(RoleController.class, RoleModel.class);}

    @Override
    public RoleModel toModel(RoleDto entity) {
        RoleModel roleModel =new RoleModel(entity);

        Link get = linkTo(methodOn(RoleController.class).getRole(entity.getRole())).withRel("get");
        Link create = linkTo(methodOn(RoleController.class).createRole(entity)).withRel("create");
        Link update = linkTo(methodOn(RoleController.class).updateRole(entity.getRole(), entity))
                .withRel("update");
        Link delete = linkTo(methodOn(RoleController.class).deleteRole(entity.getRole()))
                .withRel("delete");

        roleModel.add(get, create, update, delete);

        return roleModel;
    }
}
