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
public class Land {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Land(String name) {
        this.name = name;
    }


}
