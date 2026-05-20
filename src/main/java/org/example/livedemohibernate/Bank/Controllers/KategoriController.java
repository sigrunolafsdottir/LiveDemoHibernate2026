package org.example.livedemohibernate.Bank.Controllers;


import org.example.livedemohibernate.Bank.Models.KPI;
import org.example.livedemohibernate.Bank.Models.Kategori;
import org.example.livedemohibernate.Bank.Repos.KPIRepo;
import org.example.livedemohibernate.Bank.Repos.KategoriRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KategoriController {

    private KategoriRepo kategoriRepo;

    public KategoriController(KategoriRepo kategoriRepo) {
        this.kategoriRepo = kategoriRepo;
    }

    @GetMapping("/Kategori")
    public List<Kategori> getKategorier(){
        return kategoriRepo.findAll();
    }

    @GetMapping("/Kategori/{id}")
    public Kategori getKategoriById(@PathVariable Long id){
        return kategoriRepo.findById(id).get();
    }

    @PostMapping("/Kategori")
    public List<Kategori> addKategorier(@RequestBody Kategori kategori){
        kategoriRepo.save(kategori);
        return kategoriRepo.findAll();
    }


}
