package it.univaq.disim.mobile.fooday.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.*;

@Entity
@Table(name = "utenti")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPOLOGIA_UTENTE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("utente")
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_UTENTE", nullable = false)
	private Long id;

	@Column(name = "NOME", nullable = false, length = 255)
	private String nome;

	@Column(name = "COGNOME", nullable = false, length = 255)
	private String cognome;

	@Column(name = "USERNAME", nullable = false, length = 16, updatable = false, unique = true)
	private String username;

	@JsonIgnore
	@Column(name = "PASSWORD", nullable = false, length = 255)
	private String password;
	
	@Column(name = "EMAIL", nullable = false, length = 255)
	private String email;

	@Column(name = "SESSO", nullable = false, length = 1)
	private String sesso;

	@Column(name = "TELEFONO", length = 20)
	private String telefono;

	@Column(name = "DATA_NASCITA")
	private Date nascita;

	@Column(name = "SRC_IMMAGINE")
	private String srcImmagineProfilo;

	@Column(name = "PUNTI")
	private int punti;

	@ManyToOne
	@JoinColumn(name = "ID_CITTA", nullable = false)
	private Citta citta;

	@JsonBackReference
	@ManyToMany
	@JoinTable(name="PREFERITI",
			joinColumns={@JoinColumn(name="ID_UTENTE")},
			inverseJoinColumns={@JoinColumn(name="ID_RISTORANTE")})
	private Set<Ristorante> preferiti = new HashSet<Ristorante>();

	@JsonBackReference
	@OneToMany(mappedBy = "utente")
	private Set<Prenotazione> prenotazioni = new HashSet<Prenotazione>();

	@JsonBackReference
	@OneToMany(mappedBy = "utente")
	private Set<Recensione> recensioni = new HashSet<Recensione>();

	@JsonBackReference
	@OneToMany(mappedBy = "utente")
	private Set<Ricerca> ricerche = new HashSet<Ricerca>();

	public Utente() {
	}

	public Utente(String nome, String cognome, String username,
				  String password, String email, String sesso,
				  String telefono, Date nascita, String src, Citta citta, int punti) {
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.email = email;
		this.sesso = sesso;
		this.telefono = telefono;
		this.citta = citta;
		this.srcImmagineProfilo = src;
		this.nascita = nascita;
		this.punti = punti;
	}

	public int getPunti() {
		return punti;
	}

	public void setPunti(int punti) {
		this.punti = punti;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSrcImmagineProfilo() {
		return srcImmagineProfilo;
	}

	public Date getNascita() {
		return nascita;
	}

	public void setNascita(Date nascita) {
		this.nascita = nascita;
	}

	public void setSrcImmagineProfilo(String srcImmagineProfilo) {
		this.srcImmagineProfilo = srcImmagineProfilo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Citta getCitta() {
		return citta;
	}

	public void setCitta(Citta citta) {
		this.citta = citta;
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

	public Set<Ricerca> getRicerche() {
		return ricerche;
	}

	public void setRicerche(Set<Ricerca> ricerche) {
		this.ricerche = ricerche;
	}
}
