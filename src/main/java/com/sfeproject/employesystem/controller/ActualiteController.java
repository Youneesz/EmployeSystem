package com.sfeproject.employesystem.controller;

import com.sfeproject.employesystem.model.Actualite;

import com.sfeproject.employesystem.service.ActualiteService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/actualites")
public class ActualiteController {

    @Autowired
    private ActualiteService actualiteService;

    @GetMapping("/getall")
    public List<Actualite> getAll() {
        return actualiteService.getActualites();
    }

    @GetMapping("/get/{id}")
    public Actualite getActualite(@PathVariable int id) {
        return actualiteService.getActualite(id);
    }

    @PutMapping("/update/{id}")
    public Actualite updateActualite(@PathVariable int id, @RequestBody Actualite actualite) {
        return actualiteService.updateActualite(id, actualite);
    }

    @PostMapping("/add")
    public Actualite addActualite(@RequestBody Actualite actualite) {
        return actualiteService.saveActualite(actualite);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteActualite(@PathVariable int id) {
        return actualiteService.deleteActualite(id);
    }
}
