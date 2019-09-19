package it.univaq.disim.mobile.fooday.domain;

import javax.persistence.*;

@Entity
@Table(name = "citta")
public class Citta {

    @Id
    @GeneratedValue
    @Column(name = "ID_CITTA", nullable = false)
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "CODICE_POSTALE")
    private String codicePostale;

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

    public String getCodicePostale() {
        return codicePostale;
    }

    public void setCodicePostale(String codicePostale) {
        this.codicePostale = codicePostale;
    }
}
