package it.univaq.disim.mobile.fooday.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    @JsonBackReference
    @ManyToMany(mappedBy = "categorie")
    private Set<Ristorante> ristoranti = new HashSet<Ristorante>();

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

    public Set<Ristorante> getRistoranti() {
        return ristoranti;
    }

    public void setRistoranti(Set<Ristorante> ristoranti) {
        this.ristoranti = ristoranti;
    }
}
