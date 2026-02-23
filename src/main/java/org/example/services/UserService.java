package org.example.services;

import org.example.entities.User;

/**
 *
 * @author X1 YOGA
 */
public class UserService extends AbstractFacade<User> {

    public UserService() {
        super(User.class);
    }

    // Ajouter ici les méthodes spécifiques à User si nécessaire
}