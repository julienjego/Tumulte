package fr.afpa.tumulte.outils;

import fr.afpa.tumulte.entites.Livre;
import fr.afpa.tumulte.entites.Theme;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class AccesLivre {
    private static final String TOUTES_BIB = "Toutes les Bibliotèques";
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("fr.afpa.tumulte");

    public List<Livre> listLivres(String nomBib) {

        if (nomBib.equals(TOUTES_BIB)) {
            return listLivresBib("where l.IsbnLivre= \"");
        } else {
            return listLivresBib("INNER JOIN bibliotheque b ON b.codBibliotheque = exemplaire.codBibliotheque\n"
                                         + "where b.libelBibliotheque = \"" + nomBib + "\"\n"
                                         + "and l.IsbnLivre= \"");

        }
    }

    public List<Livre> listLivresBib(String requete) {
        EntityManager eM = null;
        List<Livre> livres = new ArrayList<>();
        int nbEmpruntTotal = 0;
        try {
            eM = emf.createEntityManager();
            EntityTransaction trans = eM.getTransaction();
            trans.begin();
            livres = eM.createQuery("from Livre", Livre.class).getResultList();
            for (int i = 0; i < livres.size(); i++) {
                int nbEmprunt;
                nbEmprunt = eM.createNativeQuery("select exemplaire.numExemplaire \n"
                                                         + "FROM livre l\n"
                                                         + "INNER JOIN exemplaire  ON l.IsbnLivre = exemplaire.IsbnLivre\n"
                                                         + "INNER JOIN emprunt  ON exemplaire.numExemplaire = emprunt.numExemplaire\n"
                                                         + requete + livres.get(i).getIsbnLivre() + "\"\n",
                        String.class).getResultList().size();
                nbEmpruntTotal = nbEmpruntTotal + nbEmprunt;
                livres.get(i).setNbEmprunt(nbEmprunt);

                int nbExemplaire;
                nbExemplaire = eM.createNativeQuery("select exemplaire.numExemplaire \n"
                                                            + "FROM livre l\n"
                                                            + "INNER JOIN exemplaire  ON l.IsbnLivre = exemplaire.IsbnLivre\n"
                                                            + requete + livres.get(i).getIsbnLivre() + "\"\n",
                        String.class).getResultList().size();
                livres.get(i).setNbExemplaires(nbExemplaire);
                
            }

            trans.commit();
        } catch (Exception e) {
            System.out.println(e.getCause());

        } finally {
            if (eM != null && eM.isOpen()) {
                eM.close();
            }

        }
        return livres;
    }

    public List<Livre> filteredListLivres(String requete) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction trans = em.getTransaction();
            trans.begin();
            List<Livre> livres = em.createQuery("select l " + "from Livre l " + "where l.titreLivre like '%" + requete + "%'", Livre.class).getResultList();
            trans.commit();
            return livres;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }

        }
    }

}
