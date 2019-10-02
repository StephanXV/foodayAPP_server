package it.univaq.disim.mobile.fooday.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "prenotazioni")
public class Prenotazione {

    @EmbeddedId
    private PrenotazioneId prenotazioneId;

    @Column(name = "GIORNO", nullable = false)
    private Date giorno;

    @Column(name = "ORARIO", nullable = false)
    private String orario;

    @Column(name = "NUM_POSTI", nullable = false)
    private int posti;

    @Column(name = "SCONTO_APPLICATO", nullable = false)
    private int scontoApplicato;

    @Column(name = "TIMESTAMP", nullable = false)
    private Date timestamp;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "ID_UTENTE", insertable = false, updatable = false)
    private Utente utente;

    //@JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "ID_RISTORANTE", insertable = false, updatable = false)
    private Ristorante ristorante;

    public Prenotazione() {
    }

    public Prenotazione(PrenotazioneId id, Date giorno, String orario, int posti, int scontoApplicato,
                        Date timestamp) {
        this.prenotazioneId = id;
        this.giorno = giorno;
        this.orario = orario;
        this.posti = posti;
        this.scontoApplicato = scontoApplicato;
        this.timestamp = timestamp;
    }

    public PrenotazioneId getPrenotazioneId() {
        return prenotazioneId;
    }

    public void setPrenotazioneId(PrenotazioneId prenotazioneId) {
        this.prenotazioneId = prenotazioneId;
    }

    public Date getGiorno() {
        return giorno;
    }

    public void setGiorno(Date giorno) {
        this.giorno = giorno;
    }

    public String getOrario() {
        return orario;
    }

    public void setOrario(String orario) {
        this.orario = orario;
    }

    public int getPosti() {
        return posti;
    }

    public void setPosti(int posti) {
        this.posti = posti;
    }

    public int getScontoApplicato() {
        return scontoApplicato;
    }

    public void setScontoApplicato(int scontoApplicato) {
        this.scontoApplicato = scontoApplicato;
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
