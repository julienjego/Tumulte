package fr.afpa.tumulte.outils;

import fr.afpa.tumulte.entites.Adherent;
import fr.afpa.tumulte.entites.Emprunt;
import fr.afpa.tumulte.entites.Exemplaire;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

import static fr.afpa.tumulte.outils.Utile.calcDateRetour;


public class DaoEmprunt {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("fr.afpa.tumulte");

    public Exemplaire showExemplaire(String numExemplaire) {
        EntityManager em = emf.createEntityManager();

        return em.find(Exemplaire.class, numExemplaire);
    }

    public Emprunt creerEmprunt(Adherent adherent, Exemplaire exemplaire) {
        Emprunt emprunt = new Emprunt();
        emprunt.setNumAdherent(adherent);
        emprunt.setNumExemplaire(exemplaire);
        emprunt.setDatEmprunt(LocalDate.now());
        emprunt.setDatRestitutionPrev(calcDateRetour());

        return emprunt;
    }

    public void saveEmprunt(Emprunt emprunt) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(emprunt);
        tx.commit();

    }

    public void validerEmprunt(Integer numAdherent, String numExemplaire) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Emprunt newEmprunt = new Emprunt();
        newEmprunt.setNumAdherent(em.find(Adherent.class, numAdherent));
        newEmprunt.setNumExemplaire(em.find(Exemplaire.class, numExemplaire));
        newEmprunt.setDatEmprunt(LocalDate.now());
        newEmprunt.setDatRestitutionPrev(calcDateRetour());
        em.find(Exemplaire.class, numExemplaire).setDisponible(false);


        em.persist(newEmprunt);
        tx.commit();

    }


//    public Emprunt showEmpruntsByNumAdherent(Adherent adherent) {
//        EntityManager em = emf.createEntityManager();
//        return em.find(Emprunt.class, adherent.getNumAdherent());
//
//    }
}
