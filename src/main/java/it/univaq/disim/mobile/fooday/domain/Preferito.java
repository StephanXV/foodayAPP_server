package it.univaq.disim.mobile.fooday.domain;

import javax.persistence.*;

@Entity
@Table(name = "preferiti")
public class Preferito {

    @Id
    @GeneratedValue
    @Column(name = "ID_IMMAGINE", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_UTENTE", nullable = false)
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "ID_RISTORANTE", nullable = false)
    private Ristorante ristorante;
}
