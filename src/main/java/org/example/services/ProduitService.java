package org.example.services;


import java.util.List;
import java.util.ArrayList;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.example.entities.Categorie;
import org.example.entities.Produit;
import org.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author X1 YOGA
 */
public class ProduitService extends AbstractFacade<Produit> {

    public ProduitService() {
        super(Produit.class);
    }

    public List<Produit> findByCategorie(Categorie categorie) {
        Session session = null;
        Transaction tx = null;
        List<Produit> produits = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            produits = session.getNamedQuery("findByCategory")
                    .setParameter("categorie", categorie)
                    .list();

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return produits;
    }

    public List<Produit> findByCriteria(Categorie categorie, Double prixMin, Double prixMax) {
        Session session = null;
        Transaction tx = null;
        List<Produit> produits = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Produit> cq = cb.createQuery(Produit.class);
            Root<Produit> root = cq.from(Produit.class);

            List<Predicate> predicates = new ArrayList<>();

            if (categorie != null) {
                predicates.add(cb.equal(root.get("categorie"), categorie));
            }

            if (prixMin != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("prix"), prixMin));
            }

            if (prixMax != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("prix"), prixMax));
            }

            cq.select(root).where(predicates.toArray(new Predicate[0]));

            produits = session.createQuery(cq).getResultList();

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return produits;
    }
}
