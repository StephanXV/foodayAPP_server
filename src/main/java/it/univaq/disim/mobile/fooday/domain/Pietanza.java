package it.univaq.disim.mobile.fooday.domain;

import javax.persistence.*;

@Entity
@Table(name = "pietanze")
public class Pietanza {

    @Id
    @GeneratedValue
    @Column(name = "ID_PIETANZA", nullable = false)
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "PREZZO", nullable = false)
    private double prezzo;

    @Enumerated(EnumType.STRING)
    private TipologiaPietanza tipologia;

    @ManyToOne
    @JoinColumn(name = "ID_RISTORANTE")
    private Ristorante ristorante;

    public Pietanza() {
    }

    public Pietanza(String nome, double prezzo, TipologiaPietanza tipologia, Ristorante ristorante) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.tipologia = tipologia;
        this.ristorante = ristorante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public TipologiaPietanza getTipologia() {
        return tipologia;
    }

    public void setTipologia(TipologiaPietanza tipologia) {
        this.tipologia = tipologia;
    }

    public Ristorante getRistorante() {
        return ristorante;
    }

    public void setRistorante(Ristorante ristorante) {
        this.ristorante = ristorante;
    }
}
