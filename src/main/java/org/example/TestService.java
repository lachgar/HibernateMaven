package org.example;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.example.entities.Employe;
import org.example.entities.Service;
import org.example.services.EmployeService;
import org.example.services.ServiceService;

/**
 *
 * @author X1 YOGA
 */
public class TestService {
    
    public static void main(String[] args) {
        ServiceService ss = new ServiceService();
        EmployeService es = new EmployeService();
        
        ss.create(new Service("Info"));
        ss.create(new Service("Fin"));
        
        Employe e = es.findById(1);
        e.getServices().add(ss.findById(1));
        e.getServices().add(ss.findById(2));
        es.update(e);
        
        
        
    }
    
}
