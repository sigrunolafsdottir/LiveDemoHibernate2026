package org.example.livedemohibernate.Bank.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private KPI kpi;

    public Customer(String name, String address, KPI kpi) {
        this.name = name;
        this.address = address;
        this.kpi = kpi;
    }

}
