package it.univaq.disim.mobile.fooday;

import it.univaq.disim.mobile.fooday.business.impl.repositories.*;
import it.univaq.disim.mobile.fooday.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class FoodayApplication {

    @Autowired
    private PasswordEncoder passwordEncoder;


    public static void main(String[] args) {
        SpringApplication.run(FoodayApplication.class, args);
    }


    @Bean
    public CommandLineRunner loadData(UtenteRepository utenteRepository, CittaRepository cittaRepository, OrarioRepository orarioRepository,
                                      ImmagineRepository immagineRepository, PietanzaRepository pietanzaRepository, PrenotazioneRepository prenotazioneRepository,
                                      RecensioneRepository recensioneRepository, RistoranteRepository ristoranteRepository, CategoriaRepository categoriaRepository) {
        return (args) -> {

            Categoria a = new Categoria();
            a.setNome("Pizzeria");
            categoriaRepository.save(a);
            Categoria b = new Categoria();
            b.setNome("Sushi");
            categoriaRepository.save(b);
            Categoria c = new Categoria();
            c.setNome("Osteria");
            categoriaRepository.save(c);
            Categoria d = new Categoria();
            d.setNome("Pesce");
            categoriaRepository.save(d);
            Categoria e = new Categoria();
            e.setNome("Agriturismo");
            categoriaRepository.save(e);


            Citta citta1 = new Citta();
            citta1.setNome("Vasto");
            cittaRepository.save(citta1);

            Citta citta2 = new Citta();
            citta2.setNome("Roma");
            cittaRepository.save(citta2);

            Ristorante ristorante1 = new Ristorante();
            ristorante1.setNome("Lu Barrott");
            ristorante1.setCitta(citta1);
            ristoranteRepository.save(ristorante1);

            Ristorante ristorante2 = new Ristorante();
            ristorante2.setNome("Burger King");
            ristorante2.setCitta(citta1);
            ristoranteRepository.save(ristorante2);
        };
    }
}
