/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author X1 YOGA
 */
@Entity
public class LigneCommandeProduit {
    @EmbeddedId
    private CommandeProduitPK pK;
    private int quantite;
    private double prixVente;
    
    @ManyToOne 
    @JoinColumn(name = "produit", referencedColumnName = "id", insertable = false, updatable = false)
    private Produit produit;
    @ManyToOne
    @JoinColumn(name = "commande", referencedColumnName = "id", insertable = false, updatable = false)
    private Commande commande;

    public LigneCommandeProduit() {
    }

    public LigneCommandeProduit(int quantite, double prixVente, Produit produit, Commande commande) {
        this.quantite = quantite;
        this.prixVente = prixVente;
        this.produit = produit;
        this.commande = commande;
        pK = new CommandeProduitPK(commande.getId(), produit.getId());
    }

    public CommandeProduitPK getpK() {
        return pK;
    }

    public void setpK(CommandeProduitPK pK) {
        this.pK = pK;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(double prixVente) {
        this.prixVente = prixVente;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
    
    
}
