package com.nulp.bat.travelagency.controller.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.nulp.bat.travelagency.dto.TourDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class TourModel extends RepresentationModel<TourModel>{
    @JsonUnwrapped
    private TourDto tourDto;
}
