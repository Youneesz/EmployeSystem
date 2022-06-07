package com.sfeproject.employesystem.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "pieces_archive")
public class PiecesArchive implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "NUM_DEMANDEPIECE")
    private Integer numDemande;

    @Column(name = "CODE_EMP")
    private Integer employe;

    @Column(name = "CODE_PIECE")
    private Integer piece;

    @Column(name = "DATE_DEMANDE")
    private Date dateDemande;

    @Column(name = "DATE_ETAT")
    private Date dateEtat;

    @Column(name = "ETAT_DEMANDE")
    private String etat;

    @Column(name = "MOTIF_REFUS")
    private String motifRefus;

    public Integer getNumDemande() {
        return numDemande;
    }

    public void setNumDemande(Integer numDemande) {
        this.numDemande = numDemande;
    }

    public Integer getEmploye() {
        return employe;
    }

    public void setEmploye(Integer employe) {
        this.employe = employe;
    }

    public Integer getPiece() {
        return piece;
    }

    public void setPiece(Integer piece) {
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
