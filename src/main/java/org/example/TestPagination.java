package org.example;

import org.example.entities.Produit;
import org.example.services.ProduitService;

import java.util.List;

public class TestPagination {
    public static void main(String[] args) {
        ProduitService ps = new ProduitService();

        int page = 2;
        int size = 5;

        List<Produit> liste = ps.findPaginated(page, size);
        for (Produit p : liste) {
            System.out.println(p.getId() + " - " + p.getNom());
        }

        long total = ps.countAll();
        long totalPages = (total + size - 1) / size;

        System.out.println("Total produits = " + total);
        System.out.println("Nombre de pages = " + totalPages);

    }
}
