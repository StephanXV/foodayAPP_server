package it.univaq.disim.mobile.fooday.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.univaq.disim.mobile.fooday.business.FoodayService;
import it.univaq.disim.mobile.fooday.domain.Notizia;

@RestController
@RequestMapping("/api/notizie")
public class RESTNotizieController {
	
	@Autowired
	private FoodayService service;
	
	@GetMapping
	public List<Notizia> list() {
		return service.findAllNotizie();
	}
	
	@GetMapping("/{id}")
	public Notizia findById(@PathVariable Long id) {
		return service.findNotiziaById(id);
	}

}
