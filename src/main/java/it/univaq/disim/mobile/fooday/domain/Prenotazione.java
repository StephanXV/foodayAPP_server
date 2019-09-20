package it.univaq.disim.mobile.fooday.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "prenotazioni")
public class Prenotazione {

    @Embeddable
    public static class PrenotazioneId implements Serializable {
        @Column(name = "ID_RISTORANTE")
        private Long ristoranteId;
        @Column(name = "ID_UTENTE")
        private Long utenteId;

        public PrenotazioneId() {
        }

        public PrenotazioneId(Long ristoranteId, Long utenteId) {
            this.ristoranteId = ristoranteId;
            this.utenteId = utenteId;
        }

        public boolean equals(Object o) {
            if (o != null && o instanceof PrenotazioneId) {
                PrenotazioneId that = (PrenotazioneId) o;
                return this.ristoranteId.equals(that.ristoranteId)
                        && this.utenteId.equals(that.utenteId);
            } else {
                return false;
            }
        }

        public int hashCode() {
            return ristoranteId.hashCode() + utenteId.hashCode();
        }
    }

    @EmbeddedId
    private PrenotazioneId id;

    @Column(name = "ORARIO", nullable = false)
    private Date orario;

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

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "ID_RISTORANTE", insertable = false, updatable = false)
    private Ristorante ristorante;

    public Prenotazione() {
    }

    public Prenotazione(Date orario, int posti, int scontoApplicato,
                        Date timestamp, Utente utente, Ristorante ristorante) {
        this.id = new PrenotazioneId(ristorante.getId(), utente.getId());
        this.orario = orario;
        this.posti = posti;
        this.scontoApplicato = scontoApplicato;
        this.timestamp = timestamp;
        this.utente = utente;
        this.ristorante = ristorante;
    }

    public PrenotazioneId getId() {
        return id;
    }

    public void setId(PrenotazioneId id) {
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
