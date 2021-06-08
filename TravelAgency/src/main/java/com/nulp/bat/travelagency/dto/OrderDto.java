package com.nulp.bat.travelagency.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.nulp.bat.travelagency.model.Status;
import com.nulp.bat.travelagency.model.Tour;
import com.nulp.bat.travelagency.model.User;
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
public class OrderDto {
    @NotNull(message = "hotel name should be not null")
    private String orderName;
    private String discount;
    @NotNull(message = "hotel name should be not null")
    private Integer countOfMembers;
    //    @NotNull(message = "hotel name should be not null")
//    private User user;
    @NotNull(message = "hotel name should be not null")
    private Status status;
    @NotNull(message = "hotel name should be not null")
    private Tour tour;
    @NotNull(message = "hotel name should be not null")
    private User user;


}
