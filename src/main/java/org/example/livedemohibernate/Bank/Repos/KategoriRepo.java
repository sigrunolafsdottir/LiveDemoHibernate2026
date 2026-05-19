package org.example.livedemohibernate.Bank.Repos;

import org.example.livedemohibernate.Bank.Models.KPI;
import org.example.livedemohibernate.Bank.Models.Kategori;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KategoriRepo extends JpaRepository<Kategori, Long> {


}
