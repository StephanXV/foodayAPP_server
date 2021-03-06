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
    private long giorno;

    @Column(name = "ORARIO", nullable = false)
    private String orario;

    @Column(name = "NUM_POSTI", nullable = false)
    private int posti;

    @Column(name = "SCONTO_APPLICATO", nullable = false)
    private int scontoApplicato;

    @Column(name = "NOME_PRENOTAZIONE", nullable = false)
    private String nome;

    @Column(name = "USA_PUNTI", nullable = false)
    private boolean usaPunti;

    @Column(name = "IS_VALUTATA")
    private boolean valutata;

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

    public Prenotazione(PrenotazioneId id, long giorno, String orario, int posti, int scontoApplicato,
                        String nomePrenotazione, Boolean usaPunti) {
        this.prenotazioneId = id;
        this.giorno = giorno;
        this.orario = orario;
        this.posti = posti;
        this.scontoApplicato = scontoApplicato;
        this.nome = nomePrenotazione;
        this.usaPunti = usaPunti;
        this.valutata = false;
    }

    public Prenotazione(PrenotazioneId id, long giorno, String orario, int posti, int scontoApplicato,
                        String nomePrenotazione, Boolean usaPunti, Boolean isValutata) {
        this.prenotazioneId = id;
        this.giorno = giorno;
        this.orario = orario;
        this.posti = posti;
        this.scontoApplicato = scontoApplicato;
        this.nome = nomePrenotazione;
        this.usaPunti = usaPunti;
        this.valutata = isValutata;
    }

    public PrenotazioneId getPrenotazioneId() {
        return prenotazioneId;
    }

    public void setPrenotazioneId(PrenotazioneId prenotazioneId) {
        this.prenotazioneId = prenotazioneId;
    }

    public long getGiorno() {
        return giorno;
    }

    public void setGiorno(long giorno) {
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isUsaPunti() {
        return usaPunti;
    }

    public void setUsaPunti(boolean usaPunti) {
        this.usaPunti = usaPunti;
    }

    public boolean isValutata() {
        return valutata;
    }

    public void setValutata(boolean valutata) {
        this.valutata = valutata;
    }

    public int getScontoApplicato() {
        return scontoApplicato;
    }

    public void setScontoApplicato(int scontoApplicato) {
        this.scontoApplicato = scontoApplicato;
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
        return super.toString();
    }
}
