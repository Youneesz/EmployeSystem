package com.sfeproject.employesystem.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "employe")
public class Employe extends Personne implements Serializable {

    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "employeConges")
    @JsonManagedReference(value = "employeconge")
    private Set<DemandeConge> demandes_conges;

    @OneToMany(mappedBy = "employe")
    @JsonManagedReference(value = "employePieces")
    private List<DemandePiece> demandes_pieces;

    @OneToMany(mappedBy = "employeTaches")
    //@JsonManagedReference(value = "employeTaches")
    private List<Realiser> taches_affectees;

    public Employe() {
        super();
    }

    public Set<DemandeConge> getDemandes_conges() {
        return demandes_conges;
    }

    public void setDemandes_conges(Set<DemandeConge> demandes_conges) {
        this.demandes_conges = demandes_conges;
    }

    public List<DemandePiece> getDemandes_pieces() {
        return demandes_pieces;
    }

    public void setDemandes_pieces(List<DemandePiece> demandes_pieces) {
        this.demandes_pieces = demandes_pieces;
    }

    public List<Realiser> getTaches_affectees() {
        return taches_affectees;
    }

    public void setTaches_affectees(List<Realiser> taches_affectees) {
        this.taches_affectees = taches_affectees;
    }
}
