package fr.afpa.tumulte.entites;

import fr.afpa.tumulte.outils.Redaction_pk;
import jakarta.persistence.*;

@IdClass(Redaction_pk.class)
@Entity
@Table(name = "redaction")
public class Redaction {

    @Id
    @ManyToOne
    @JoinColumn(name = "IsbnLivre")
    String IsbnLivre;

    @Id
    @ManyToOne
    @JoinColumn(name = "codAuteur")
    int codAuteur;


}
