package it.univaq.disim.mobile.fooday.api;

import it.univaq.disim.mobile.fooday.business.FoodayService;
import it.univaq.disim.mobile.fooday.domain.Orario;
import it.univaq.disim.mobile.fooday.domain.Ristorante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orari")
public class RESTOrariController {

    @Autowired
    private FoodayService foodayService;


    @GetMapping("/{idRistorante}")
    public List<Orario> getOrariByRistoranteId(@PathVariable long idRistorante) {
        return foodayService.findOrariByRistoranteId(idRistorante);
    }
}
