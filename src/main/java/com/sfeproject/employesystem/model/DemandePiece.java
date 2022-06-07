package com.sfeproject.employesystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "demande_piece")
public class DemandePiece implements Serializable{


    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "NUM_DEMANDEPIECE", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numDemande;

    @ManyToOne
    @JoinColumn(name = "CODE_EMP")
    @JsonBackReference(value = "employePieces")
    private Employe employe;

    @JsonBackReference(value = "demandePieces")
    @ManyToOne
    @JoinColumn(name = "CODE_PIECE")
    private Piece piece;

    @Column(name = "DATE_DEMANDE")
    private Date dateDemande;

    @Column(name = "DATE_ETAT")
    private Date dateEtat;

    @Column(name = "etat")
    private String etat;

    @Column(name = "MOTIF_REFUS")
    private String motifRefus;

    public DemandePiece() {}

    public Integer getNumDemande() {
        return numDemande;
    }

    public void setNumDemande(Integer numDemande) {
        this.numDemande = numDemande;
    }

    @JsonIgnore
    public Employe getEmployee() {
        return employe;
    }

    public void setEmployee(Employe employee) {
        this.employe = employee;
    }

    @JsonIgnore
    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
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

    public String getMotifRefus() {
        return motifRefus;
    }

    public void setMotifRefus(String motifRefus) {
        this.motifRefus = motifRefus;
    }
}
