package fr.afpa.tumulte.outils;

import fr.afpa.tumulte.entites.Theme;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class doa {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("fr.afpa.tumulte");

    public static void updateThemeLibel(String codeTheme, String libel) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            Theme theme = em.find(Theme.class, codeTheme);
            EntityTransaction trans = em.getTransaction();
            trans.begin();
            theme.setLibelTheme(libel);
            em.persist(theme);
            trans.commit();
            System.out.println(theme);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    public static List<Theme> listTheme() {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            List<Theme> themes = em.createQuery("from Theme", Theme.class).getResultList();
            return themes;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    public static void createTheme(String codeTheme, String theme, String descripTheme, int nbEmprunt) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction trans = em.getTransaction();
            trans.begin();
            Theme newTheme = new Theme(codeTheme, theme, descripTheme, nbEmprunt);
            em.persist(newTheme);
            trans.commit();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    public static void deleteThemeById(int idTheme) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            Theme theme = em.find(Theme.class, idTheme);
            EntityTransaction trans = em.getTransaction();
            trans.begin();
            em.remove(theme);
            trans.commit();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
}
