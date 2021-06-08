package com.nulp.bat.travelagency.controller.assembler;

import com.nulp.bat.travelagency.controller.CityController;
import com.nulp.bat.travelagency.controller.model.AddressModel;
import com.nulp.bat.travelagency.controller.model.CityModel;
import com.nulp.bat.travelagency.dto.AddressDto;
import com.nulp.bat.travelagency.dto.CityDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CityAssembler extends RepresentationModelAssemblerSupport<CityDto, CityModel> {

    public CityAssembler() {
        super(CityController.class, CityModel.class);
    }

    public List<CityModel> modelList(List<CityDto> entities) {
        return StreamSupport.stream(entities.spliterator(), true).map(this::toModel).collect(Collectors.toList());
    }

    @Override
    public CityModel toModel(CityDto entity) {
        CityModel cityModel =new CityModel(entity);

        Link get = linkTo(methodOn(CityController.class).getCity(entity.getName())).withRel("get");
        Link create = linkTo(methodOn(CityController.class).createCity(entity)).withRel("create");
        Link update = linkTo(methodOn(CityController.class).updateCity(entity.getName(), entity))
                .withRel("update");
        Link delete = linkTo(methodOn(CityController.class).deleteCity(entity.getName()))
                .withRel("delete");

        cityModel.add(get, create, update, delete);

        return cityModel;
    }
}
