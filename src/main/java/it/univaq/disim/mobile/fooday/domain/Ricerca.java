package it.univaq.disim.mobile.fooday.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "ricerche")
public class Ricerca {

    @Id
    @GeneratedValue
    @Column(name = "ID_RICERCA", nullable = false)
    private Long id;

    @Column(name = "input", nullable = false)
    private String input;

    @Column(name = "TIPOLOGIA", nullable = false)
    private int tipoRichiesta;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "ID_UTENTE")
    private Utente utente;

    public Ricerca() {}

    public Ricerca(String input, int tipoRichiesta, Utente utente) {
        this.input = input;
        this.tipoRichiesta = tipoRichiesta;
        this.utente = utente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public int getTipoRichiesta() {
        return tipoRichiesta;
    }

    public void setTipoRichiesta(int tipoRichiesta) {
        this.tipoRichiesta = tipoRichiesta;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }
}
