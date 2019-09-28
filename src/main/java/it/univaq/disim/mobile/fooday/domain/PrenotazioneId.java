package it.univaq.disim.mobile.fooday.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PrenotazioneId implements Serializable {
    @Column(name = "ID_RISTORANTE")
    private Long ristoranteId;
    @Column(name = "ID_UTENTE")
    private Long utenteId;

    public PrenotazioneId(){}

    public PrenotazioneId(Ristorante ristorante, Utente utente) {
        this.ristoranteId = ristorante.getId();
        this.utenteId = utente.getId();
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
}