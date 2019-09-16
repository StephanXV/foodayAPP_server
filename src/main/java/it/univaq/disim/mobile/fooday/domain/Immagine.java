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
