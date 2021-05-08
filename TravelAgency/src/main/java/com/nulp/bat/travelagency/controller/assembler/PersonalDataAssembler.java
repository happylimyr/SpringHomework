package com.nulp.bat.travelagency.controller.assembler;

import com.nulp.bat.travelagency.controller.PersonalDataController;
import com.nulp.bat.travelagency.controller.model.PersonalDataModel;
import com.nulp.bat.travelagency.dto.PersonalDataDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PersonalDataAssembler extends RepresentationModelAssemblerSupport<PersonalDataDto, PersonalDataModel> {

    public PersonalDataAssembler() {
        super(PersonalDataController.class, PersonalDataModel.class);
    }

    @Override
    public PersonalDataModel toModel(PersonalDataDto entity) {
        PersonalDataModel personalDataModel =new PersonalDataModel(entity);

        Link get = linkTo(methodOn(PersonalDataController.class).getPersonalData(entity.getEmail())).withRel("get");
        Link create = linkTo(methodOn(PersonalDataController.class).createPersonalData(entity)).withRel("create");
        Link update = linkTo(methodOn(PersonalDataController.class).updatePersonalData(entity.getEmail(), entity))
                .withRel("update");
        Link delete = linkTo(methodOn(PersonalDataController.class).deletePersonalData(entity.getEmail()))
                .withRel("delete");

        personalDataModel.add(get, create, update, delete);

        return personalDataModel;
    }
}
