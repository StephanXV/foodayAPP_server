package it.univaq.disim.mobile.fooday.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "recensioni")
public class Recensione {

    @EmbeddedId
    private RecensioneId recensioneId;

    @Column(name = "VOTO_CUCINA", nullable = false)
    private int votoCucina;

    @Column(name = "VOTO_SERVIZIO", nullable = false)
    private int votoServizio;

    @Column(name = "VOTO_PREZZO", nullable = false)
    private int votoPrezzo;

    @Column(name = "DESCRIZIONE", nullable = false)
    private String descrizione;

    //@JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "ID_UTENTE", insertable = false, updatable = false)
    private Utente utente;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "ID_RISTORANTE", insertable = false, updatable = false)
    private Ristorante ristorante;

    public Recensione() {
    }

    public Recensione(RecensioneId recensioneId, int votoCucina, int votoServizio, int votoPrezzo,
                      String descrizione) {
        this.recensioneId = recensioneId;
        this.votoCucina = votoCucina;
        this.votoServizio = votoServizio;
        this.votoPrezzo = votoPrezzo;
        this.descrizione = descrizione;
        this.utente = utente;
        this.ristorante = ristorante;
    }

    public RecensioneId getRecensioneId() {
        return recensioneId;
    }

    public void setRecensioneId(RecensioneId id) {
        this.recensioneId = id;
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

    @Override
    public String toString() {
        return "Recensione{" +
                "recensioneId=" + recensioneId +
                ", votoCucina=" + votoCucina +
                ", votoServizio=" + votoServizio +
                ", votoPrezzo=" + votoPrezzo +
                ", descrizione='" + descrizione + '\'' +
                ", utente=" + utente +
                ", ristorante=" + ristorante +
                '}';
    }
}
