package com.sfeproject.employesystem.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "actualite")
public class Actualite implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODE_ACTUALITE", nullable = false)
    private Integer codeActualite;

    @Column(name = "DATE_ACTUALITE")
    private LocalDateTime dateActualite;

    @Column(name = "DESC_ACTUALITE")
    private String descActualite;

    @Column(name = "intit_actualite")
    private String intitActualite;

    @Column(name = "categorie")
    private String categorie;

    @JsonManagedReference
    @OneToMany(mappedBy = "actualite")
    private List<PieceJointe> pieceJointes;

    public Actualite() {}

    public Actualite(String intitActualite, String descActualite) {
        this.dateActualite = LocalDateTime.now();
        this.intitActualite = intitActualite;
        this.descActualite = descActualite;
    }

    public List<PieceJointe> getPieceJointes() {
        return pieceJointes;
    }

    public void addPieceJointe(PieceJointe pieceJointe)
    {
        getPieceJointes().add(pieceJointe);
    }


    public String getIntitActualite() {
        return intitActualite;
    }

    public void setIntitActualite(String intitActualite) {
        this.intitActualite = intitActualite;
    }

    public Integer getCodeActualite() {
        return codeActualite;
    }

    public void setCodeActualite(Integer codeActualite) {
        this.codeActualite = codeActualite;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public LocalDateTime getDateActualite() {
        return dateActualite;
    }

    public void setDateActualite(LocalDateTime dateActualite) {
        this.dateActualite = dateActualite;
    }

    public String getDescActualite() {
        return descActualite;
    }

    public void setDescActualite(String descActualite) {
        this.descActualite = descActualite;
    }

    @Override
    public String toString() {
        return "Actualite{" +
                "codeActualite=" + codeActualite +
                ", categorie=" + categorie +
                ", dateActualite=" + dateActualite +
                ", descActualite='" + descActualite + '\'' +
                ", intitActualite='" + intitActualite + '\'' +
                '}';
    }
}
