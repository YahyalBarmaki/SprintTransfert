package com.transfertArg.transfertArg.model;
import javax.persistence.*;
import org.hibernate.annotations.NaturalId;
import java.util.*;

@Entity
@Table(name = "partenaire")
public class Partenaire{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

    public String getNom_entreprise() {
        return nom_entreprise;
    }

    public void setNom_entreprise(String nom_entreprise) {
        this.nom_entreprise = nom_entreprise;
    }

    @Column(name = "nom_entreprise" ,length = 255,nullable = false)
   private String nom_entreprise;

    public String getNinea() {
        return ninea;
    }

    public void setNinea(String ninea) {
        this.ninea = ninea;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Column(name = "ninea", length = 255, nullable = false)
    private String ninea;
    @Column(name = "tel", length = 50, nullable = false)
    private String tel;

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Column(name = "adresse", length = 50, nullable = false)
    private String adresse;

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy ="partenaire")
    private List<Compte> comptes;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "partenaire")
    private List<User> users;


    public String getEmailP() {
        return emailP;
    }

    public void setEmailP(String emailP) {
        this.emailP = emailP;
    }

    @Column(name = "emailP",length = 255,nullable = false)
    private String emailP;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
