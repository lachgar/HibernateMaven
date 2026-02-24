package org.example;

import org.example.entities.LigneCommandeProduit;
import org.example.services.CommandeService;
import org.example.services.LigneCommandeProduitService;
import org.example.services.ProduitService;

/**
 *
 * @author X1 YOGA
 */
public class TestCommande {
    
    public static void main(String[] args) {
        CommandeService cs = new CommandeService();
        LigneCommandeProduitService lcps = new LigneCommandeProduitService();
        ProduitService ps = new ProduitService();
        
        //cs.create(new Commande(new Date()));
        
        lcps.create(new LigneCommandeProduit(2, 400, ps.findById(1), cs.findById(1)));
        
    }
    
}
