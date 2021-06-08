package com.nulp.bat.travelagency.controller.assembler;

import com.nulp.bat.travelagency.controller.CountryController;
import com.nulp.bat.travelagency.controller.HotelTypeController;
import com.nulp.bat.travelagency.controller.model.AddressModel;
import com.nulp.bat.travelagency.controller.model.CountryModel;
import com.nulp.bat.travelagency.controller.model.HotelTypeModel;
import com.nulp.bat.travelagency.dto.AddressDto;
import com.nulp.bat.travelagency.dto.HotelTypeDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class HotelTypeAssembler extends RepresentationModelAssemblerSupport<HotelTypeDto, HotelTypeModel> {

    public HotelTypeAssembler() {
        super(HotelTypeController.class, HotelTypeModel.class);
    }

    public List<HotelTypeModel> modelList(List<HotelTypeDto> entities) {
        return StreamSupport.stream(entities.spliterator(), true).map(this::toModel).collect(Collectors.toList());
    }

    @Override
    public HotelTypeModel toModel(HotelTypeDto entity) {
        HotelTypeModel hotelTypeModel = new HotelTypeModel(entity);

        Link get = linkTo(methodOn(HotelTypeController.class).getHotelType(entity.getName())).withRel("get");
        Link create = linkTo(methodOn(HotelTypeController.class).createHotelType(entity)).withRel("create");
        Link update = linkTo(methodOn(HotelTypeController.class).updateHotelType(entity.getName(), entity))
                .withRel("update");
        Link delete = linkTo(methodOn(HotelTypeController.class).deleteHotelType(entity.getName()))
                .withRel("delete");

        hotelTypeModel.add(get, create, update, delete);

        return hotelTypeModel;
    }
}
