package it.univaq.disim.mobile.fooday.api;

import it.univaq.disim.mobile.fooday.business.FoodayService;
import it.univaq.disim.mobile.fooday.domain.Prenotazione;
import it.univaq.disim.mobile.fooday.domain.Ristorante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.naming.ldap.PagedResultsControl;
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

    @DeleteMapping("/delete/{idUtente}/{idRistorante}")
    public int prova(@PathVariable long idUtente, @PathVariable long idRistorante){
        return foodayService.deletePrenotazione(idUtente, idRistorante);
    }


}
