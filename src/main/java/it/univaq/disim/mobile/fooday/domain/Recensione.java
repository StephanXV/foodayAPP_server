package it.univaq.disim.mobile.fooday.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "recensioni")
public class Recensione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RECENSIONE", nullable = false)
    private Long id;

    @Column(name = "VOTO_CUCINA", nullable = false)
    private int votoCucina;

    @Column(name = "VOTO_SERVIZIO", nullable = false)
    private int votoServizio;

    @Column(name = "VOTO_PREZZO", nullable = false)
    private int votoPrezzo;

    @Column(name = "DESCRIZIONE", nullable = false)
    private String descrizione;

    @Column(name = "TIMESTAMP", nullable = false)
    private Date timestamp;

    @ManyToOne
    @JoinColumn(name = "ID_UTENTE", nullable = false)
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "ID_RISTORANTE", nullable = false)
    private Ristorante ristorante;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVotoCucina() {
        return votoCucina;
    }

    public void setVotoCucina(int votoCucina) {
        this.votoCucina = votoCucina;
    }

    public int getVotoServizio() {
        return votoServizio;
    }

    public void setVotoServizio(int votoServizio) {
        this.votoServizio = votoServizio;
    }

    public int getVotoPrezzo() {
        return votoPrezzo;
    }

    public void setVotoPrezzo(int votoPrezzo) {
        this.votoPrezzo = votoPrezzo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Ristorante getRistorante() {
        return ristorante;
    }

    public void setRistorante(Ristorante ristorante) {
        this.ristorante = ristorante;
    }
}
