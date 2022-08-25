package fr.afpa.tumulte.outils;

import fr.afpa.tumulte.entites.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class AccesLivre {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("fr.afpa.tumulte");

    public List<Livre> listLivres() {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction trans = em.getTransaction();
            trans.begin();
            List<Livre> livres = em.createQuery("from Livre", Livre.class).getResultList();
            trans.commit();
            return livres;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }

        }
    }
}
