package org.example;

import org.example.entities.Produit;
import org.example.services.CategorieService;
import org.example.services.ProduitService;

import java.util.Date;

/**
 *
 * @author X1 YOGA
 */
public class TestProduit {
    
    public static void main(String[] args) {
        ProduitService ps = new ProduitService();
        CategorieService cs = new CategorieService();
        
        ps.create(new Produit("Lenovo", new Date(), 10000, cs.findById(2)));
        
        
        //for(Produit p : cs.findById(2).getProduits())
          //  System.out.println(p.getNom());
        
        
        for(Produit p : ps.findByCategorie(cs.findById(2)))
            System.out.println(p.getNom());

        for(Produit p: ps.findBetweenDates(new Date("2020/01/01"),new Date("2025/01/01")))
            System.out.println(p.getNom()+" : "+p.getDateAchat()+" ");

        for (Produit p : ps.findByPrix(9000))
            System.out.println(p.getNom()+" : "+p.getPrix()+" ");
    }

    
}
