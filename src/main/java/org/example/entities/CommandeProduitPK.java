/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.entities;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author X1 YOGA
 */
@Embeddable
public class CommandeProduitPK implements Serializable{
    private int commande;
    private int produit;

    public CommandeProduitPK() {
    }

    public CommandeProduitPK(int commande, int produit) {
        this.commande = commande;
        this.produit = produit;
    }

    public int getCommande() {
        return commande;
    }

    public void setCommande(int commande) {
        this.commande = commande;
    }

    public int getProduit() {
        return produit;
    }

    public void setProduit(int produit) {
        this.produit = produit;
    }
    
    
}
