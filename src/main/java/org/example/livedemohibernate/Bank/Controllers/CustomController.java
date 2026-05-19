package org.example.livedemohibernate.Bank.Controllers;


import org.example.livedemohibernate.Bank.Models.Customer;
import org.example.livedemohibernate.Bank.Models.KPI;
import org.example.livedemohibernate.Bank.Repos.CustomerRepo;
import org.example.livedemohibernate.Bank.Repos.KPIRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomController {

    private KPIRepo kpiRepo;
    private CustomerRepo customerRepo;

    public CustomController(KPIRepo kpiRepo, CustomerRepo customerRepo) {
        this.kpiRepo = kpiRepo;
        this.customerRepo = customerRepo;
    }

    @GetMapping("/Customer")
    public List<Customer> getCustomers(){
        return customerRepo.findAll();
    }

    @PostMapping("/Customer")
    public List<Customer> addCustomer(@RequestBody Customer customer){
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
