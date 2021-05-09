package com.nulp.bat.travelagency.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
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
    @JsonIgnore
    private Long idPersonalData;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String phone;
    /// ???
    @OneToOne(mappedBy = "personalData")
    @JsonIgnore
//    private List<User> userList = new ArrayList<>();
    private User user;
}
