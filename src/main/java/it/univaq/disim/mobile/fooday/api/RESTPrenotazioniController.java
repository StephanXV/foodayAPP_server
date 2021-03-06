package it.univaq.disim.mobile.fooday.api;

import it.univaq.disim.mobile.fooday.business.FoodayService;
import it.univaq.disim.mobile.fooday.domain.Prenotazione;
import it.univaq.disim.mobile.fooday.domain.Recensione;
import it.univaq.disim.mobile.fooday.domain.Ristorante;
import it.univaq.disim.mobile.fooday.domain.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.naming.ldap.PagedResultsControl;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/prenotazioni")
public class RESTPrenotazioniController {

    @Autowired
    private FoodayService foodayService;

    @GetMapping("/{idUtente}")
    public List<Prenotazione> list(@PathVariable long idUtente) {
        return foodayService.findPrenotazioniByUtenteId(idUtente);
    }

    @DeleteMapping("/delete/{idUtente}/{idRistorante}/{timestamp}")
    public int deletePrenotazioni(@PathVariable long idUtente, @PathVariable long idRistorante, @PathVariable long timestamp){
        return foodayService.deletePrenotazione(idUtente, idRistorante, timestamp);
    }

    @PostMapping
    public Prenotazione createPrenotazione(@RequestBody Prenotazione prenotazione){
        System.out.println(prenotazione.toString());
        return foodayService.createPrenotazione(prenotazione);
    }

    @GetMapping("/valutata/{idUtente}/{idRistorante}/{timestamp}")
    public int prenotazioneValutata(@PathVariable long idUtente, @PathVariable long idRistorante, @PathVariable long timestamp){
        return foodayService.prenotazioneValutata(idUtente, idRistorante, timestamp);
    }

    @PutMapping("/up/{usaPunti}")
    public Utente updatePunti(@RequestBody Utente utente, @PathVariable boolean usaPunti) {
        System.out.println(usaPunti);
        return foodayService.updatePunti(utente, usaPunti);
    }


}
