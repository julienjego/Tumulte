package fr.afpa.tumulte.outils;

import fr.afpa.tumulte.entites.Adherent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoAdherent {
    EntityManagerFactory emf = UtileEmf.ENTITY_MANAGER_FACTORY.getEmf();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    // Créer un adhérent
    public void saveAdherent(Adherent adherent) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Adherent adherentTmp;
        adherentTmp = (Adherent) em.createNativeQuery("SELECT * FROM adherent where nomAdherent like \"" + adherent.getNomAdherent() + "\"", Adherent.class).getSingleResult();

        if (adherentTmp.getNomAdherent().equals(adherent.getNomAdherent())
                && adherentTmp.getPrenomAdherent().equals(adherent.getPrenomAdherent())
                && adherentTmp.getAdrAdherent().equals(adherent.getAdrAdherent())) {
            System.out.println("adherent deja dans la base");
        } else {
            em.persist(adherent);
            System.out.println("ajout adherent");
        }
        tx.commit();

    }

    // Afficher un adhérent présent dans la BDD
    public Adherent showAdherent(Integer id) {
        Adherent adhTemp;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        adhTemp = em.find(Adherent.class, id);
        adhTemp.getLstEmpruntsEnCours();
        em.getTransaction().commit();
        return adhTemp;

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
