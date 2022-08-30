package fr.afpa.tumulte.outils;

import fr.afpa.tumulte.entites.Bibliotheque;
import fr.afpa.tumulte.entites.Theme;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.ArrayList;
import java.util.List;

public class AccesStat {
    private static final String TOUTES_BIB = "Toutes les Bibliotèques";
    private static final EntityManagerFactory emf = UtileEmf.ENTITY_MANAGER_FACTORY.getEmf();

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

    public static List<Theme> listTheme(String nomBib, String annee) {
        String requete = "select exemplaire.numExemplaire " +
                "FROM theme t " +
                "INNER JOIN emplacement  ON t.codTheme = emplacement.codTheme " +
                "INNER JOIN exemplaire  ON emplacement.codEmplacement = exemplaire.codEmplacement " +
                "INNER JOIN emprunt e ON exemplaire.numExemplaire = e.numExemplaire ";
        if (nomBib.equals(TOUTES_BIB)) {
            return listThemeBiblio(requete
                    + "where t.codTheme=", annee);
        } else {
            return listThemeBiblio(requete
                    + "INNER JOIN bibliotheque b ON b.codBibliotheque = emplacement.codBibliotheque "
                    + "where b.libelBibliotheque = \"" + nomBib + "\" "
                    + "and t.codTheme = ", annee);

        }
    }

    private static List<Theme> listThemeBiblio(String requete, String annee) {
        EntityManager eM = null;
        List<Theme> themes = new ArrayList<>();
        int nbEmpruntTotal = 0;
        try {
            eM = emf.createEntityManager();
            themes = eM.createQuery("from Theme", Theme.class).getResultList();
            for (int i = 0; i < themes.size(); i++) {
                int nbEmprunt;
                if (annee != "toutes") {
                    nbEmprunt = eM.createNativeQuery(requete
                            + themes.get(i).getCodTheme()
                            + " and YEAR(e.datEmprunt) = "
                            + annee).getResultList().size();
                } else nbEmprunt = eM.createNativeQuery(requete + themes.get(i).getCodTheme()).getResultList().size();
                nbEmpruntTotal = nbEmpruntTotal + nbEmprunt;
                themes.get(i).setNbEmprunt(nbEmprunt);
            }

            Theme T0 = new Theme("0", "Tous les thèmes", "", 0);
            T0.setNbEmprunt(nbEmpruntTotal);
            themes.add(0, T0);
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (eM != null && eM.isOpen()) {
                eM.close();
            }
        }
        return themes;

    }
}
