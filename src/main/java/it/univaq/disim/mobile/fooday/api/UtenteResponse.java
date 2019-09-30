package it.univaq.disim.mobile.fooday.api;

import it.univaq.disim.mobile.fooday.domain.Citta;
import it.univaq.disim.mobile.fooday.domain.Utente;
import java.util.Date;

public class UtenteResponse {

	private long id;
	private String nome;
	private String cognome;
	private String username;
	private String email;
	private String sesso;
	private String telefono;
	private Date nascita;
	private String srcImmagineProfilo;
	private Citta citta;
	private int punti;

	
	public UtenteResponse() {
	}
	
	public UtenteResponse(Utente utente) {
		this.id = utente.getId();
		this.nome = utente.getNome();
		this.cognome = utente.getCognome();
		this.username = utente.getUsername();
		this.email = utente.getEmail();
		this.sesso = utente.getSesso();
		this.telefono = utente.getTelefono();
		this.nascita = utente.getNascita();
		this.srcImmagineProfilo = utente.getSrcImmagineProfilo();
		this.citta = utente.getCitta();
		this.punti = utente.getPunti();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Date getNascita() {
		return nascita;
	}

	public void setNascita(Date nascita) {
		this.nascita = nascita;
	}

	public String getSrcImmagineProfilo() {
		return srcImmagineProfilo;
	}

	public void setSrcImmagineProfilo(String srcImmagineProfilo) {
		this.srcImmagineProfilo = srcImmagineProfilo;
	}

	public Citta getCitta() {
		return citta;
	}

	public void setCitta(Citta citta) {
		this.citta = citta;
	}

	public int getPunti() {
		return punti;
	}

	public void setPunti(int punti) {
		this.punti = punti;
	}
}
