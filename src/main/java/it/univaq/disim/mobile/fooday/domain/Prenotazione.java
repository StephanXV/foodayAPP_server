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
@Table(name = "prenotazioni")
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRENOTAZIONE", nullable = false)
    private Long id;

    @Column(name = "ORARIO", nullable = false)
    private Date orario;

    @Column(name = "NUM_POSTI", nullable = false)
    private int posti;

    @Column(name = "SCONTO_APPLICATO", nullable = false)
    private int scontoApplicato;

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

    public Date getOrario() {
        return orario;
    }

    public void setOrario(Date orario) {
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
