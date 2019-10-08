package com.transfertArg.transfertArg.model;
import javax.persistence.*;
import org.hibernate.annotations.NaturalId;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import java.util.*;
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date dateTransaction;
    @Column(name = "montant_transaction")
    private int montantTransaction;

    public List<Retrait> getRetraits() {
        return retraits;
    }

    public void setRetraits(List<Retrait> retraits) {
        this.retraits = retraits;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy ="transaction")
    private List<Retrait> retraits;
    @OneToMany(cascade = CascadeType.ALL,mappedBy ="transaction")
    private List<Envoi> envois;

    public List<Envoi> getEnvois() {
        return envois;
    }

    public void setEnvois(List<Envoi> envois) {
        this.envois = envois;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(Date dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public int getMontantTransaction() {
        return montantTransaction;
    }

    public void setMontantTransaction(int montantTransaction) {
        this.montantTransaction = montantTransaction;
    }
}
