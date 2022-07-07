package com.sfeproject.employesystem.service;

import com.sfeproject.employesystem.model.Realiser;
import com.sfeproject.employesystem.model.Tache;

import java.util.List;

public interface RealiserService {
    public Realiser getAffectation(int idAffectation);
    public List<Realiser> getAllAffectations();
    public Realiser addAffectation(Realiser affectation, int id_emp, int id_bureau, int id_tache);
    public Realiser updateAffectation(int id, Realiser affectation);
    public String deleteAffectation(int idAffectation);

}
