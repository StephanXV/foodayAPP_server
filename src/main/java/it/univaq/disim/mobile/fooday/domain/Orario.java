package it.univaq.disim.mobile.fooday.domain;

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
    private Date apertura;

    @Column(name = "CHIUSURA", nullable = false)
    private Date chiusura;

    public Orario() {
    }

    public Orario(Date apertura, Date chiusura, Ristorante ristorante) {
        this.apertura = apertura;
        this.chiusura = chiusura;
        this.ristorante = ristorante;
    }

    @ManyToOne
    @JoinColumn(name = "ID_RISTORANTE")
    private Ristorante ristorante;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getApertura() {
        return apertura;
    }

    public void setApertura(Date apertura) {
        this.apertura = apertura;
    }

    public Date getChiusura() {
        return chiusura;
    }

    public void setChiusura(Date chiusura) {
        this.chiusura = chiusura;
    }
}