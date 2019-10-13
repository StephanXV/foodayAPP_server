package it.univaq.disim.mobile.fooday.api;

import it.univaq.disim.mobile.fooday.business.FoodayService;
import it.univaq.disim.mobile.fooday.domain.Immagine;
import it.univaq.disim.mobile.fooday.domain.Orario;
import it.univaq.disim.mobile.fooday.domain.Ristorante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/immagini")
public class RESTImmaginiController {

    @Autowired
    private FoodayService foodayService;


    @GetMapping("/{idRistorante}")
    public List<Immagine> getImmaginiByRistoranteId(@PathVariable long idRistorante) {
        return foodayService.findImmaginiByRistoranteId(idRistorante);
    }

    @GetMapping("/principale/{idRistorante}")
    public Immagine getImmaginePrincipaleByRistoranteId(@PathVariable long idRistorante) {
        return foodayService.findImmaginiByRistoranteId(idRistorante).get(0);
    }
}
