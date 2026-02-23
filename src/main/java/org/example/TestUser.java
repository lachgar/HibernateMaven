package org.example;

import org.example.entities.Client;
import org.example.entities.Employe;
import org.example.entities.User;
import org.example.services.ClientService;
import org.example.services.EmployeService;
import org.example.services.UserService;

/**
 *
 * @author X1 YOGA
 */
public class TestUser {
    public static void main(String[] args) {
        EmployeService es = new EmployeService();
        ClientService cs = new ClientService();
        UserService us = new UserService();
        
        es.create(new Employe("123332", "email@com.cc", "1111"));
        cs.create(new Client("Rami", "Amine", "rami@gmail.com", "qwerty"));
           
        for(User u : us.findAll())
            System.out.println(u.getClass().getSimpleName());
    }
}
