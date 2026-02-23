package org.example;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.example.entities.Categorie;
import org.example.services.CategorieService;

/**
 *
 * @author X1 YOGA
 */
public class Test {
    public static void main(String[] args) {
        CategorieService cs = new CategorieService();
        cs.create(new Categorie("PC"));
        cs.create(new Categorie("Phone"));
        
        //cs.delete(cs.findById(1));
        
        System.out.println(cs.findAll());
    }
}
