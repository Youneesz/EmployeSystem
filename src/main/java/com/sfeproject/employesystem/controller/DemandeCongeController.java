package com.sfeproject.employesystem.controller;


import com.sfeproject.employesystem.model.DemandeConge;
import com.sfeproject.employesystem.service.DemandeCongeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demandesconge")
@CrossOrigin
public class DemandeCongeController {

    @Autowired
    private DemandeCongeService demandeCongeService;

    @GetMapping("/get/{id}")
    public DemandeConge getDemandeConge(@PathVariable int id){
        return demandeCongeService.getDemangeConge(id);
    }

    @GetMapping("/getall")
    public List<DemandeConge> getDemandesConge(){
        return demandeCongeService.getDemandesConge();
    }

    @PostMapping("/add/{id_emp}/{id_conge}")
    public DemandeConge addDemandeConge(@RequestBody DemandeConge demandeConge, @PathVariable int id_emp, @PathVariable int id_conge){
        return demandeCongeService.addDemandeConge(demandeConge, id_emp, id_conge);
    }

    @PutMapping("/update/{id}")
    public DemandeConge updateDemandeConge(@PathVariable int id,@RequestBody DemandeConge demandeConge){
        return demandeCongeService.updateDemandeConge(id,demandeConge);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteDemandeConge(@PathVariable int id){
        return demandeCongeService.deleteDemangeConge(id);
    }

}
