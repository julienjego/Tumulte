package fr.afpa.tumulte.outils;

import fr.afpa.tumulte.entites.Theme;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class doa {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("fr.afpa.tumulte");

    public static void updateThemeLibel(String codeTheme, String libel) {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            Theme theme = entityManager.find(Theme.class, codeTheme);
            EntityTransaction trans = entityManager.getTransaction();
            trans.begin();
            theme.setLibelTheme(libel);
            entityManager.persist(theme);
            trans.commit();
            System.out.println(theme);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public static List<Theme> listTheme() {
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

    public static void createTheme(String codeTheme, String theme, String descripTheme, int nbEmprunt) {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction trans = entityManager.getTransaction();
            trans.begin();
            Theme newTheme = new Theme(codeTheme, theme, descripTheme, nbEmprunt);
            entityManager.persist(newTheme);
            trans.commit();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public static void deleteThemeById(int idTheme) {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            Theme theme = entityManager.find(Theme.class, idTheme);
            EntityTransaction trans = entityManager.getTransaction();
            trans.begin();
            entityManager.remove(theme);
            trans.commit();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}
