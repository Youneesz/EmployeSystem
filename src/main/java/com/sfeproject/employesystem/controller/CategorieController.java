package com.sfeproject.employesystem.controller;

import com.sfeproject.employesystem.model.Categorie;
import com.sfeproject.employesystem.repository.CategorieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin
public class CategorieController {
    private final CategorieRepository categorieRepository;

    public CategorieController(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    @PostMapping("/add")
    public Categorie add(@RequestBody Categorie categorie)
    {
        return categorieRepository.save(categorie);
    }

    @PutMapping("/update/{id}")
    public Categorie update(@PathVariable int id, @RequestBody Categorie categorie)
    {
        Categorie up = categorieRepository.findById(id).orElseThrow(RuntimeException::new);
        up.setIntituleCat(categorie.getIntituleCat());
        return categorieRepository.save(up);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        categorieRepository.deleteById(id);
        return "Categorie deleted!";
    }

    @GetMapping("/get/{id}")
    public Categorie get(@PathVariable int id) {
        return categorieRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @GetMapping("/getall")
    public List<Categorie> getall() {
        return categorieRepository.findAll();
    }
}
