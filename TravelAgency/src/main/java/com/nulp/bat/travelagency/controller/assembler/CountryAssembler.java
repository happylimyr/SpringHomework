package com.nulp.bat.travelagency.controller.assembler;

import com.nulp.bat.travelagency.controller.CityController;
import com.nulp.bat.travelagency.controller.CountryController;
import com.nulp.bat.travelagency.controller.model.AddressModel;
import com.nulp.bat.travelagency.controller.model.CountryModel;
import com.nulp.bat.travelagency.dto.AddressDto;
import com.nulp.bat.travelagency.dto.CountryDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CountryAssembler extends RepresentationModelAssemblerSupport<CountryDto, CountryModel> {

    public CountryAssembler() {
        super(CountryController.class, CountryModel.class);
    }

    public List<CountryModel> modelList(List<CountryDto> entities) {
        return StreamSupport.stream(entities.spliterator(), true).map(this::toModel).collect(Collectors.toList());
    }

    @Override
    public CountryModel toModel(CountryDto entity) {
        CountryModel countryModel = new CountryModel(entity);

        Link get = linkTo(methodOn(CountryController.class).getCountry(entity.getName())).withRel("get");
        Link create = linkTo(methodOn(CountryController.class).createCountry(entity)).withRel("create");
        Link update = linkTo(methodOn(CountryController.class).updateCountry(entity.getName(), entity))
                .withRel("update");
        Link delete = linkTo(methodOn(CountryController.class).deleteCountry(entity.getName()))
                .withRel("delete");

        countryModel.add(get, create, update, delete);

        return countryModel;
    }
}
