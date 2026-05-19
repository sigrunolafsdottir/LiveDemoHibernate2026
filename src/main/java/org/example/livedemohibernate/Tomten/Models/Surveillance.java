package org.example.livedemohibernate.Tomten.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Surveillance {

    @Id
    @GeneratedValue
    private Long id;
    private boolean isNice = true;
    private int politicalCorectness;

    public Surveillance(boolean isNice, int politicalCorectness) {
        this.isNice = isNice;
        this.politicalCorectness = politicalCorectness;
    }


}
