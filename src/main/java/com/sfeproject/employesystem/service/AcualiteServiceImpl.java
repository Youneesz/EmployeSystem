package com.sfeproject.employesystem.service;

import com.sfeproject.employesystem.model.Actualite;
import com.sfeproject.employesystem.repository.ActualiteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AcualiteServiceImpl implements ActualiteService {

    @Autowired
    private ActualiteRepository actualiteRepository;

    @Override
    public Actualite getActualite(int idActualite) {
        return actualiteRepository.findById(idActualite).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Actualite> getActualites() {
        return actualiteRepository.findAll();
    }

    @Override
    public Actualite saveActualite(Actualite actualite) {
        for (Actualite a : actualiteRepository.findAll()) {
            if(a.getIntitActualite().equals(actualite.getIntitActualite())
                    && a.getDescActualite().equals(actualite.getDescActualite())){
                return null;
            }
        }
        actualite.setDateActualite(LocalDateTime.now());
        return actualiteRepository.save(actualite);
    }

    @Override
    public Actualite updateActualite(int id, Actualite actualite) {
        for (Actualite a : actualiteRepository.findAll()) {
            if(a.getIntitActualite().equals(actualite.getIntitActualite())
                    && a.getDescActualite().equals(actualite.getDescActualite())){
                return null;
            }
        }
        Actualite temp = getActualite(id);
        temp.setDateActualite(LocalDateTime.now());
        temp.setDescActualite(actualite.getDescActualite());
        temp.setIntitActualite(actualite.getIntitActualite());
        temp.setCategorie(actualite.getCategorie());
        actualiteRepository.save(temp);
        return temp;
    }

    @Override
    public String deleteActualite(int idActualite) {
        try{
            actualiteRepository.deleteById(idActualite);
            return "Actualite supprimée avec succes !!";
        }catch(EmptyResultDataAccessException e){
            return "Cet identifiant n'existe pas !!";
        }
    }
}
