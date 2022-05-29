package com.sfeproject.employesystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "conge")
public class Conge implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODE_CONGE", nullable = false)
    private Integer codeConge;

    @Column(name = "INTITULE_CONGE")
    private String intituleConge;

    @Column(name = "DESCRIPTION_CONGE")
    private String descriptionConge;

    @OneToMany(mappedBy = "conge")
    @JsonManagedReference(value = "congeemploye")
    private Set<DemandeConge> demandeConges;

    public Integer getCodeConge() {
        return codeConge;
    }

    public void setCodeConge(Integer codeConge) {
        this.codeConge = codeConge;
    }

    public String getIntituleConge() {
        return intituleConge;
    }

    public void setIntituleConge(String intituleConge) {
        this.intituleConge = intituleConge;
    }

    public String getDescriptionConge() {
        return descriptionConge;
    }

    public void setDescriptionConge(String descriptionConge) {
        this.descriptionConge = descriptionConge;
    }

    public Set<DemandeConge> getDemandeConges() {
        return demandeConges;
    }

    public void setDemandeConges(Set<DemandeConge> demandeConges) {
        this.demandeConges = demandeConges;
    }
}
