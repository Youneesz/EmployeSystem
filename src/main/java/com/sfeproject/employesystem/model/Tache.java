package com.sfeproject.employesystem.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "tache")
public class Tache implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODE_TACHE", nullable = false)
    private Integer codeTache;

    @Column(name = "INTITULE_TACHE")
    private String intituleTache;

    @Column(name = "DESCRIPTION_TACHE")
    private String descriptionTache;


    public Tache( String intituleTache, String descriptionTache) {
        this.intituleTache = intituleTache;
        this.descriptionTache = descriptionTache;
    }

    public Tache() {}

    public Integer getCodeTache() {
        return codeTache;
    }

    public void setCodeTache(Integer codeTache) {
        this.codeTache = codeTache;
    }

    public String getIntituleTache() {
        return intituleTache;
    }

    public void setIntituleTache(String intituleTache) {
        this.intituleTache = intituleTache;
    }

    public String getDescriptionTache() {
        return descriptionTache;
    }

    public void setDescriptionTache(String descriptionTache) {
        this.descriptionTache = descriptionTache;
    }
}
