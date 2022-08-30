package fr.afpa.tumulte.outils;

import fr.afpa.tumulte.entites.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.ArrayList;
import java.util.List;

public class AccesLivre {
    private static final String TOUTES_BIB = "Toutes les Bibliotèques";
    private static final EntityManagerFactory emf = UtileEmf.ENTITY_MANAGER_FACTORY.getEmf();

    public List<Livre> listLivres(String nomBib, String annee) {

        if (nomBib.equals(TOUTES_BIB)) {
            return listLivresBib("where l.IsbnLivre= \"", annee);
        } else {
            return listLivresBib("INNER JOIN bibliotheque b ON b.codBibliotheque = exemplaire.codBibliotheque\n"
                    + "where b.libelBibliotheque = \"" + nomBib + "\"\n"
                    + "and l.IsbnLivre= \"", annee);

        }
    }

    public List<Livre> listLivresBib(String requete, String annee) {
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
                int nbExemplaire;
                if (annee != "toutes") {
                    nbEmprunt = eM.createNativeQuery("select exemplaire.numExemplaire \n"
                                    + "FROM livre l\n"
                                    + "INNER JOIN exemplaire  ON l.IsbnLivre = exemplaire.IsbnLivre\n"
                                    + "INNER JOIN emprunt e ON exemplaire.numExemplaire = e.numExemplaire\n"
                                    + requete + livres.get(i).getIsbnLivre() + "\"\n"
                                    + " and YEAR(e.datEmprunt) = " + annee,
                            String.class).getResultList().size();
                    nbExemplaire = eM.createNativeQuery("select exemplaire.numExemplaire \n"
                                    + "FROM livre l\n"
                                    + "INNER JOIN exemplaire  ON l.IsbnLivre = exemplaire.IsbnLivre\n"
                                    + requete + livres.get(i).getIsbnLivre() + "\"\n",
                            String.class).getResultList().size();
                } else {
                    nbEmprunt = eM.createNativeQuery("select exemplaire.numExemplaire \n"
                                    + "FROM livre l\n"
                                    + "INNER JOIN exemplaire ON l.IsbnLivre = exemplaire.IsbnLivre\n"
                                    + "INNER JOIN emprunt  ON exemplaire.numExemplaire = emprunt.numExemplaire\n"
                                    + requete + livres.get(i).getIsbnLivre() + "\"\n",
                            String.class).getResultList().size();
                    nbExemplaire = eM.createNativeQuery("select exemplaire.numExemplaire \n"
                                    + "FROM livre l\n"
                                    + "INNER JOIN exemplaire  ON l.IsbnLivre = exemplaire.IsbnLivre\n"
                                    + requete + livres.get(i).getIsbnLivre() + "\"\n",
                            String.class).getResultList().size();
                }
                nbEmpruntTotal = nbEmpruntTotal + nbEmprunt;
                livres.get(i).setNbEmprunt(nbEmprunt);
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
        int nbEmpruntTotal = 0;
        try {
            em = emf.createEntityManager();
            EntityTransaction trans = em.getTransaction();
            trans.begin();

            List<Livre> livres = em.createQuery("select l from Livre l join l.auteur a "
                            + "where l.titreLivre like '%" + requete + "%' "
                            + "or a.nomAuteur like '%" + requete + "%' "
                            + "or a.prenomAuteur like '%" + requete + "%' "
                            + "or l.theme.libelTheme like '%" + requete + "%' "
                            + "or l.IsbnLivre like '%" + requete + "%' "
                            + "Group by  l.IsbnLivre"
                    , Livre.class).getResultList();
            for (int i = 0; i < livres.size(); i++) {
                int nbEmprunt;
                nbEmprunt = em.createNativeQuery("select exemplaire.numExemplaire "
                                + "FROM livre l "
                                + "INNER JOIN exemplaire  ON l.IsbnLivre = exemplaire.IsbnLivre "
                                + "INNER JOIN emprunt  ON exemplaire.numExemplaire = emprunt.numExemplaire "
                                + "WHERE l.IsbnLivre=\"" + livres.get(i).getIsbnLivre() + "\" ",
                        String.class).getResultList().size();
                nbEmpruntTotal = nbEmpruntTotal + nbEmprunt;
                livres.get(i).setNbEmprunt(nbEmprunt);

                int nbExemplaire;
                nbExemplaire = em.createNativeQuery("select exemplaire.numExemplaire  "
                                + "FROM livre l "
                                + "INNER JOIN exemplaire  ON l.IsbnLivre = exemplaire.IsbnLivre "
                                + "WHERE l.IsbnLivre=\"" + livres.get(i).getIsbnLivre() + "\" ",
                        String.class).getResultList().size();
                livres.get(i).setNbExemplaires(nbExemplaire);

            }
            trans.commit();
            return livres;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return null;
    }

}
