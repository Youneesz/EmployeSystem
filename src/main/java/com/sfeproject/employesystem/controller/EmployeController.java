package com.sfeproject.employesystem.controller;

import com.sfeproject.employesystem.model.Employe;
import com.sfeproject.employesystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employes")
public class EmployeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/getall")
    public List<Employe> getEmployes() {
        return employeeService.getEmployees();
    }

    @GetMapping("/get/{id}")
    public Employe getEmploye(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping("/add")
    public Employe createEmploye(@RequestBody Employe employe) {
        return employeeService.addEmployee(employe);
    }

    @PutMapping("/update/{id}")
    public Employe updateEmploye(@PathVariable int id, @RequestBody Employe employe) {
        return employeeService.updateEmployee(id, employe);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmploye(@PathVariable int id) {
        return employeeService.deleteEmployee(id);
    }
}
