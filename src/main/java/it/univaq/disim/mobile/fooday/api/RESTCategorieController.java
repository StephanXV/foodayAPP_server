package it.univaq.disim.mobile.fooday.api;

import it.univaq.disim.mobile.fooday.business.FoodayService;
import it.univaq.disim.mobile.fooday.domain.Categoria;
import it.univaq.disim.mobile.fooday.domain.Citta;
import it.univaq.disim.mobile.fooday.domain.Ristorante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorie")
public class RESTCategorieController {

    @Autowired
    private FoodayService foodayService;

    @GetMapping
    public List<Categoria> list() {
        return foodayService.findAllCategorie();
    }
}
