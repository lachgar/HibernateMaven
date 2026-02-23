/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

/**
 *
 * @author X1 YOGA
 */
@Entity
public class Employe extends User{

    private String matricule;
    
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Service> services;

    public Employe() {
    }

    public Employe(String matricule, String email, String password) {
        super(email, password);
        this.matricule = matricule;
    }

    
    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
    
    
}
