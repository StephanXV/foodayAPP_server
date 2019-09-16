package it.univaq.disim.mobile.fooday.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "recensioni")
public class Recensione {

    @Embeddable
    public static class Id implements Serializable {
        @Column(name = "ID_RISTORANTE")
        private Long ristoranteId;
        @Column(name = "ID_UTENTE")
        private Long utenteId;

        public Id() {
        }

        public Id(Long ristoranteId, Long utenteId) {
            this.ristoranteId = ristoranteId;
            this.utenteId = utenteId;
        }

        public boolean equals(Object o) {
            if (o != null && o instanceof Recensione.Id) {
                Recensione.Id that = (Recensione.Id) o;
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
    private Id id = new Id();

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
    @JoinColumn(name = "ID_UTENTE", insertable = false, updatable = false)
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "ID_RISTORANTE", insertable = false, updatable = false)
    private Ristorante ristorante;

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
