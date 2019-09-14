package it.univaq.disim.mobile.fooday.api;

import java.util.List;

import it.univaq.disim.mobile.fooday.domain.Prenotazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.univaq.disim.mobile.fooday.business.FoodayService;
import it.univaq.disim.mobile.fooday.domain.Utente;

@RestController
@RequestMapping("/api/prenotazioni")
public class RESTPrenotazioniController {

    @Autowired
    private FoodayService service;

    @GetMapping
    public List<Prenotazione> list() {
        Utente utente = new Utente();
        utente.setId((long) 1);
        return service.findAllPrenotazioni(utente);
    }
}
