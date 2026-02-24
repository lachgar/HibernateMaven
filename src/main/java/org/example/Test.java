package org.example;

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
