package com.sfeproject.employesystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "realiser")

public class Realiser implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "NUM_AFFECTATION")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numAffectation;

    @ManyToOne
    @JoinColumn(name = "CODE_EMP")
    @JsonBackReference(value = "employeTaches")
    private Employe employe;

    @ManyToOne
    @JoinColumn(name = "CODE_TACHE")
    private Tache tache;

    @ManyToOne
    @JoinColumn(name = "CODE_BUREAU")
    private Bureau bureau;

    @Column(name = "DATE_AFFECTATION")
    private Date dateAffectation;

    public Realiser() {
    }

    @JsonIgnore
    public Employe getEmployee() {
        return employe;
    }

    public void setEmployee(Employe employee) {
        this.employe = employee;
    }

    @JsonIgnore
    public Tache getTache() {
        return tache;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }

    @JsonIgnore
    public Bureau getBureau() {
        return bureau;
    }

    public void setBureau(Bureau bureau) {
        this.bureau = bureau;
    }

    public Integer getNumAffectation() {
        return numAffectation;
    }

    public void setNumAffectation(Integer numAffectation) {
        this.numAffectation = numAffectation;
    }

    public Date getDateAffectation() {
        return dateAffectation;
    }

    public void setDateAffectation(Date dateAffectation) {
        this.dateAffectation = dateAffectation;
    }
}
