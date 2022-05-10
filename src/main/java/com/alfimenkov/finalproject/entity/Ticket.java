package com.alfimenkov.finalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ticket")
@Accessors(chain = true)
@NamedEntityGraph(
    name = "ticket-entity-graph",
    attributeNodes = {
            @NamedAttributeNode(value = "tour", subgraph = "tour-sub-graph"),
            @NamedAttributeNode(value = "user")
    },
        subgraphs ={
            @NamedSubgraph(
                    name = "tour-sub-graph",
                    attributeNodes = {
                            @NamedAttributeNode("categories")
                }
            )
        }
)
public class Ticket {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_surname")
    private String customerSurname;

    @Column(name = "date")
    private Timestamp date;

    @Column(name = "order_date")
    private Timestamp orderDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tour_id")
    private Tour tour;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", customerSurname='" + customerSurname + '\'' +
                ", date=" + date +
                ", tour=" + tour.getName() +
                ", user=" + user.getName() +
                '}';
    }
}
