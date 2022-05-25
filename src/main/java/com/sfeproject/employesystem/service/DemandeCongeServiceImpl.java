package com.sfeproject.employesystem.service;

import com.sfeproject.employesystem.model.DemandeConge;

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
    public DemandeConge addDemandeConge(DemandeConge demandeConge) {
        for (DemandeConge d: demandeCongeRepository.findAll()) {
            if(d.equals(demandeConge))
                return null;
        }
        demandeConge.setConge(congeRepository.findById(demandeConge.getConge().getCodeConge()).orElseThrow(RuntimeException::new));
        demandeConge.setEmp(employeRepository.findById(demandeConge.getEmp().getCodeEmp()).orElseThrow(RuntimeException::new));
        demandeConge.setEtat("nouveau");
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
