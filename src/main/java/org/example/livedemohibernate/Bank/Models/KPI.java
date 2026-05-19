package org.example.livedemohibernate.Bank.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class KPI {

    @Id
    @GeneratedValue
    private Long id;

    private int creditNumber;

    public KPI(int creditNumber) {
        this.creditNumber = creditNumber;
    }

}
