package com.nulp.bat.travelagency.controller.assembler;

import com.nulp.bat.travelagency.controller.TourTypeController;
import com.nulp.bat.travelagency.controller.model.AddressModel;
import com.nulp.bat.travelagency.controller.model.TourTypeModel;
import com.nulp.bat.travelagency.dto.AddressDto;
import com.nulp.bat.travelagency.dto.TourTypeDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class TourTypeAssembler extends RepresentationModelAssemblerSupport<TourTypeDto, TourTypeModel> {

    public TourTypeAssembler() {
        super(TourTypeController.class, TourTypeModel.class);
    }

    public List<TourTypeModel> modelList(List<TourTypeDto> entities) {
        return StreamSupport.stream(entities.spliterator(), true).map(this::toModel).collect(Collectors.toList());
    }

    @Override
    public TourTypeModel toModel(TourTypeDto entity) {
        TourTypeModel tourTypeModel = new TourTypeModel(entity);

        Link get = linkTo(methodOn(TourTypeController.class).getTourType(entity.getName())).withRel("get");
        Link create = linkTo(methodOn(TourTypeController.class).createTourType(entity)).withRel("create");
        Link update = linkTo(methodOn(TourTypeController.class).updateTourType(entity.getName(), entity))
                .withRel("update");
        Link delete = linkTo(methodOn(TourTypeController.class).deleteTourType(entity.getName()))
                .withRel("delete");

        tourTypeModel.add(get, create, update, delete);

        return tourTypeModel;
    }
}
