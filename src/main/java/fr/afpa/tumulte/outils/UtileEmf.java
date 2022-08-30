package fr.afpa.tumulte.outils;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public enum UtileEmf {

    ENTITY_MANAGER_FACTORY;
    final EntityManagerFactory emf = Persistence.createEntityManagerFactory("fr.afpa.tumulte");

    public EntityManagerFactory getEmf() {
        return emf;
    }

}
