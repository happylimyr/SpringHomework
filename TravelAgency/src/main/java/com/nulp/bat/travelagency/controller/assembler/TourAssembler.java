package com.nulp.bat.travelagency.controller.assembler;

import com.nulp.bat.travelagency.controller.TourController;
import com.nulp.bat.travelagency.controller.model.TourModel;
import com.nulp.bat.travelagency.dto.TourDto;
import com.nulp.bat.travelagency.model.Tour;
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
public class TourAssembler extends RepresentationModelAssemblerSupport<TourDto, TourModel> {

    public TourAssembler() {
        super(TourController.class, TourModel.class);
    }

    @Override
    public CollectionModel<TourModel> toCollectionModel(Iterable<? extends TourDto> entities) {
        List<TourModel> collectTourModels = StreamSupport.stream(entities.spliterator(), true).map(this::toModel).collect(Collectors.toList());
        return super.toCollectionModel(entities);

    }

    public List<TourModel> tourModelList(List<TourDto> entities) {
        return StreamSupport.stream(entities.spliterator(), true).map(this::toModel).collect(Collectors.toList());
    }

    @Override
    public TourModel toModel(TourDto entity) {
        TourModel tourModel = new TourModel(entity);

//        Link getAll = linkTo(methodOn(TourController.class).getAllTour(entity.getName())).withRel("get");
        Link get = linkTo(methodOn(TourController.class).getTour(entity.getName())).withRel("get");
        Link create = linkTo(methodOn(TourController.class).createTour(entity)).withRel("create");
        Link update = linkTo(methodOn(TourController.class).updateTour(entity.getName(), entity))
                .withRel("update");
        Link delete = linkTo(methodOn(TourController.class).deleteTour(entity.getName()))
                .withRel("delete");

        tourModel.add(get, create, update, delete);

        return tourModel;
    }
}
