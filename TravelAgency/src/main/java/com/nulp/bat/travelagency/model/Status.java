package com.nulp.bat.travelagency.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "status")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Status {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "id_status")
    private Long idStatus;
    private String name;
    private String description;
//    @OneToMany
//    @JsonIgnore

}
