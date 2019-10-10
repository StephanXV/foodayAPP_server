package it.univaq.disim.mobile.fooday.api;

import javax.servlet.http.HttpServletResponse;

import it.univaq.disim.mobile.fooday.domain.Ristorante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import it.univaq.disim.mobile.fooday.business.FoodayService;
import it.univaq.disim.mobile.fooday.common.spring.security.JWTTokenUtil;
import it.univaq.disim.mobile.fooday.common.spring.security.UserDetailsImpl;
import it.univaq.disim.mobile.fooday.domain.Utente;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTUtenteController {

	@Value("${jwt.token.header}")
	private String tokenHeader;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JWTTokenUtil jwtTokenUtil;

	@Autowired
	private FoodayService foodayService;

	@PostMapping("/login")
	public UtenteResponse login(@RequestBody AuthenticationRequest authenticationRequest, HttpServletResponse response) throws AuthenticationException, UnsupportedEncodingException {
		// Effettuo l'autenticazione
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Genero Token e lo inserisco nell'header di risposta
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String token = jwtTokenUtil.generateToken(userDetails);
		response.setHeader(tokenHeader, token);

		// Ritorno l'utente
		return new UtenteResponse(((UserDetailsImpl) userDetails).getUtente());
	}

	@PostMapping("/utente/updateprofilo/{vecchioUser}")
	public UtenteResponse updateProfilo(@RequestBody Utente utente, @PathVariable String vecchioUser) throws UnsupportedEncodingException {
		System.out.println(utente.toString());
		Utente nuovoUtente = foodayService.updateProfilo(utente, vecchioUser);
		return new UtenteResponse(nuovoUtente);
	}

	@PostMapping("/utente/registrazione")
	public UtenteResponse registerUtente(@RequestBody Utente utente) throws UnsupportedEncodingException{
		Utente nuovoUtente = foodayService.registerUtente(utente);
		return new UtenteResponse(nuovoUtente);
	}

	@GetMapping("/utente/preferiti/{idUtente}/{idRistorante}")
	public boolean containsPreferito ( @PathVariable long idUtente, @PathVariable long idRistorante) {
		return foodayService.containsPreferito(idUtente, idRistorante);
	}

}
