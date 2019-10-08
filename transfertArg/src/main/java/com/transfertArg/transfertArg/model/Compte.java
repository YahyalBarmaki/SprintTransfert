package com.transfertArg.transfertArg.model;
import javax.persistence.*;
import org.hibernate.annotations.NaturalId;
import java.util.*;
@Entity
@Table(name = "compte")
public class Compte {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public String getNum_compte() {
        return num_compte;
    }

    public void setNum_compte(String num_compte) {
        this.num_compte = num_compte;
    }

    @Column(name = "num_compte",length = 255)
    private String num_compte;
    private int solde;

    public Partenaire getPartenaire() {
        return partenaire;
    }

    public void setPartenaire(Partenaire partenaire) {
        this.partenaire = partenaire;
    }

    @JoinColumn(name = "partenaire_id",referencedColumnName ="id")
    @ManyToOne(optional = false)
    private Partenaire partenaire;
}
