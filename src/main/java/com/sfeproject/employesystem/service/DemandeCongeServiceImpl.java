package com.sfeproject.employesystem.service;

import com.sfeproject.employesystem.model.Conge;
import com.sfeproject.employesystem.model.DemandeConge;

import com.sfeproject.employesystem.model.Employe;
import com.sfeproject.employesystem.repository.CongeRepository;
import com.sfeproject.employesystem.repository.DemandeCongeRepository;
import com.sfeproject.employesystem.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandeCongeServiceImpl implements DemandeCongeService{

    @Autowired
    private DemandeCongeRepository demandeCongeRepository;

    @Autowired
    private CongeRepository congeRepository;

    @Autowired
    private EmployeRepository employeRepository;

    @Override
    public DemandeConge getDemangeConge(int id) {
        return demandeCongeRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<DemandeConge> getDemandesConge() {
        return demandeCongeRepository.findAll();
    }

    @Override
    public DemandeConge addDemandeConge(DemandeConge demandeConge, int id_emp, int id_conge) {
        for (DemandeConge d: demandeCongeRepository.findAll()) {
            if(d.equals(demandeConge))
                return null;
        }
        Conge conge = congeRepository.findById(id_conge).orElseThrow(RuntimeException::new);
        Employe emp = employeRepository.findById(id_emp).orElseThrow(RuntimeException::new);
        demandeConge.setConge(conge);
        demandeConge.setEmp(emp);
        return demandeCongeRepository.save(demandeConge);
    }

    @Override
    public DemandeConge updateDemandeConge(int id, DemandeConge demandeConge) {
        for (DemandeConge d: demandeCongeRepository.findAll()) {
            if(d.equals(demandeConge))
                return null;
        }
        DemandeConge temp = demandeCongeRepository.findById(id).orElseThrow(RuntimeException::new);
        temp.setDateEtat(demandeConge.getDateEtat());
        temp.setConge(demandeConge.getConge());
        temp.setDateDebut(demandeConge.getDateDebut());
        temp.setmotif(demandeConge.getmotif());
        temp.setEtat(demandeConge.getEtat());
        return temp;
    }

    @Override
    public String deleteDemangeConge(int id) {
      try{
          demandeCongeRepository.deleteById(id);
          return "demande supprimée avec succès !!";
      }catch(EmptyResultDataAccessException e){
          return "cet identifiant n'existe pas" ;
      }
    }
}
