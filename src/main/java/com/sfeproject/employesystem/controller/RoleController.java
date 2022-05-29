package com.sfeproject.employesystem.controller;

import com.sfeproject.employesystem.model.Role;
import com.sfeproject.employesystem.repository.RoleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
@CrossOrigin
public class RoleController {

    private final RoleRepository roleRepository;

    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostMapping("/add")
    public String add(@RequestBody Role role) {
        Role nouvRole = roleRepository.save(role);
        return "Role " + nouvRole.getIntituleRole() + " added.";
    }

    @GetMapping("/getAll")
    public List<Role> list() {
        return roleRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<Role> getRole(@PathVariable int id) {
        return roleRepository.findById(id);
    }
}
