package it.univaq.disim.mobile.fooday.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orari")
public class Orario {

    @Id
    @GeneratedValue
    @Column(name = "ID_ORARIO", nullable = false)
    private Long id;

    @Column(name = "APERTURA", nullable = false)
    private String apertura;

    @Column(name = "CHIUSURA", nullable = false)
    private String chiusura;

    @Enumerated(EnumType.STRING)
    private Giorno giorno;

    public Orario() {
    }

    public Orario(String apertura, String chiusura, Ristorante ristorante, Giorno giorno) {
        this.apertura = apertura;
        this.chiusura = chiusura;
        this.ristorante = ristorante;
        this.giorno = giorno;
    }

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "ID_RISTORANTE")
    private Ristorante ristorante;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApertura() {
        return apertura;
    }

    public void setApertura(String apertura) {
        this.apertura = apertura;
    }

    public String getChiusura() {
        return chiusura;
    }

    public void setChiusura(String chiusura) {
        this.chiusura = chiusura;
    }

    public Ristorante getRistorante() {
        return ristorante;
    }

    public void setRistorante(Ristorante ristorante) {
        this.ristorante = ristorante;
    }

    public Giorno getGiorno() {
        return giorno;
    }

    public void setGiorno(Giorno giorno) {
        this.giorno = giorno;
    }
}