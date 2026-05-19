package org.example.livedemohibernate.Bank.Repos;

import org.example.livedemohibernate.Bank.Models.Customer;
import org.example.livedemohibernate.Bank.Models.KPI;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KPIRepo extends JpaRepository<KPI, Long> {


}
