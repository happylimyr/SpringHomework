package com.nulp.bat.travelagency.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nulp.bat.travelagency.model.Hotel;
import com.nulp.bat.travelagency.model.TourType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class TourDto {

    @NotNull(message = "should be not null")
    private String name;
    @NotNull(message = "should be not null")
    private Double price;
    @NotNull(message = "should be not null")
    private Date dateStart;
    @NotNull(message = "should be not null")
    private Date dateEnd;
    @NotNull(message = "should be not null")
    private Integer peopleNumber;
    @NotNull(message = "should be not null")
    private Integer firePrice;
    @NotNull(message = "should be not null")
    private Hotel hotel;
    @NotNull(message = "should be not null")
    private TourType tourType;
}
