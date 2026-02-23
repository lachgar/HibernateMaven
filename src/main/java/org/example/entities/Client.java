/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.entities;

import javax.persistence.Entity;

/**
 *
 * @author X1 YOGA
 */
@Entity
public class Client extends User{
    private String nom;
    private String prenom;

    public Client() {
    }

    public Client(String nom, String prenom, String email, String password) {
        super(email, password);
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    
}
