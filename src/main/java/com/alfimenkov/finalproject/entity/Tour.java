package com.alfimenkov.finalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tour")
public class Tour {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "ticket_quantity")
    private int quantity;

    @ManyToMany
    @JoinTable(
            name = "tour_category",
            joinColumns = {@JoinColumn(name="tour_id")},
            inverseJoinColumns = {@JoinColumn(name="category_id")}
    )
    List<Category> categories = new ArrayList<Category>();
}
