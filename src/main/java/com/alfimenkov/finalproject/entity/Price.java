package com.alfimenkov.finalproject.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "price")
public class Price {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "basic_price")
    private Double basic_price;

    @Column(name = "vip_price")
    private Double vip_price;

    /*@OneToOne(mappedBy = "price", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Tour tour;*/

}
