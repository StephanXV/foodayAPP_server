package it.univaq.disim.mobile.fooday.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categorie")
public class Categoria {

    @Id
    @GeneratedValue
    @Column(name = "ID_CATEGORIA", nullable = false)
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

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


}
