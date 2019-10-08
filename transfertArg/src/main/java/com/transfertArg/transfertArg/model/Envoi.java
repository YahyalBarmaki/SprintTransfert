package com.transfertArg.transfertArg.model;
import javax.persistence.*;
import org.hibernate.annotations.NaturalId;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "envoi")
public class Envoi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int code;
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    @Column(name="date_envoie")
    private Date dateEnvoie;
    private String nom;
    private String tel;

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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getDateEnvoie() {
        return dateEnvoie;
    }

    public void setDateEnvoie(Date dateEnvoie) {
        this.dateEnvoie = dateEnvoie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCni() {
        return cni;
    }

    public void setCni(String cni) {
        this.cni = cni;
    }

    public String getTypeDePiece() {
        return typeDePiece;
    }

    public void setTypeDePiece(String typeDePiece) {
        this.typeDePiece = typeDePiece;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    private String cni;
    @Column(name = "type_de_piece")
    private String typeDePiece;
    private String adresse;
}
