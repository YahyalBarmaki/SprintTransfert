package com.transfertArg.transfertArg.model;
import javax.persistence.*;
import org.hibernate.annotations.NaturalId;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@Entity
@Table(name = "retrait")
public class Retrait {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String adresse;
    private String cni;
    private String tel;
    private String type_de_piecce;

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @JoinColumn(name = "transaction_id",referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Transaction transaction;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCni() {
        return cni;
    }

    public void setCni(String cni) {
        this.cni = cni;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getType_de_piecce() {
        return type_de_piecce;
    }

    public void setType_de_piecce(String type_de_piecce) {
        this.type_de_piecce = type_de_piecce;
    }

    public Date getDate_retrait() {
        return date_retrait;
    }

    public void setDate_retrait(Date date_retrait) {
        this.date_retrait = date_retrait;
    }

    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date date_retrait;
}
