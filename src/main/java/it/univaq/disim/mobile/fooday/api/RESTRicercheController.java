package it.univaq.disim.mobile.fooday.api;

import it.univaq.disim.mobile.fooday.business.FoodayService;
import it.univaq.disim.mobile.fooday.domain.Immagine;
import it.univaq.disim.mobile.fooday.domain.Orario;
import it.univaq.disim.mobile.fooday.domain.Ricerca;
import it.univaq.disim.mobile.fooday.domain.Ristorante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ricerche")
public class RESTRicercheController {

    @Autowired
    private FoodayService foodayService;


    @GetMapping("/{idUtente}")
    public List<Ricerca> getRicercheByUtente(@PathVariable long idUtente) {
        return foodayService.findRicercheByUtente(idUtente);
    }
}
