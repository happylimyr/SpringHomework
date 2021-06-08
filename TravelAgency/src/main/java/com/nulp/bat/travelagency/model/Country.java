package com.nulp.bat.travelagency.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "country")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "id_country")
    private Long idCountry;
    private String name;
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<City> cityList;

}
