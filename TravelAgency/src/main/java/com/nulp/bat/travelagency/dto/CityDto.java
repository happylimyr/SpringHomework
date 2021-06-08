package com.nulp.bat.travelagency.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nulp.bat.travelagency.model.Address;
import com.nulp.bat.travelagency.model.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class CityDto {
    @NotNull(message = "City name should by not null")
    private String name;
    @NotNull(message = "country name should by not null")
    private Country country;
    private List<Address> addressList;
}
