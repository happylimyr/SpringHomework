package com.nulp.bat.travelagency.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "personal_data")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonalData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPersonalData;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String phone;

}
