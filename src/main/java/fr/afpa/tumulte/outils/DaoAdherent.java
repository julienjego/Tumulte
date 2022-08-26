package fr.afpa.tumulte.outils;

import fr.afpa.tumulte.entites.Adherent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DaoAdherent {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("fr.afpa.tumulte");

    // Créer ou mettre à jour un adhérent
    public void saveAdherent(Adherent adherent) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        if (adherent.getNumAdherent() == null){
            em.persist(adherent);
        } else {
            em.merge(adherent);
        }
        tx.commit();

    }

    // Afficher un adhérent présent dans la BDD
    public Adherent showAdherent(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Adherent.class, id);

    }

    // Supprimer un adhérent
    public void deleteAdherent(Integer id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        // On cherche un adhérent pour le supprimer car remove requiert un objet
        em.remove(em.find(Adherent.class, id));
        tx.commit();
    }

}
