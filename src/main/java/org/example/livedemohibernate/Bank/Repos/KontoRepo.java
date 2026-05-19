package org.example.livedemohibernate.Bank.Repos;

import org.example.livedemohibernate.Bank.Models.Kategori;
import org.example.livedemohibernate.Bank.Models.Konto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KontoRepo extends JpaRepository<Konto, Long> {


}
