package com.epam.spring.boot.SpringHomework4Web.controller.assembler;

import com.epam.spring.boot.SpringHomework4Web.controller.UserController;
import com.epam.spring.boot.SpringHomework4Web.controller.model.UserModel;
import com.epam.spring.boot.SpringHomework4Web.dto.UserDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserAssembler extends RepresentationModelAssemblerSupport<UserDto, UserModel> {

    public UserAssembler() {
        super(UserController.class, UserModel.class);
    }

    @Override
    public UserModel toModel(UserDto entity) {
        UserModel userModel = new UserModel(entity);

        Link getUser = linkTo(methodOn(UserController.class).getUser(entity.getLogin())).withRel("getUser");
        Link deleteUser = linkTo(methodOn(UserController.class).deleteUser(entity.getLogin())).withRel("deleteUser");

        userModel.add(getUser, deleteUser);

        return userModel;
    }
}
