package com.sfeproject.employesystem.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "bureau")
public class Bureau implements Serializable {



    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODE_BUREAU", nullable = false)
    private Integer codeBureau;

    @Column(name = "INTITULE_BUREAU")
    private String intituleBureau;

    @Column(name = "DESCRIPTION_BUREAU")
    private String descriptionBureau;

    @OneToMany(mappedBy = "bureau", cascade = CascadeType.ALL)
    private List<Realiser> realiser;

    public Bureau(Integer codeBureau, String intituleBureau, String descriptionBureau) {
        this.codeBureau = codeBureau;
        this.intituleBureau = intituleBureau;
        this.descriptionBureau = descriptionBureau;
    }

    public Bureau() {}

    public Integer getCodeBureau() {
        return codeBureau;
    }

    public void setCodeBureau(Integer codeBureau) {
        this.codeBureau = codeBureau;
    }

    public String getIntituleBureau() {
        return intituleBureau;
    }

    public void setIntituleBureau(String intituleBureau) {
        this.intituleBureau = intituleBureau;
    }

    public String getDescriptionBureau() {
        return descriptionBureau;
    }

    public void setDescriptionBureau(String descriptionBureau) {
        this.descriptionBureau = descriptionBureau;
    }
}
