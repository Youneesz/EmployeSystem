package com.sfeproject.employesystem.model;

import java.util.Date;

public class ChefService extends Person{

    public ChefService(int SOM, int id, char sexe, String nom, String prenom, String telephone, String lieuEmp, String lieuHabit, String password, Date dateRec, String cadre) {
        super(SOM, id, sexe, nom, prenom, telephone, lieuEmp, lieuHabit, password, dateRec, cadre);
    }
}
