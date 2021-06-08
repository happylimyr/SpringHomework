package com.nulp.bat.travelagency.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nulp.bat.travelagency.model.Address;
import com.nulp.bat.travelagency.model.HotelType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class HotelDto {
    @NotNull(message = "hotel name should be not null")
    private String name;
    @NotNull(message = "hotel address should be not null")
    private Address address;
//    @NotNull(message = "hotel city should be not null")
//    private String city;
//    @NotNull(message = "hotel country should be not null")
//    private String country;
    @NotNull(message = "hotel type should be not null")
    private HotelType hotelType;
}
