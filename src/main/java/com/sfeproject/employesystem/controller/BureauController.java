package com.sfeproject.employesystem.controller;

import com.sfeproject.employesystem.model.Bureau;
import com.sfeproject.employesystem.repository.BureauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/bureaux")
@CrossOrigin
public class BureauController{

    @Autowired
    private final BureauRepository bureauRepository;

    public BureauController(BureauRepository bureauRepository) {
        this.bureauRepository = bureauRepository;
    }

    @PostMapping("/add")
    public Bureau add(@RequestBody Bureau bureau) {
        return bureauRepository.save(bureau);
    }

    @PutMapping("/update/{id}")
    public Bureau update(@PathVariable int id, @RequestBody Bureau bureau)
    {
        Bureau up = bureauRepository.findById(id).orElseThrow(RuntimeException::new);
        up.setIntituleBureau(bureau.getIntituleBureau());
        up.setDescriptionBureau(bureau.getDescriptionBureau());
        return bureauRepository.save(up);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        bureauRepository.deleteById(id);
        return "Bureau deleted!";
    }

    @GetMapping("/getall")
    public List<Bureau> getAll() {
        return bureauRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Bureau get(@PathVariable int id) {
        return bureauRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
