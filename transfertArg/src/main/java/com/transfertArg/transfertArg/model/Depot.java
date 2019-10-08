package com.transfertArg.transfertArg.model;
import javax.persistence.*;
import org.hibernate.annotations.NaturalId;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import java.util.*;
@Entity
@Table(name = "depot")
public class Depot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "date_depot")
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date dateDepot;
    @Column(name = "montant_depot")
    private int montantDepot;

    @JoinColumn(name="user_id",referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User user;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Date getDateDepot() {
        return dateDepot;
    }

    public void setDateDepot(Date dateDepot) {
        this.dateDepot = dateDepot;
    }

    public int getMontantDepot() {
        return montantDepot;
    }

    public void setMontantDepot(int montantDepot) {
        this.montantDepot = montantDepot;
    }

}
