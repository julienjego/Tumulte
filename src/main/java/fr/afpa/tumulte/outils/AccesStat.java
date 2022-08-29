package fr.afpa.tumulte.outils;

import fr.afpa.tumulte.entites.Bibliotheque;
import fr.afpa.tumulte.entites.Theme;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class AccesStat {
    private static final String TOUTES_BIB = "Toutes les Bibliotèques";
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("fr.afpa.tumulte");

    public static List<Bibliotheque> listBib() {
        EntityManager entityManager = null;
        try {
            entityManager = emf.createEntityManager();
            List<Bibliotheque> bibliotheques = entityManager.createQuery("from Bibliotheque", Bibliotheque.class).getResultList();
            return bibliotheques;
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public static List<Theme> listTheme(String nomBib) {
        String requete = "FROM theme t\n" +
                                 "INNER JOIN emplacement  ON t.codTheme = emplacement.codTheme\n" +
                                 "INNER JOIN exemplaire  ON emplacement.codEmplacement = exemplaire.codEmplacement\n" +
                                 "INNER JOIN emprunt  ON exemplaire.numExemplaire = emprunt.numExemplaire\n";
        if (nomBib.equals(TOUTES_BIB)) {
            return listThemeBiblio(requete
                                           + "where t.codTheme=");
        } else {
            return listThemeBiblio(requete
                                           + "INNER JOIN bibliotheque b ON b.codBibliotheque = emplacement.codBibliotheque\n"
                                           + "where b.libelBibliotheque = \"" + nomBib + "\"\n"
                                           + "and t.codTheme = ");

        }
    }

    private static List<Theme> listThemeBiblio(String requete) {
        EntityManager eM = null;
        List<Theme> themes = new ArrayList<>();
        int nbEmpruntTotal = 0;
        try {
            eM = emf.createEntityManager();
            themes = eM.createQuery("from Theme", Theme.class).getResultList();
            for (int i = 0; i < themes.size(); i++) {
                int nbEmprunt;
                nbEmprunt = eM.createNativeQuery("select exemplaire.numExemplaire \n" + requete + themes.get(i).getCodTheme(),
                        String.class).getResultList().size();

                nbEmpruntTotal = nbEmpruntTotal + nbEmprunt;
                themes.get(i).setNbEmprunt(nbEmprunt);
            }

            Theme T0 = new Theme("0", "Tous les thèmes", "", 0);
            T0.setNbEmprunt(nbEmpruntTotal);
            themes.add(0, T0);
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
