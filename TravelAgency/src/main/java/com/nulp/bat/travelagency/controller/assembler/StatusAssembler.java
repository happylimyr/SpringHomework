package com.nulp.bat.travelagency.controller.assembler;

import com.nulp.bat.travelagency.controller.StatusController;
import com.nulp.bat.travelagency.controller.model.AddressModel;
import com.nulp.bat.travelagency.controller.model.StatusModel;
import com.nulp.bat.travelagency.dto.AddressDto;
import com.nulp.bat.travelagency.dto.StatusDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class StatusAssembler extends RepresentationModelAssemblerSupport<StatusDto, StatusModel> {

    public StatusAssembler() {
        super(StatusController.class, StatusModel.class);
    }

    public List<StatusModel> modelList(List<StatusDto> entities) {
        return StreamSupport.stream(entities.spliterator(), true).map(this::toModel).collect(Collectors.toList());
    }

    @Override
    public StatusModel toModel(StatusDto entity) {
        StatusModel statusModel =new StatusModel(entity);

        Link get = linkTo(methodOn(StatusController.class).getStatus(entity.getName())).withRel("get");
        Link create = linkTo(methodOn(StatusController.class).createStatus(entity)).withRel("create");
        Link update = linkTo(methodOn(StatusController.class).updateStatus(entity.getName(), entity))
                .withRel("update");
        Link delete = linkTo(methodOn(StatusController.class).deleteStatus(entity.getName()))
                .withRel("delete");

        statusModel.add(get, create, update, delete);

        return statusModel;
    }
}
