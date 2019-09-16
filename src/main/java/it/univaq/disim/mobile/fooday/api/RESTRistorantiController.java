package it.univaq.disim.mobile.fooday.api;

import it.univaq.disim.mobile.fooday.business.FoodayService;
import it.univaq.disim.mobile.fooday.domain.Ristorante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ristoranti")
public class RESTRistorantiController {
    @Autowired
    private FoodayService foodayService;

    @GetMapping
    public List<Ristorante> list() {
        return foodayService.findAllRistoranti();
    }
}
