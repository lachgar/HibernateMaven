package org.example.services;


import org.example.entities.Employe;
import org.example.services.AbstractFacade;

/**
 *
 * @author X1 YOGA
 */
public class EmployeService extends AbstractFacade<Employe> {

    public EmployeService() {
        super(Employe.class);
    }

    // Ajouter ici les méthodes spécifiques à Employe si nécessaire
}