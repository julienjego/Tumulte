package fr.afpa.tumulte.outils;

import fr.afpa.tumulte.entites.Bibliotheque;
import fr.afpa.tumulte.entites.Theme;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

public class AccesStat {
    private static final String TOUTES_BIB = "Toutes les Bibliotèques";
    private static final Theme TOUS_LES_THEMES = new Theme("0", "Tous les thèmes", "", 0);
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
        EntityManager eM = null;
        List<Theme> themes = new ArrayList<>();
        Theme T0 = TOUS_LES_THEMES;
        int nbEmpruntTotal = 0;
        try {
            eM = entityManagerFactory.createEntityManager();
            themes = eM.createQuery("from Theme", Theme.class).getResultList();

            for (int i = 0; i < themes.size(); i++) {
                int nbEmprunt;
                nbEmprunt = eM.createNativeQuery("select exemplaire.numExemplaire \n" +
                                                         "FROM theme t\n" +
                                                         "INNER JOIN emplacement  ON t.codTheme = emplacement.codTheme\n" +
                                                         "INNER JOIN exemplaire  ON emplacement.codEmplacement = exemplaire.codEmplacement\n" +
                                                         "INNER JOIN emprunt  ON exemplaire.numExemplaire = emprunt.numExemplaire\n" +
                                                         "where t.codTheme=" + themes.get(i).getCodTheme(), String.class).getResultList().size();

                nbEmpruntTotal = nbEmpruntTotal + nbEmprunt;
                themes.get(i).setNbEmprunt(nbEmprunt);
            }
            themes.add(0, T0);
            themes.get(0).setNbEmprunt(nbEmpruntTotal);
        } catch (Exception e) {
            System.out.println(e.getCause());

        } finally {
            if (eM != null && eM.isOpen()) {
                eM.close();
            }
        }
        return themes;
    }

}
