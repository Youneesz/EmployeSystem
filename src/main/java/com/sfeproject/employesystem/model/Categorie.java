package com.sfeproject.employesystem.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "categorie")
public class Categorie implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODE_CAT", nullable = false)
    private Integer codeCat;

    @Column(name = "INTITULE_CAT", nullable = false)
    private String intituleCat;

    public Categorie() {}

    public Categorie(Integer codeCat, String intituleCat) {
        this.codeCat = codeCat;
        this.intituleCat = intituleCat;
    }

    public Integer getCodeCat() {
        return codeCat;
    }

    public void setCodeCat(Integer codeCat) {
        this.codeCat = codeCat;
    }

    public String getIntituleCat() {
        return intituleCat;
    }

    public void setIntituleCat(String intituleCat) {
        this.intituleCat = intituleCat;
    }
}
