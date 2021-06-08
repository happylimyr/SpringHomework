package com.nulp.bat.travelagency.controller.assembler;

import com.nulp.bat.travelagency.controller.AddressController;
import com.nulp.bat.travelagency.controller.model.AddressModel;
import com.nulp.bat.travelagency.controller.model.UserModel;
import com.nulp.bat.travelagency.dto.AddressDto;
import com.nulp.bat.travelagency.dto.UserDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class AddressAssembler extends RepresentationModelAssemblerSupport<AddressDto, AddressModel> {

    public AddressAssembler() {
        super(AddressController.class, AddressModel.class);
    }

    public List<AddressModel> modelList(List<AddressDto> entities) {
        return StreamSupport.stream(entities.spliterator(), true).map(this::toModel).collect(Collectors.toList());
    }

    @Override
    public AddressModel toModel(AddressDto entity) {
        AddressModel addressModel =new AddressModel(entity);

        Link get = linkTo(methodOn(AddressController.class).getAddress(entity.getName())).withRel("get");
        Link create = linkTo(methodOn(AddressController.class).createAddress(entity)).withRel("create");
        Link update = linkTo(methodOn(AddressController.class).updateAddress(entity.getName(), entity))
                .withRel("update");
        Link delete = linkTo(methodOn(AddressController.class).deleteAddress(entity.getName()))
                .withRel("delete");

        addressModel.add(get, create, update, delete);

        return addressModel;
    }
}
