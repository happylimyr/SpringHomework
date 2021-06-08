package com.nulp.bat.travelagency.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "personal_data")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonalData {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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
//
//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "personalDataSet")
//    private Set<Order> orderSet = new HashSet<>();
}
