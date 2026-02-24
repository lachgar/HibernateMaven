package org.example.services;


import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.example.entities.Categorie;
import org.example.entities.Produit;
import org.example.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

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

    public List<Produit> findBetweenDates(Date d1, Date d2) {
        Session session = null;
        Transaction tx = null;
        List<Produit> produits = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            produits = session.getNamedQuery("findBetweenDates")
                    .setParameter("d1", d1)
                    .setParameter("d2", d2)
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


    public List<Produit> findByPrix(double prix) {
        Session session = null;
        Transaction tx = null;
        List<Produit> produits = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            produits = session.getNamedQuery("findByPrix")
                    .setParameter("prix", prix)
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

    //Pagination simple (tous les produits)
    public List<Produit> findPaginated(int page, int size) {
        Session session = null;
        Transaction tx = null;
        List<Produit> produits = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            // sécuriser les valeurs
            if (page < 1) page = 1;
            if (size < 1) size = 10;

            int firstResult = (page - 1) * size;

            Criteria criteria = session.createCriteria(Produit.class);
            criteria.addOrder(Order.asc("id")); // ou "nom"
            criteria.setFirstResult(firstResult); // offset
            criteria.setMaxResults(size);         // limit

            produits = criteria.list();

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }

        return produits;
    }

    //Compter le nombre total de produits (utile pour le nombre de pages)
    public long countAll() {
        Session session = null;
        Transaction tx = null;
        long total = 0;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            Criteria criteria = session.createCriteria(Produit.class);
            criteria.setProjection(Projections.rowCount());

            Object result = criteria.uniqueResult();
            if (result != null) {
                total = ((Number) result).longValue();
            }

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }

        return total;
    }

    //Pagination avec filtre (par catégorie)
    public List<Produit> findPaginatedByCategorie(Categorie categorie, int page, int size) {
        Session session = null;
        Transaction tx = null;
        List<Produit> produits = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            if (page < 1) page = 1;
            if (size < 1) size = 10;

            int firstResult = (page - 1) * size;

            Criteria criteria = session.createCriteria(Produit.class);

            if (categorie != null) {
                criteria.add(Restrictions.eq("categorie", categorie));
            }

            criteria.addOrder(Order.asc("id"));
            criteria.setFirstResult(firstResult);
            criteria.setMaxResults(size);

            produits = criteria.list();

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }

        return produits;
    }

    //Recherche par nom (Criteria)
    public List<Produit> findByNomCriteria(String motCle) {
        Session session = null;
        Transaction tx = null;
        List<Produit> produits = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            Criteria criteria = session.createCriteria(Produit.class);
            criteria.add(Restrictions.ilike("nom", motCle, MatchMode.ANYWHERE));
            // si ton champ s'appelle "designation", remplace "nom" par "designation"

            produits = criteria.list();

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
