package fr.afpa.tumulte.outils;

import fr.afpa.tumulte.entites.Adherent;
import fr.afpa.tumulte.entites.Emprunt;
import fr.afpa.tumulte.entites.TableViewEmpruntsEnCours;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProjectionTableauEmprunt {

    EntityManagerFactory emf = UtileEmf.ENTITY_MANAGER_FACTORY.getEmf();
    Adherent adherent;
    Integer empruntsEnRetard;


    public Integer getEmpruntsEnRetard() {
        return empruntsEnRetard;
    }

    public void setEmpruntsEnRetard(Integer empruntsEnRetard) {
        this.empruntsEnRetard = empruntsEnRetard;
    }

    public Integer nbEmpruntsEnRetard(Integer numAdherent) {
        empruntsEnRetard = 0;

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        for (Emprunt emprunt : adherent.getLstEmpruntsEnCours()) {
            if (emprunt.getDatRestitutionPrev().isBefore(LocalDate.now())) {
                empruntsEnRetard += 1;
            }
        }
        em.getTransaction().commit();
        return empruntsEnRetard;
    }


    public List<TableViewEmpruntsEnCours> tableViewEmpruntsEnCours(Integer numAdherent) {
        List<TableViewEmpruntsEnCours> output = new ArrayList<>();

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        adherent = em.find(Adherent.class, numAdherent);

        for (Emprunt emprunt : adherent.getLstEmpruntsEnCours()) {
            TableViewEmpruntsEnCours tv = new TableViewEmpruntsEnCours(
                    emprunt.getNumExemplaire().getlivre().getTitreLivre(),
                    emprunt.getDatEmprunt(),
                    emprunt.getNumExemplaire().getlivre().getAuteur(),
                    emprunt.getNumExemplaire().getBibliotheque().getLibelBibliotheque(),
                    emprunt.getNumExemplaire().getlivre().getIsbnLivre(),
                    emprunt.getDatRestitutionPrev(),
                    emprunt.getNumExemplaire().getNumExemplaire()
            );

            output.add(tv);
        }
        em.getTransaction().commit();
        return output;

    }
}