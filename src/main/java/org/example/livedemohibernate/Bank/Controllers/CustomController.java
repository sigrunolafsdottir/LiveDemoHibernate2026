package org.example.livedemohibernate.Bank.Controllers;


import org.example.livedemohibernate.Bank.Models.Customer;
import org.example.livedemohibernate.Bank.Models.KPI;
import org.example.livedemohibernate.Bank.Models.Konto;
import org.example.livedemohibernate.Bank.Repos.CustomerRepo;
import org.example.livedemohibernate.Bank.Repos.KPIRepo;
import org.example.livedemohibernate.Bank.Repos.KontoRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomController {

    private KPIRepo kpiRepo;
    private CustomerRepo customerRepo;
    private KontoRepo kontoRepo;

    public CustomController(KPIRepo kpiRepo, CustomerRepo customerRepo, KontoRepo kontoRepo) {
        this.kpiRepo = kpiRepo;
        this.customerRepo = customerRepo;
        this.kontoRepo = kontoRepo;
    }

    @GetMapping("/Customer")
    public List<Customer> getCustomers(){
        return customerRepo.findAll();
    }

    @PostMapping("/Customer")
    public List<Customer> addCustomer(@RequestBody Customer customer){
        List<Konto> kontos = customer.getKonton();
        for (Konto konto : kontos) {
            kontoRepo.save(konto);
        }

        //kpiRepo.save(customer.getKpi());
        customerRepo.save(customer);
        return customerRepo.findAll();
    }

    @DeleteMapping("/Customer/{id}")
    public List<Customer> deleteCustomer(@PathVariable Long id){
        customerRepo.deleteById(id);
        return customerRepo.findAll();
    }

}
