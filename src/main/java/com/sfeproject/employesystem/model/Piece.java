package com.sfeproject.employesystem.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "piece")
public class Piece implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODE_PIECE", nullable = false)
    private Integer codePiece;

    @OneToMany(mappedBy = "piece")
    @JsonManagedReference(value = "demandePieces")
    private Set<DemandePiece> demandePieces;

    @Column(name = "INTITULE_PIECE")
    private String intitulePiece;

    @Column(name = "DESCRIPTION_PIECE")
    private String descriptionPiece;

    public Piece(Integer codePiece, String intitulePiece, String descriptionPiece) {
        this.codePiece = codePiece;
        this.intitulePiece = intitulePiece;
        this.descriptionPiece = descriptionPiece;
    }

    public Piece() {}

    public Integer getCodePiece() {
        return codePiece;
    }

    public void setCodePiece(Integer codePiece) {
        this.codePiece = codePiece;
    }

    public String getIntitulePiece() {
        return intitulePiece;
    }

    public void setIntitulePiece(String intitulePiece) {
        this.intitulePiece = intitulePiece;
    }

    public String getDescriptionPiece() {
        return descriptionPiece;
    }

    public void setDescriptionPiece(String descriptionPiece) {
        this.descriptionPiece = descriptionPiece;
    }


}
