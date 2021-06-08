package com.nulp.bat.travelagency.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "id_order")
    private Long idOrder;
    @Column(name = "order_name")
    private String orderName;
    @Column(name = "discount")
    private String discount;
    @Column(name = "count_of_members")
    private Integer countOfMembers;
    @ManyToOne
    @JoinColumn(name = "status_id_status")
    @JsonIgnore
    private Status status;
    @ManyToOne
    @JoinColumn(name = "tour_id_tour")
    private Tour tour;
    @ManyToOne
    @JoinColumn(name = "user_id_user")
    private User user;


}
