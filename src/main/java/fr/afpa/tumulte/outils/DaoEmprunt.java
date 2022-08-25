package fr.afpa.tumulte.outils;

import fr.afpa.tumulte.entites.Exemplaire;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DaoEmprunt {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("fr.afpa.tumulte");





    public static Exemplaire showExemplaire(String numExemplaire) {
        EntityManager em = emf.createEntityManager();
        return em.find(Exemplaire.class, numExemplaire);

    }
}
