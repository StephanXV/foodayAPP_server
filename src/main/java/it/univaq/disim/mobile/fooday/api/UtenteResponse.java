package it.univaq.disim.mobile.fooday.api;

import it.univaq.disim.mobile.fooday.domain.Utente;
import java.util.Date;

public class UtenteResponse {

	private String username;
	private String nome;
	private String cognome;
	private String email;
	private String telefono;
        private String password;
        private Date nascita;
        private String sesso;
	
	public UtenteResponse() {
	}
	
	public UtenteResponse(Utente utente) {
		this.nome = utente.getNome();
		this.cognome = utente.getCognome();
		this.username = utente.getUsername();
		this.email = utente.getEmail();
                this.password = utente.getPassword();
                this.nascita = utente.getNascita();
                this.sesso = utente.getSesso();
		this.telefono = utente.getTelefono();
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
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
        
        public String getPassword() {
        return password;
        }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getNascita() {
        return nascita;
    }

    public void setNascita(Date data_nascita) {
        this.nascita = data_nascita;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }


}
