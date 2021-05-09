package com.nulp.bat.travelagency.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUser;
    @Column(unique = true)
    private String loginUser;
    private String passwordUser;
    @OneToOne
    @JoinColumn(name = "PersonalData_idPersonalData", referencedColumnName = "idPersonalData")
    private PersonalData personalData;
    @ManyToOne
    @JoinColumn(name = "role_idRole")
    @JsonIgnoreProperties("user")
    @JsonIgnore
    private Role role;
    @Column(name = "active_status")
    private Integer activeStatus;
}
