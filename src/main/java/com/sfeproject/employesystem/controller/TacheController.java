package com.sfeproject.employesystem.controller;

import com.sfeproject.employesystem.model.Tache;
import com.sfeproject.employesystem.service.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/taches")
@CrossOrigin
public class TacheController {

    @Autowired
    private TacheService tacheService;


    @GetMapping("/getall")
    public List<Tache> getTaches() {
        return tacheService.getAllTaches();
    }

    @GetMapping("/get/{id}")
    public Tache getTache(@PathVariable int id) {
        return tacheService.getTache(id);
    }

    @PostMapping("/add")
    public Tache saveTache(@RequestBody Tache tache) {
        return tacheService.addTache(tache);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTache(@PathVariable int id) {
        return tacheService.deleteTache(id);
    }

    @PutMapping("/update/{id}")
    public Tache updateTache(@PathVariable int id, @RequestBody Tache tache) {
        return tacheService.updateTache(id, tache);
    }

}
