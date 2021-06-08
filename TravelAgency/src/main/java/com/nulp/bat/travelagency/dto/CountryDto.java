package com.nulp.bat.travelagency.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nulp.bat.travelagency.model.City;
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
public class CountryDto {
    @NotNull(message = "Should by not null")
    private String name;
    private List<City> cityList;
}
