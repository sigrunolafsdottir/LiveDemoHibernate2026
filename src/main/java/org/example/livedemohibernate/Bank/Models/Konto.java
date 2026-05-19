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
public class Konto {

    @Id
    @GeneratedValue
    private Long id;

    private Integer balance;
    private Integer interest;


    public Konto(Integer balance, Integer interest) {
        this.balance = balance;
        this.interest = interest;
    }

}
