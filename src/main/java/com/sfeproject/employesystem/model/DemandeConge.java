package com.sfeproject.employesystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "demande_conge")
public class DemandeConge implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "NUM_DEMANDE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numDemande;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CODE_CONGE")
    @JsonBackReference(value = "congeemploye")
    private Conge conge;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CODE_EMP")
    @JsonBackReference(value = "employeconge")
    private Employe employeConges;

    @Column(name = "DATE_DEMANDE")
    private Date dateDemande;

    @Column(name = "EXERCICE")
    private Integer exercice;

    @Column(name = "DATE_DEBUT")
    private Date dateDebut;

    @Column(name = "DATE_FIN")
    private Date dateFin;

    @Column(name = "DATE_ETAT")
    private Date dateEtat;

    @Column(name = "ETAT")
    private String etat;

    @Column(name = "MOTIF")
    private String motif;

    public DemandeConge() {
    }

    public Integer getNumDemande() {
        return numDemande;
    }

    public void setNumDemande(Integer numDemande) {
        this.numDemande = numDemande;
    }

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }

    public Integer getExercice() {
        return exercice;
    }

    public void setExercice(Integer exercice) {
        this.exercice = exercice;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Date getDateEtat() {
        return dateEtat;
    }

    public void setDateEtat(Date dateEtat) {
        this.dateEtat = dateEtat;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    @JsonIgnore
    public Conge getConge() {
        return this.conge;
    }

    public void setConge(Conge conge) {
        this.conge = conge;
    }

    @JsonIgnore
    public Employe getEmp() {
        return employeConges;
    }

    public void setEmp(Employe employee) {
        this.employeConges = employee;
    }
}
