package com.sfeproject.employesystem.service;


import com.sfeproject.employesystem.model.DemandeConge;
import com.sfeproject.employesystem.model.DemandePiece;
import com.sfeproject.employesystem.model.Employe;
import com.sfeproject.employesystem.repository.DemandeCongeRepository;
import com.sfeproject.employesystem.repository.DemandePieceRepository;
import com.sfeproject.employesystem.repository.EmployeRepository;
import com.sfeproject.employesystem.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeRepository employeRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private DemandeCongeRepository demandeCongeRepository;

    @Autowired
    private DemandePieceRepository demandePieceRepository;


    @Override
    public Employe addEmployee(Employe employee) {
        for (Employe e : employeRepository.findAll()) {
            if (e.equals(employee)) {
                return null;
            }
        }
        employee.setRole(roleRepository.findById(employee.getRole().getCodeRole()).orElseThrow(RuntimeException::new));
        return employeRepository.save(employee);
    }

    @Override
    public Employe getEmployee(int id) {
        return employeRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Employe> getEmployees() {
        return employeRepository.findAll();
    }

    @Override
    public Employe updateEmployee(int id, Employe employee) {
        for (Employe e : employeRepository.findAll()) {
            if (e.equals(employee)) {
                return null;
            }
        }
        Employe temp = getEmployee(id);
        temp.setNomEmp(employee.getNomEmp());
        temp.setAdresseEmp(employee.getAdresseEmp());
        temp.setAdresseTravail(employee.getAdresseTravail());
        temp.setMotPasse(employee.getMotPasse());
        temp.setPrenomEmp(employee.getPrenomEmp());
        temp.setTelEmp(employee.getTelEmp());
        temp.setNomEmpfr(employee.getNomEmpfr());
        temp.setPrenomEmpfr(employee.getPrenomEmpfr());
        temp.setEmailEmp(employee.getEmailEmp());
        temp.setRole(employee.getRole());
        temp.setCadreFr(employee.getCadreFr());
        temp.setCinEmp(employee.getCinEmp());
        temp.setCodeSomme(employee.getCodeSomme());
        temp.setDateRecrutement(employee.getDateRecrutement());
        temp.setSexeEmp(employee.getSexeEmp());
        return employeRepository.save(temp);
    }

    @Override
    public String deleteEmployee(int id) {
        try {
            employeRepository.deleteById(id);
            return "l'employé est supprimé avec succès !!";
        } catch (EmptyResultDataAccessException e) {
            return "l'identifiant que vous avez saisi n'éxiste pas !!!";
        }

    }

    @Override
    public List<DemandeConge> getConges(int id) {

        Employe employe = getEmployee(id);
//        return employe.getDemandeCongeList();
        return null;
    }

    @Override
    public List<DemandePiece> getPieces(int id) {

        Employe employe = getEmployee(id);
//        return employe.getDemandePieceList();
        return null;
    }

    @Override
    public List<DemandeConge> getAllConges() {
        return demandeCongeRepository.findAll();
    }

    @Override
    public List<DemandePiece> getAllPieces() {
        return demandePieceRepository.findAll();
    }
}
