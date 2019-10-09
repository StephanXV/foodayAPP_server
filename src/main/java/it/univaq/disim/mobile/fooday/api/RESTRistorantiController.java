package it.univaq.disim.mobile.fooday.api;

import it.univaq.disim.mobile.fooday.business.FoodayService;
import it.univaq.disim.mobile.fooday.domain.Ristorante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/ristoranti")
public class RESTRistorantiController {

    @Autowired
    private FoodayService foodayService;

    @GetMapping("/byidcitta/{idCitta}")
    public List<Ristorante> getRistorantiByCittaId(@PathVariable long idCitta) {
        return foodayService.findRistorantiByUserCity(idCitta);
    }

    @GetMapping("/bynomecitta/{nomeCitta}")
    public List<Ristorante> getRistorantiByCittaNome(@PathVariable String nomeCitta) {
        return foodayService.findRistorantiByCittaNome(nomeCitta);
    }

    @GetMapping("/categoria/{idCategoria}")
    public List<Ristorante> getRistorantiByCategoriaId(@PathVariable long idCategoria) {
        return foodayService.findRistorantiByCategoryId(idCategoria);
    }

    @GetMapping("/{idRistorante}")
    public Ristorante getRistoranteById(@PathVariable long idRistorante) {
        return foodayService.findRistoranteById(idRistorante);
    }

    @GetMapping("/bynome/{nomeRisto}")
    public List<Ristorante> getRistorantiByNome(@PathVariable String nomeRisto) {
        return foodayService.findRistorantiByNome(nomeRisto);
    }

    @GetMapping("/preferiti/{idUtente}")
    public List<Ristorante> getRistorantiPreferiti(@PathVariable Long idUtente) {
        return foodayService.findRistorantiPreferiti(idUtente);
    }

    @DeleteMapping("preferiti/{idRistorante}/{idUtente}")
    public void deleteRistoranteByPreferiti(@PathVariable long idRistorante, @PathVariable long idUtente) {
        foodayService.deleteRistoranteByPreferiti(idRistorante, idUtente);
    }

    @GetMapping("/around/{lat}/{lon}")
    public List<Ristorante> getRistorantiAroundUser(@PathVariable String lat, @PathVariable String lon) throws IOException {
        return foodayService.findRistorantiAroundUser(lat, lon);
    }

    @GetMapping("preferiti/aggiungi/{idRistorante}/{idUtente}")
    public boolean addPreferito(@PathVariable long idRistorante, @PathVariable long idUtente) {
        return foodayService.addPreferito(idRistorante, idUtente);
    }
}
