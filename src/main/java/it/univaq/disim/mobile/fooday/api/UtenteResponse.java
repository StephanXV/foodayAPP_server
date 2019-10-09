package it.univaq.disim.mobile.fooday.api;

import it.univaq.disim.mobile.fooday.domain.Citta;
import it.univaq.disim.mobile.fooday.domain.Utente;
import java.io.UnsupportedEncodingException;
import java.util.Date;

public class UtenteResponse {

	private long id;
	private String nome;
	private String cognome;
	private String username;
	private String password;
	private String email;
	private String sesso;
	private String telefono;
	private Date nascita;
	private String immagine;
	private Citta citta;
	private int punti;

	
	public UtenteResponse() {
	}
	
	public UtenteResponse(Utente utente) throws UnsupportedEncodingException {
		this.id = utente.getId();
		this.nome = utente.getNome();
		this.cognome = utente.getCognome();
		this.username = utente.getUsername();
		this.password = utente.getPassword();
		this.email = utente.getEmail();
		this.sesso = utente.getSesso();
		this.telefono = utente.getTelefono();
		this.nascita = utente.getNascita();
		this.immagine = utente.getImmagine();
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getImmagine() {
		return immagine;
	}

	public void setImmagine(String immagine) {
		this.immagine = immagine;
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
