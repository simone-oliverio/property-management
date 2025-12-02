package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PROPERTY_TABLE")
@Getter
@Setter
@NoArgsConstructor
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
/*    @SequenceGenerator(
            name = "property_seq",
            sequenceName = "property_table_seq",
            allocationSize = 1 // Incremento di 1 invece di 50 di default
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "property_seq")
*/
    private Long   id;

    @Column(name = "PROPERTY_TITLE", nullable = false)
    private String title;
    private String description;
    private String ownerName;

    @Column(name = "EMAIL", nullable = false)
    private String ownerMail;
    private Double price;
    private String address;

}
