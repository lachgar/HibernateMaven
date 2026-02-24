/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.entities;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author X1 YOGA
 */

@Entity
@NamedQueries({
        @NamedQuery(name = "findByCategory", query = "from Produit where categorie =:categorie"),
        @NamedQuery(name = "findBetweenDates", query = "from Produit where dateAchat between :d1 and :d2")
})

@NamedNativeQuery(name = "findByPrix", query = "select * from Produit where prix > :prix", resultClass =  Produit.class)

public class Produit {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateAchat;
    private double prix;
    @ManyToOne
    private Categorie categorie;

    public Produit() {
    }

    public Produit(String nom, Date dateAchat, double prix, Categorie categorie) {
        this.nom = nom;
        this.dateAchat = dateAchat;
        this.prix = prix;
        this.categorie = categorie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
    
    
    
}
