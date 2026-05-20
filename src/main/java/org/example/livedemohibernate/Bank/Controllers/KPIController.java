package org.example.livedemohibernate.Bank.Controllers;


import org.example.livedemohibernate.Bank.Models.KPI;
import org.example.livedemohibernate.Bank.Repos.KPIRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KPIController {

    private KPIRepo kpiRepo;

    public KPIController(KPIRepo kpiRepo) {
        this.kpiRepo = kpiRepo;
    }

    @GetMapping("/KPI")
    public List<KPI> getKPIs(){
        return kpiRepo.findAll();
    }

    @PostMapping("/KPI")
    public List<KPI> getKPIs(@RequestBody KPI kpi){
        kpiRepo.save(kpi);
        return kpiRepo.findAll();
    }

    @GetMapping("/helloWorld")
    public String helloWorld(){
        return "Hello World";
    }


}
