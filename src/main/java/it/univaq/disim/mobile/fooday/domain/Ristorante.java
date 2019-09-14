package it.univaq.disim.mobile.fooday.domain;

import javax.persistence.*;

@Entity
@Table(name = "ristoranti")
public class Ristorante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RISTORANTE", nullable = false)
    private Long id;
}
