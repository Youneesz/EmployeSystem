package com.sfeproject.employesystem.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
@Entity
@Table(name = "demande_piece")
@IdClass(DemandePieceId.class)
public class DemandePiece implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "NUM_DEMANDE", nullable = false)
    private Integer numDemande;

    @Id
    @Column(name = "CODE_EMP", nullable = false)
    private Integer codeEmp;

    @Id
    @Column(name = "CODE_PIECE", nullable = false)
    private Integer codePiece;

    @Column(name = "DATE_DEMANDE")
    private Date dateDemande;

    @Column(name = "DATE_ETAT")
    private Date dateEtat;

    @Column(name = "ETAT_DEMANDE")
    private String etatDemande;

    @Column(name = "MOTIF_REFUS")
    private String motifRefus;

}
