package it.univaq.disim.mobile.fooday.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "recensioni")
public class Recensione {

    @Embeddable
    public static class RecensioneId implements Serializable {
        @Column(name = "ID_RISTORANTE")
        private Long ristoranteId;
        @Column(name = "ID_UTENTE")
        private Long utenteId;

        public RecensioneId() {
        }

        public RecensioneId(Long ristoranteId, Long utenteId) {
            this.ristoranteId = ristoranteId;
            this.utenteId = utenteId;
        }

        public boolean equals(Object o) {
            if (o != null && o instanceof Recensione.RecensioneId) {
                Recensione.RecensioneId that = (Recensione.RecensioneId) o;
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
    private RecensioneId id;

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

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "ID_UTENTE", insertable = false, updatable = false)
    private Utente utente;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "ID_RISTORANTE", insertable = false, updatable = false)
    private Ristorante ristorante;

    public Recensione() {
    }

    public Recensione(int votoCucina, int votoServizio, int votoPrezzo,
                      String descrizione, Date timestamp, Utente utente, Ristorante ristorante) {
        this.id = new RecensioneId(ristorante.getId(), utente.getId());
        this.votoCucina = votoCucina;
        this.votoServizio = votoServizio;
        this.votoPrezzo = votoPrezzo;
        this.descrizione = descrizione;
        this.timestamp = timestamp;
        this.utente = utente;
        this.ristorante = ristorante;
    }

    public RecensioneId getId() {
        return id;
    }

    public void setId(RecensioneId id) {
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