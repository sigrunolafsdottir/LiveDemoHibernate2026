package org.example.livedemohibernate.Tomten.Models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Child {

    @Id
    @GeneratedValue
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String name;
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    public Surveillance surveillance;

    //Många barn bor i samma land, här vill vi inte ha cascade.ALL, bara när vi sparar ner
    @ManyToOne
    @JoinColumn
    public Land land;

    @ManyToMany
    @JoinTable
    public List<Gift> wishes;

    public Child(String name, String address, Surveillance surveillance) {
        this.name = name;
        this.address = address;
        this.surveillance = surveillance;
    }

    public Child(String name, String address, Surveillance surveillance, Land land) {
        this.name = name;
        this.address = address;
        this.surveillance = surveillance;
        this.land = land;
    }


}
