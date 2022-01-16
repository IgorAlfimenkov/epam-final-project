package com.alfimenkov.finalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tour")
@NamedEntityGraph(
        name = "tour-entity-graph",
        attributeNodes = {
                @NamedAttributeNode(value = "categories"),
                @NamedAttributeNode(value = "price")
        }
)
public class Tour {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "ticket_quantity")
    private Integer quantity;

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(
            name = "tour_category",
            joinColumns = {@JoinColumn(name="tour_id")},
            inverseJoinColumns = {@JoinColumn(name="category_id")}
    )
    List<Category> categories = new ArrayList<Category>();

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "price_id")
    private Price price;




    @Override
    public boolean equals(Object o) {

        Tour tour = (Tour) o;
        return id == tour.getId();
    }

    @Override
    public String toString() {


        return "Tour{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
