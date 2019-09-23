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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

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
            a.setNome("Fast Food");
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
            ristorante1.setIndirizzo("Corso Mazzini, 44");
            ristorante1.setDescrizione("Le vuoi le rostelle?");
            ristorante1.setPostiTot(40);
            ristorante1.setPunteggio(8.1);
            ristorante1.setPrezzoMedio(26);
            ristorante1.setSconto(10);
            ristorante1.setCitta(citta1);
            ristorante1.getCategorie().add(c);
            ristorante1.getCategorie().add(e);
            ristoranteRepository.save(ristorante1);

            Ristorante ristorante2 = new Ristorante();
            ristorante2.setNome("Burger King");
            ristorante2.setIndirizzo("Via Giulio Cesare, 15");
            ristorante2.setDescrizione("Un tipico fast-food");
            ristorante2.setPostiTot(120);
            ristorante2.setPunteggio(7.6);
            ristorante2.setPrezzoMedio(7.5);
            ristorante2.setSconto(15);
            ristorante2.setCitta(citta1);
            ristorante2.getCategorie().add(a);
            ristoranteRepository.save(ristorante2);

            Ristorante ristorante3 = new Ristorante();
            ristorante3.setNome("Shabu Shabu");
            ristorante3.setIndirizzo("Corso Umberto I, 175");
            ristorante3.setDescrizione("Pesce fresco e di qualità");
            ristorante3.setPostiTot(70);
            ristorante3.setPunteggio(6.9);
            ristorante3.setPrezzoMedio(24);
            ristorante3.setSconto(15);
            ristorante3.setCitta(citta2);
            ristorante3.getCategorie().add(b);
            ristorante3.getCategorie().add(d);
            ristoranteRepository.save(ristorante3);

            Pietanza pietanza1 = new Pietanza("Spaghetti al pomodoro", 7.5, TipologiaPietanza.primo, ristorante1);
            Pietanza pietanza2 = new Pietanza("Gnocchetti al ragù", 8, TipologiaPietanza.primo, ristorante1);
            Pietanza pietanza3 = new Pietanza("Salumi misti", 10, TipologiaPietanza.antipasto, ristorante1);
            Pietanza pietanza4 = new Pietanza("Formaggi misti", 9, TipologiaPietanza.antipasto, ristorante1);
            Pietanza pietanza5 = new Pietanza("Tagliata di maiale", 12, TipologiaPietanza.secondo, ristorante1);
            Pietanza pietanza6 = new Pietanza("Tagliata di manzo", 14, TipologiaPietanza.secondo, ristorante1);
            Pietanza pietanza7 = new Pietanza("Macedonia", 4.5, TipologiaPietanza.dessert, ristorante1);
            Pietanza pietanza8 = new Pietanza("Cheesecake", 4, TipologiaPietanza.dessert, ristorante1);
            Pietanza pietanza9 = new Pietanza("Coca-Cola", 2.5, TipologiaPietanza.bevanda, ristorante1);
            Pietanza pietanza10 = new Pietanza("Acqua", 1.5, TipologiaPietanza.bevanda, ristorante1);
            pietanzaRepository.save(pietanza1);
            pietanzaRepository.save(pietanza2);
            pietanzaRepository.save(pietanza3);
            pietanzaRepository.save(pietanza4);
            pietanzaRepository.save(pietanza5);
            pietanzaRepository.save(pietanza6);
            pietanzaRepository.save(pietanza7);
            pietanzaRepository.save(pietanza8);
            pietanzaRepository.save(pietanza9);
            pietanzaRepository.save(pietanza10);

            Pietanza pietanza11 = new Pietanza("Spaghetti al pomodoro", 7.5, TipologiaPietanza.primo, ristorante2);
            Pietanza pietanza12 = new Pietanza("Gnocchetti al ragù", 8, TipologiaPietanza.primo, ristorante2);
            Pietanza pietanza13 = new Pietanza("Salumi misti", 10, TipologiaPietanza.antipasto, ristorante2);
            Pietanza pietanza14 = new Pietanza("Formaggi misti", 9, TipologiaPietanza.antipasto, ristorante2);
            Pietanza pietanza15 = new Pietanza("Tagliata di maiale", 12, TipologiaPietanza.secondo, ristorante2);
            Pietanza pietanza16 = new Pietanza("Tagliata di manzo", 14, TipologiaPietanza.secondo, ristorante2);
            Pietanza pietanza17 = new Pietanza("Macedonia", 4.5, TipologiaPietanza.dessert, ristorante2);
            Pietanza pietanza18 = new Pietanza("Cheesecake", 4, TipologiaPietanza.dessert, ristorante2);
            Pietanza pietanza19 = new Pietanza("Coca-Cola", 2.5, TipologiaPietanza.bevanda, ristorante2);
            Pietanza pietanza20 = new Pietanza("Acqua", 1.5, TipologiaPietanza.bevanda, ristorante2);
            pietanzaRepository.save(pietanza11);
            pietanzaRepository.save(pietanza12);
            pietanzaRepository.save(pietanza13);
            pietanzaRepository.save(pietanza14);
            pietanzaRepository.save(pietanza15);
            pietanzaRepository.save(pietanza16);
            pietanzaRepository.save(pietanza17);
            pietanzaRepository.save(pietanza18);
            pietanzaRepository.save(pietanza19);
            pietanzaRepository.save(pietanza20);

            Pietanza pietanza21 = new Pietanza("Spaghetti al pomodoro", 7.5, TipologiaPietanza.primo, ristorante3);
            Pietanza pietanza22 = new Pietanza("Gnocchetti al ragù", 8, TipologiaPietanza.primo, ristorante3);
            Pietanza pietanza23 = new Pietanza("Salumi misti", 10, TipologiaPietanza.antipasto, ristorante3);
            Pietanza pietanza24 = new Pietanza("Formaggi misti", 9, TipologiaPietanza.antipasto, ristorante3);
            Pietanza pietanza25 = new Pietanza("Tagliata di maiale", 12, TipologiaPietanza.secondo, ristorante3);
            Pietanza pietanza26 = new Pietanza("Tagliata di manzo", 14, TipologiaPietanza.secondo, ristorante3);
            Pietanza pietanza27 = new Pietanza("Macedonia", 4.5, TipologiaPietanza.dessert, ristorante3);
            Pietanza pietanza28 = new Pietanza("Cheesecake", 4, TipologiaPietanza.dessert, ristorante3);
            Pietanza pietanza29 = new Pietanza("Coca-Cola", 2.5, TipologiaPietanza.bevanda, ristorante3);
            Pietanza pietanza30 = new Pietanza("Acqua", 1.5, TipologiaPietanza.bevanda, ristorante3);
            pietanzaRepository.save(pietanza21);
            pietanzaRepository.save(pietanza22);
            pietanzaRepository.save(pietanza23);
            pietanzaRepository.save(pietanza24);
            pietanzaRepository.save(pietanza25);
            pietanzaRepository.save(pietanza26);
            pietanzaRepository.save(pietanza27);
            pietanzaRepository.save(pietanza28);
            pietanzaRepository.save(pietanza29);
            pietanzaRepository.save(pietanza30);

            Orario orario1 = new Orario("11:30", "15:00", ristorante1);
            Orario orario2 = new Orario("18:30", "23:00", ristorante1);
            Orario orario3 = new Orario("11:30", "15:00", ristorante2);
            Orario orario4 = new Orario("18:30", "23:00", ristorante2);
            Orario orario5 = new Orario("11:30", "15:00", ristorante3);
            Orario orario6 = new Orario("18:30", "23:00", ristorante3);
            orarioRepository.save(orario1);
            orarioRepository.save(orario2);
            orarioRepository.save(orario3);
            orarioRepository.save(orario4);
            orarioRepository.save(orario5);
            orarioRepository.save(orario6);

            Immagine imm1 = new Immagine("assets/images/risto1.1.jpg", ristorante1);
            Immagine imm2 = new Immagine("assets/images/risto1.2.jpg", ristorante1);
            Immagine imm3 = new Immagine("assets/images/risto1.3.jpg", ristorante1);
            Immagine imm4 = new Immagine("assets/images/risto2.1.jpg", ristorante2);
            Immagine imm5 = new Immagine("assets/images/risto2.2.jpg", ristorante2);
            Immagine imm6 = new Immagine("assets/images/risto3.1.jpg", ristorante3);
            Immagine imm7 = new Immagine("assets/images/risto3.2.jpg", ristorante3);
            immagineRepository.save(imm1);
            immagineRepository.save(imm2);
            immagineRepository.save(imm3);
            immagineRepository.save(imm4);
            immagineRepository.save(imm5);
            immagineRepository.save(imm6);
            immagineRepository.save(imm7);


            Utente ut1 = new Utente("Stefano", "Florio", "steflo",
                    passwordEncoder.encode("stefano"), "stefano@email.com",
                    "M", "3333333336", citta1);
            ut1.getPreferiti().add(ristorante2);
            ut1.getPreferiti().add(ristorante3);
            utenteRepository.save(ut1);

            Utente ut2 = new Utente("Giuseppe", "Gasbarro", "ggas23",
                    passwordEncoder.encode("giuseppe"), "giuseppe@email.com",
                    "M", "3333333337", citta2);
            ut2.getPreferiti().add(ristorante1);
            utenteRepository.save(ut2);

            Utente ut3 = new Utente("Enrico", "Monte", "enrimon",
                    passwordEncoder.encode("enrico"), "enrico@email.com",
                    "M", "3333333338", citta1);
            ut3.getPreferiti().add(ristorante1);
            ut3.getPreferiti().add(ristorante2);
            ut3.getPreferiti().add(ristorante3);
            utenteRepository.save(ut3);

            Prenotazione pr1 = new Prenotazione(new Date(System.currentTimeMillis() - 81818181), "20:00", 2, 20,
                    new Date(System.currentTimeMillis()), ut1, ristorante1);
            Prenotazione.PrenotazioneId id1 = new Prenotazione.PrenotazioneId(ristorante1.getId(), ut1.getId());
            pr1.setId(id1);
            prenotazioneRepository.save(pr1);

            Prenotazione pr2 = new Prenotazione(new Date(System.currentTimeMillis() - 61818181), "21:30", 7, 15,
                    new Date(System.currentTimeMillis()), ut1, ristorante2);
            Prenotazione.PrenotazioneId id2 = new Prenotazione.PrenotazioneId(ristorante2.getId(), ut1.getId());
            pr1.setId(id2);
            prenotazioneRepository.save(pr2);

            Recensione rec1 = new Recensione(7, 8, 5,
                    "Ottime le cotture delle carni, tuttavia il conto è salato",
                    new Date(System.currentTimeMillis()), ut1, ristorante1);

            Recensione rec2 = new Recensione(10, 6, 8,
                    "Qualità/prezzo eccezionale, ma servizio nella norma",
                    new Date(System.currentTimeMillis()), ut2, ristorante1);

            Recensione rec3 = new Recensione(6, 5, 7,
                    "Abbiamo aspettato 2 ore per ricevere da mangiare",
                    new Date(System.currentTimeMillis()), ut3, ristorante1);

            Recensione rec4 = new Recensione(5, 5, 10,
                    "Vale quello che si spende",
                    new Date(System.currentTimeMillis()), ut1, ristorante2);

            Recensione rec5 = new Recensione(7, 9, 4,
                    "La formula 'all you can eat' costa molto, ma le portate arrivano in fretta",
                    new Date(System.currentTimeMillis()), ut3, ristorante3);

            Recensione rec6 = new Recensione(8, 6, 7,
                    "Sushi molto buono e primi ben fatti, ci ritornerò",
                    new Date(System.currentTimeMillis()), ut2, ristorante3);

            recensioneRepository.save(rec1);
            recensioneRepository.save(rec2);
            recensioneRepository.save(rec3);
            recensioneRepository.save(rec4);
            recensioneRepository.save(rec5);
            recensioneRepository.save(rec6);
        };
    }
}
