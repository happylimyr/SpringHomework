package com.nulp.bat.travelagency.controller.assembler;

import com.nulp.bat.travelagency.controller.PersonalDataController;
import com.nulp.bat.travelagency.controller.UserController;
import com.nulp.bat.travelagency.controller.model.PersonalDataModel;
import com.nulp.bat.travelagency.controller.model.TourModel;
import com.nulp.bat.travelagency.controller.model.UserModel;
import com.nulp.bat.travelagency.dto.PersonalDataDto;
import com.nulp.bat.travelagency.dto.TourDto;
import com.nulp.bat.travelagency.dto.UserDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserAssembler extends RepresentationModelAssemblerSupport<UserDto, UserModel> {

    public UserAssembler() {
        super(UserController.class, UserModel.class);
    }

    @Override
    public CollectionModel<UserModel> toCollectionModel(Iterable<? extends UserDto> entities) {
        List<UserModel> userModelList = StreamSupport.stream(entities.spliterator(), true).map(this::toModel).collect(Collectors.toList());
        return super.toCollectionModel(entities);

    }
    public List<UserModel> userModelList(List<UserDto> entities) {
        return StreamSupport.stream(entities.spliterator(), true).map(this::toModel).collect(Collectors.toList());
    }

    @Override
    public UserModel toModel(UserDto entity) {
        UserModel userModel = new UserModel(entity);

        Link get = linkTo(methodOn(UserController.class).getUser(entity.getLoginUser())).withRel("get");
        Link create = linkTo(methodOn(UserController.class).createUser(entity)).withRel("create");
        Link update = linkTo(methodOn(UserController.class).updateUser(entity.getLoginUser(), entity))
                .withRel("update");
        Link delete = linkTo(methodOn(UserController.class).deleteUser(entity.getLoginUser()))
                .withRel("delete");

        userModel.add(get, create, update, delete);

        return userModel;
    }
}

