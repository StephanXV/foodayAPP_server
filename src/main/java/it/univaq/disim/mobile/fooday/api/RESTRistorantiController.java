package it.univaq.disim.mobile.fooday.api;

import it.univaq.disim.mobile.fooday.business.FoodayService;
import it.univaq.disim.mobile.fooday.domain.Ristorante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ristoranti")
public class RESTRistorantiController {

    @Autowired
    private FoodayService foodayService;

    @GetMapping("/citta/{idCitta}")
    public List<Ristorante> getRistorantiByCittaId(@PathVariable long idCitta) {
        return foodayService.findRistorantiByUserCity(idCitta);
    }

    @GetMapping("/categoria/{idCategoria}")
    public List<Ristorante> getRistorantiByCategoriaId(@PathVariable long idCategoria) {
        return foodayService.findRistorantiByCategoryId(idCategoria);
    }

    @GetMapping("/{idRistorante}")
    public Ristorante getRistoranteById(@PathVariable long idRistorante) {
        return foodayService.findRistoranteById(idRistorante);
    }
}
