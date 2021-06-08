package com.nulp.bat.travelagency.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.micrometer.core.annotation.Counted;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "id_user")
    private Long idUser;
    @Column(unique = true)
    private String loginUser;
    private String passwordUser;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "personal_data_id_personal_data", referencedColumnName = "idPersonalData")
    private PersonalData personalData;
    @ManyToOne
    @JoinColumn(name = "role_id_role")
    @JsonIgnoreProperties("user")
    @JsonIgnore
    private Role role;
    @Column(name = "active_status")
    private Integer activeStatus;
    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL)
    @JsonIgnore
    private List<Order> orderList = new ArrayList<>();


}