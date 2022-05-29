package com.sfeproject.employesystem.controller;

import com.sfeproject.employesystem.model.Conge;
import com.sfeproject.employesystem.service.CongeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conges")
public class CongeController {

    @Autowired
    private CongeService congeService;

    @GetMapping("/getall")
    public List<Conge> getConges(){
        return congeService.getConges();
    }

    @GetMapping("/get/{id}")
    public Conge getConge(@PathVariable int id){
        return congeService.getConge(id);
    }

    @RequestMapping("/add")
    public Conge addConge(@RequestBody Conge conge){
        return congeService.saveConge(conge);
    }

    @PutMapping("/update/{id}")
    public Conge updateConge(@RequestBody Conge conge, @PathVariable int id){
        return congeService.updateConge(id,conge);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteConge(@PathVariable int id){
        return congeService.deleteConge(id);
    }
}
