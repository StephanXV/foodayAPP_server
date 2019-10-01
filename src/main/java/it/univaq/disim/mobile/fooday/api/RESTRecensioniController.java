package it.univaq.disim.mobile.fooday.api;

import it.univaq.disim.mobile.fooday.business.FoodayService;
import it.univaq.disim.mobile.fooday.domain.Citta;
import it.univaq.disim.mobile.fooday.domain.Recensione;
import it.univaq.disim.mobile.fooday.domain.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recensioni")
public class RESTRecensioniController {

    @Autowired
    private FoodayService foodayService;

    @PostMapping
    public Recensione createRecensione(@RequestBody Recensione recensione){
        System.out.println(recensione.toString());
        return foodayService.createRecensione(recensione);
    }
}
