package it.univaq.disim.mobile.fooday.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ristoranti")
public class Ristorante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RISTORANTE", nullable = false)
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "INDIRIZZO")
    private String indirizzo;

    @Column(name = "DESCRIZIONE")
    private String descrizione;

    @Column(name = "NUM_POSTI")
    private int postiTot;

    @Column(name = "MEDIA_PUNTEGGIO")
    private double punteggio;

    @Column(name = "PREZZO_MEDIO")
    private double prezzoMedio;

    @Column(name = "SCONTO")
    private int sconto;

    @ManyToOne
    @JoinColumn(name = "ID_CITTA")
    private Citta citta;

    @ManyToMany
    @JoinTable(name="CATEGORIZZAZIONE",
            joinColumns={@JoinColumn(name="ID_RISTORANTE")},
            inverseJoinColumns={@JoinColumn(name="ID_CATEGORIA")})
    private Set<Ristorante> categorizzazione = new HashSet<>();

    @ManyToMany
    @JoinTable(name="PREFERITI",
            joinColumns={@JoinColumn(name="ID_RISTORANTE")},
            inverseJoinColumns={@JoinColumn(name="ID_UTENTE")})
    private Set<Ristorante> preferiti = new HashSet<>();

    @OneToMany(mappedBy = "ristorante")
    private Set<Prenotazione> prenotazioni =new HashSet<Prenotazione>();

    @OneToMany(mappedBy = "ristorante")
    private Set<Recensione> recensioni =new HashSet<Recensione>();


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

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getPostiTot() {
        return postiTot;
    }

    public void setPostiTot(int postiTot) {
        this.postiTot = postiTot;
    }

    public double getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(double punteggio) {
        this.punteggio = punteggio;
    }

    public double getPrezzoMedio() {
        return prezzoMedio;
    }

    public void setPrezzoMedio(double prezzoMedio) {
        this.prezzoMedio = prezzoMedio;
    }

    public int getSconto() {
        return sconto;
    }

    public void setSconto(int sconto) {
        this.sconto = sconto;
    }

    public Citta getCitta() {
        return citta;
    }

    public void setCitta(Citta citta) {
        this.citta = citta;
    }

    public Set<Ristorante> getCategorizzazione() {
        return categorizzazione;
    }

    public void setCategorizzazione(Set<Ristorante> categorizzazione) {
        this.categorizzazione = categorizzazione;
    }

    public Set<Ristorante> getPreferiti() {
        return preferiti;
    }

    public void setPreferiti(Set<Ristorante> preferiti) {
        this.preferiti = preferiti;
    }

    public Set<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }

    public void setPrenotazioni(Set<Prenotazione> prenotazioni) {
        this.prenotazioni = prenotazioni;
    }

    public Set<Recensione> getRecensioni() {
        return recensioni;
    }

    public void setRecensioni(Set<Recensione> recensioni) {
        this.recensioni = recensioni;
    }
}
