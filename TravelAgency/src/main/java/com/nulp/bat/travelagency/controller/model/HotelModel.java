package com.nulp.bat.travelagency.controller.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.nulp.bat.travelagency.dto.HotelDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class HotelModel extends RepresentationModel<HotelModel> {
    @JsonUnwrapped
    private HotelDto hotelDto;
}
