package it.univaq.disim.mobile.fooday.domain;

import javax.persistence.*;

@Entity
@Table(name = "immagini")
public class Immagine {

    @Id
    @GeneratedValue
    @Column(name = "ID_IMMAGINE", nullable = false)
    private Long id;

    @Column(name = "SRC", nullable = false)
    private String src;

    @ManyToOne
    @JoinColumn(name = "ID_RISTORANTE")
    private Ristorante ristorante;

    public Immagine() {
    }

    public Immagine(String src, Ristorante ristorante) {
        this.src = src;
        this.ristorante = ristorante;
    }

    public Ristorante getRistorante() {
        return ristorante;
    }

    public void setRistorante(Ristorante ristorante) {
        this.ristorante = ristorante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String nome) {
        this.src = nome;
    }
}
