package com.nulp.bat.travelagency.controller.assembler;

import com.nulp.bat.travelagency.controller.HotelController;
import com.nulp.bat.travelagency.controller.model.AddressModel;
import com.nulp.bat.travelagency.controller.model.HotelModel;
import com.nulp.bat.travelagency.dto.AddressDto;
import com.nulp.bat.travelagency.dto.HotelDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class HotelAssembler extends RepresentationModelAssemblerSupport<HotelDto, HotelModel> {

    public HotelAssembler(){
        super(HotelAssembler.class, HotelModel.class );
    }

    public List<HotelModel> modelList(List<HotelDto> entities) {
        return StreamSupport.stream(entities.spliterator(), true).map(this::toModel).collect(Collectors.toList());
    }

    @Override
    public HotelModel toModel(HotelDto entity) {
        HotelModel hotelModel = new HotelModel(entity);

        Link get = linkTo(methodOn(HotelController.class).getHotel(entity.getName())).withRel("get");
        Link create = linkTo(methodOn(HotelController.class).createHotel(entity)).withRel("create");
        Link update = linkTo(methodOn(HotelController.class).updateHotel(entity.getName(), entity))
                .withRel("update");
        Link delete = linkTo(methodOn(HotelController.class).deleteHotel(entity.getName()))
                .withRel("delete");

        hotelModel.add(get, create, update, delete);

        return hotelModel;
    }
}
