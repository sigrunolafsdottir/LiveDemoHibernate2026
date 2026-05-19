package org.example.livedemohibernate.Bank.Repos;

import org.example.livedemohibernate.Bank.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
}
