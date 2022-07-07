package com.sfeproject.employesystem.service;

import com.sfeproject.employesystem.model.Realiser;
import com.sfeproject.employesystem.repository.BureauRepository;
import com.sfeproject.employesystem.repository.EmployeRepository;
import com.sfeproject.employesystem.repository.RealiserRepository;
import com.sfeproject.employesystem.repository.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealiserServiceImpl implements RealiserService{

    @Autowired
    private RealiserRepository realiserRepository;

    @Autowired
    private BureauRepository bureauRepository;

    @Autowired
    private EmployeRepository employeRepository;

    @Autowired
    private TacheRepository tacheRepository;

    @Override
    public Realiser getAffectation(int idAffectation) {
        return realiserRepository.findById(idAffectation).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Realiser> getAllAffectations() {
        return realiserRepository.findAll();
    }

    @Override
    public Realiser addAffectation(Realiser affectation, int id_emp, int id_bureau, int id_tache) {
        for (Realiser a: realiserRepository.findAll()) {
            if (affectation.equals(a))
                return null;
        }
        affectation.setBureau(bureauRepository.findById(id_bureau).orElseThrow(RuntimeException::new));
        affectation.setTache(tacheRepository.findById(id_tache).orElseThrow(RuntimeException::new));
        affectation.setEmployee(employeRepository.findById(id_emp).orElseThrow(RuntimeException::new));
        return realiserRepository.save(affectation);
    }

    @Override
    public Realiser updateAffectation(int id, Realiser affectation) {
        for (Realiser a: realiserRepository.findAll()) {
            if (affectation.equals(a))
                return null;
        }
        Realiser temp = realiserRepository.findById(id).orElseThrow(RuntimeException::new);
        System.out.println(temp.toString());
        temp.setDateAffectation(affectation.getDateAffectation());
        return realiserRepository.save(temp);
    }

    @Override
    public String deleteAffectation(int idAffectation) {

        try{
            realiserRepository.deleteById(idAffectation);
            return "Aff ectation supprimée avec succès !!";
        }catch(EmptyResultDataAccessException e){
            return "Cet identifiant n'existe pas !!";
        }

    }
}
