package fr.afpa.tumulte.outils;

import fr.afpa.tumulte.entites.Bibliotheque;
import fr.afpa.tumulte.entites.Theme;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class AccesStat {
    private static final String TOUTES_BIB = "Toutes les Bibliotèques";
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("fr.afpa.tumulte");

    public static List<Bibliotheque> listBib() {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            List<Bibliotheque> bibliotheques = entityManager.createQuery("from Bibliotheque", Bibliotheque.class).getResultList();
            return bibliotheques;
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public static List<Theme> listTheme(String nomBib) {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            List<Theme> themes = entityManager.createQuery("from Theme", Theme.class).getResultList();
            return themes;
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

}
