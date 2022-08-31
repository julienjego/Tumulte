package fr.afpa.tumulte.outils;

import fr.afpa.tumulte.entites.Adherent;
import fr.afpa.tumulte.entites.Emprunt;
import fr.afpa.tumulte.entites.EmpruntTicketImpression;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.ArrayList;
import java.util.List;

public class ListSommeEmprunt {
    EntityManagerFactory emf = UtileEmf.ENTITY_MANAGER_FACTORY.getEmf();
    Adherent adherent;

    public List<EmpruntTicketImpression> listEmpruntImpression(Integer numAdherent) {
        List<EmpruntTicketImpression> infoTicket = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        adherent = em.find(Adherent.class, numAdherent);

        for (Emprunt emprunt : adherent.getLstEmpruntsEnCours()) {
            EmpruntTicketImpression empruntTicketImpression = new EmpruntTicketImpression();
            empruntTicketImpression.setNumExemplaire(emprunt.getNumExemplaire().getNumExemplaire());
            empruntTicketImpression.setNumAdherent(emprunt.getNumAdherent().getNumAdherent());

            empruntTicketImpression.setTitre(emprunt.getNumExemplaire().getlivre().getTitreLivre());
            empruntTicketImpression.setBibliotheque(emprunt.getNumExemplaire().getBibliotheque().getLibelBibliotheque());
            empruntTicketImpression.setDateDePret(emprunt.getDatEmprunt());
            empruntTicketImpression.setDeteDeRetourLimite(emprunt.getDatRestitutionPrev());
            empruntTicketImpression.setIsbn(emprunt.getNumExemplaire().getlivre().getIsbnLivre());

            infoTicket.add(empruntTicketImpression);
        }
        em.getTransaction().commit();
        return infoTicket;
    }

    @Override
    public String toString() {
        return "ListSommeEmprunt{" +
                       "emf=" + emf +
                       ", adherent=" + adherent +
                       '}';
    }
}
