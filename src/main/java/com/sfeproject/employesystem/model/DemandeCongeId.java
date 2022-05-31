package com.sfeproject.employesystem.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DemandeCongeId implements Serializable {

    /*@Column(name = "NUM_DEMANDECONGE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numDemande;
    @Column(name = "CODE_CONGE")
    private Integer codeConge;
    @Column(name = "CODE_EMP")
    private Integer codeEmp;

    public DemandeCongeId(){}

    public DemandeCongeId(Integer numDemande, Integer codeConge, Integer codeEmp) {
        this.numDemande = numDemande;
        this.codeConge = codeConge;
        this.codeEmp = codeEmp;
    }

    public Integer getNumDemande() {
        return numDemande;
    }

    public void setNumDemande(Integer numDemande) {
        this.numDemande = numDemande;
    }

    public Integer getCodeConge() {
        return codeConge;
    }

    public void setCodeConge(Integer codeConge) {
        this.codeConge = codeConge;
    }

    public Integer getCodeEmp() {
        return codeEmp;
    }

    public void setCodeEmp(Integer codeEmp) {
        this.codeEmp = codeEmp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DemandeCongeId that = (DemandeCongeId) o;
        return Objects.equals(numDemande, that.numDemande) && Objects.equals(codeConge, that.codeConge) && Objects.equals(codeEmp, that.codeEmp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numDemande, codeConge, codeEmp);
    }*/
}
