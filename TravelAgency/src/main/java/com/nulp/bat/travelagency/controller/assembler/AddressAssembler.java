package com.nulp.bat.travelagency.controller.assembler;

import com.nulp.bat.travelagency.controller.AddressController;
import com.nulp.bat.travelagency.controller.model.AddressModel;
import com.nulp.bat.travelagency.dto.AddressDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class AddressAssembler extends RepresentationModelAssemblerSupport<AddressDto, AddressModel> {

    public AddressAssembler() {
        super(AddressController.class, AddressModel.class);
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
