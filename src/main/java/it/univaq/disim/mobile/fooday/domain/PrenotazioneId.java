package it.univaq.disim.mobile.fooday.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class PrenotazioneId implements Serializable {
    @Column(name = "ID_RISTORANTE")
    private Long ristoranteId;
    @Column(name = "ID_UTENTE")
    private Long utenteId;
    @Column(name = "TMS_INSERIMENTO")
    private long timestamp;

    public PrenotazioneId(){}

    public PrenotazioneId(Ristorante ristorante, Utente utente, long timestamp) {
        this.ristoranteId = ristorante.getId();
        this.utenteId = utente.getId();
        this.timestamp = timestamp;
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

    public Long getRistoranteId() {
        return ristoranteId;
    }

    public void setRistoranteId(Long ristoranteId) {
        this.ristoranteId = ristoranteId;
    }

    public Long getUtenteId() {
        return utenteId;
    }

    public void setUtenteId(Long utenteId) {
        this.utenteId = utenteId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}