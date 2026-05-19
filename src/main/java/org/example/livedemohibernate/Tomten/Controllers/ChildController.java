package org.example.livedemohibernate.Tomten.Controllers;

import org.example.livedemohibernate.Tomten.Models.Child;
import org.example.livedemohibernate.Tomten.Repos.ChildRepo;
import org.example.livedemohibernate.Tomten.Repos.SurveillanceRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChildController {

    ChildRepo childRepo;
    SurveillanceRepo sRepo;

    public ChildController(ChildRepo childRepo, SurveillanceRepo sRepo){
        this.childRepo = childRepo;
        this.sRepo = sRepo;
    }

    @GetMapping("/child")
    public List<Child> getChildren(){
        return childRepo.findAll();
    }

    @PostMapping("/child")
    public List<Child> getChildren(@RequestBody Child child){
        childRepo.save(child);
        return childRepo.findAll();
    }

}
