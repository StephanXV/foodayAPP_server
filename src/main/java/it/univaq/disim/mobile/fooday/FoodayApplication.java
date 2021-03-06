package it.univaq.disim.mobile.fooday;

import it.univaq.disim.mobile.fooday.business.impl.repositories.*;
import it.univaq.disim.mobile.fooday.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import org.apache.tomcat.util.codec.binary.Base64;
import java.util.Random;

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
                                      RecensioneRepository recensioneRepository, RistoranteRepository ristoranteRepository, CategoriaRepository categoriaRepository,
                                      RicercaRepository ricercaRepository) {
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
            Categoria f = new Categoria();
            f.setNome("Braceria");
            categoriaRepository.save(f);

            Citta citta1 = new Citta();
            citta1.setNome("L'Aquila");
            citta1.setCodicePostale("67100");
            cittaRepository.save(citta1);
            Citta citta2 = new Citta();
            citta2.setNome("Pizzoli");
            citta2.setCodicePostale("3421");
            cittaRepository.save(citta2);
            Citta citta3 = new Citta();
            citta3.setNome("Vasto");
            citta3.setCodicePostale("66054");
            cittaRepository.save(citta3);
            Citta citta4 = new Citta();
            citta4.setNome("Roma");
            citta4.setCodicePostale("0118");
            cittaRepository.save(citta4);
            Citta citta5 = new Citta();
            citta5.setNome("Lucoli");
            citta5.setCodicePostale("6684");
            cittaRepository.save(citta5);

            Ristorante ristorante1 = new Ristorante();
            ristorante1.setNome("Lu Barrott");
            ristorante1.setIndirizzo("Corso Mazzini, 44");
            ristorante1.setDescrizione("Le vuoi le rostelle?");
            ristorante1.setPostiTot(40);
            ristorante1.setPrezzoMedio(26);
            ristorante1.setSconto(10);
            ristorante1.setLatitudine(42.1253);
            ristorante1.setLongitudine(14.7068);
            ristorante1.setCitta(citta3);
            ristorante1.getCategorie().add(c);
            ristorante1.getCategorie().add(e);
            ristoranteRepository.save(ristorante1);

            Ristorante ristorante2 = new Ristorante();
            ristorante2.setNome("Burger King");
            ristorante2.setIndirizzo("Via Giulio Cesare, 15");
            ristorante2.setDescrizione("Un tipico fast-food");
            ristorante2.setPostiTot(120);
            ristorante2.setPrezzoMedio(7.5);
            ristorante2.setSconto(15);
            ristorante2.setLatitudine(42.366);
            ristorante2.setLongitudine(13.3944);
            ristorante2.setCitta(citta1);
            ristorante2.getCategorie().add(a);
            ristoranteRepository.save(ristorante2);

            Ristorante ristorante3 = new Ristorante();
            ristorante3.setNome("Shabu Shabu");
            ristorante3.setIndirizzo("Corso Umberto I, 175");
            ristorante3.setDescrizione("Pesce fresco e di qualità");
            ristorante3.setPostiTot(70);
            ristorante3.setPrezzoMedio(24);
            ristorante3.setSconto(15);
            ristorante3.setLatitudine(42.4331);
            ristorante3.setLongitudine(13.3126);
            ristorante3.setCitta(citta2);
            ristorante3.getCategorie().add(b);
            ristorante3.getCategorie().add(d);
            ristoranteRepository.save(ristorante3);

            Ristorante ristorante4 = new Ristorante();
            ristorante4.setNome("Da Maurizio");
            ristorante4.setIndirizzo("Via Tramontana, 312");
            ristorante4.setDescrizione("Vieni a provare la nostra cucina romana");
            ristorante4.setPostiTot(67);
            ristorante4.setPrezzoMedio(31);
            ristorante4.setSconto(8);
            ristorante4.setLatitudine(41.8919);
            ristorante4.setLongitudine(12.5113);
            ristorante4.setCitta(citta5);
            ristorante4.getCategorie().add(c);
            ristorante4.getCategorie().add(d);
            ristoranteRepository.save(ristorante4);

            Ristorante ristorante5 = new Ristorante();
            ristorante5.setNome("La Monachina");
            ristorante5.setIndirizzo("Via colli, 3");
            ristorante5.setDescrizione("La pinsa romana più buona del mondo");
            ristorante5.setPostiTot(67);
            ristorante5.setPrezzoMedio(15);
            ristorante5.setLatitudine(41.95919);
            ristorante5.setLongitudine(12.8113);
            ristorante5.setSconto(0);
            ristorante5.setCitta(citta4);
            ristorante5.getCategorie().add(c);
            ristorante5.getCategorie().add(d);
            ristoranteRepository.save(ristorante5);

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

            Pietanza pietanza31 = new Pietanza("Spaghetti al pomodoro", 7.5, TipologiaPietanza.primo, ristorante4);
            Pietanza pietanza32 = new Pietanza("Gnocchetti al ragù", 8, TipologiaPietanza.primo, ristorante4);
            Pietanza pietanza33 = new Pietanza("Salumi misti", 10, TipologiaPietanza.antipasto, ristorante4);
            Pietanza pietanza34 = new Pietanza("Formaggi misti", 9, TipologiaPietanza.antipasto, ristorante4);
            Pietanza pietanza35 = new Pietanza("Tagliata di maiale", 12, TipologiaPietanza.secondo, ristorante4);
            Pietanza pietanza36 = new Pietanza("Tagliata di manzo", 14, TipologiaPietanza.secondo, ristorante4);
            Pietanza pietanza37 = new Pietanza("Macedonia", 4.5, TipologiaPietanza.dessert, ristorante4);
            Pietanza pietanza38 = new Pietanza("Cheesecake", 4, TipologiaPietanza.dessert, ristorante4);
            Pietanza pietanza39 = new Pietanza("Coca-Cola", 2.5, TipologiaPietanza.bevanda, ristorante4);
            Pietanza pietanza40 = new Pietanza("Acqua", 1.5, TipologiaPietanza.bevanda, ristorante4);
            pietanzaRepository.save(pietanza31);
            pietanzaRepository.save(pietanza32);
            pietanzaRepository.save(pietanza33);
            pietanzaRepository.save(pietanza34);
            pietanzaRepository.save(pietanza35);
            pietanzaRepository.save(pietanza36);
            pietanzaRepository.save(pietanza37);
            pietanzaRepository.save(pietanza38);
            pietanzaRepository.save(pietanza39);
            pietanzaRepository.save(pietanza40);

            Pietanza pietanza61 = new Pietanza("Spaghetti al pomodoro", 7.5, TipologiaPietanza.primo, ristorante5);
            Pietanza pietanza62 = new Pietanza("Gnocchetti al ragù", 8, TipologiaPietanza.primo, ristorante5);
            Pietanza pietanza63 = new Pietanza("Salumi misti", 10, TipologiaPietanza.antipasto, ristorante5);
            Pietanza pietanza64 = new Pietanza("Formaggi misti", 9, TipologiaPietanza.antipasto, ristorante5);
            Pietanza pietanza65 = new Pietanza("Tagliata di maiale", 12, TipologiaPietanza.secondo, ristorante5);
            Pietanza pietanza66 = new Pietanza("Tagliata di manzo", 14, TipologiaPietanza.secondo, ristorante5);
            Pietanza pietanza67 = new Pietanza("Macedonia", 4.5, TipologiaPietanza.dessert, ristorante5);
            Pietanza pietanza68 = new Pietanza("Cheesecake", 4, TipologiaPietanza.dessert, ristorante5);
            Pietanza pietanza69 = new Pietanza("Coca-Cola", 2.5, TipologiaPietanza.bevanda, ristorante5);
            Pietanza pietanza70 = new Pietanza("Acqua", 1.5, TipologiaPietanza.bevanda, ristorante5);
            pietanzaRepository.save(pietanza61);
            pietanzaRepository.save(pietanza62);
            pietanzaRepository.save(pietanza63);
            pietanzaRepository.save(pietanza64);
            pietanzaRepository.save(pietanza65);
            pietanzaRepository.save(pietanza66);
            pietanzaRepository.save(pietanza67);
            pietanzaRepository.save(pietanza68);
            pietanzaRepository.save(pietanza69);
            pietanzaRepository.save(pietanza70);

            Orario orario37 = new Orario("Chiuso", "", ristorante1, Giorno.lunedi);
            Orario orario1 = new Orario("11:30", "15:00", ristorante1, Giorno.martedi);
            Orario orario2 = new Orario("18:30", "23:00", ristorante1, Giorno.martedi);
            Orario orario3 = new Orario("11:30", "15:00", ristorante1, Giorno.mercoledi);
            Orario orario4 = new Orario("18:30", "23:00", ristorante1, Giorno.mercoledi);
            Orario orario5 = new Orario("11:30", "15:00", ristorante1, Giorno.giovedi);
            Orario orario6 = new Orario("18:30", "23:00", ristorante1, Giorno.giovedi);
            Orario orario7 = new Orario("11:30", "15:00", ristorante1, Giorno.venerdi);
            Orario orario8 = new Orario("18:30", "23:00", ristorante1, Giorno.venerdi);
            Orario orario9 = new Orario("11:30", "15:00", ristorante1, Giorno.sabato);
            Orario orario10 = new Orario("18:30", "23:00", ristorante1, Giorno.sabato);
            Orario orario11 = new Orario("11:30", "15:00", ristorante1, Giorno.domenica);
            Orario orario12 = new Orario("18:30", "23:00", ristorante1, Giorno.domenica);

            Orario orario39 = new Orario("Chiuso", "", ristorante2, Giorno.lunedi);
            Orario orario13 = new Orario("11:30", "15:00", ristorante2, Giorno.martedi);
            Orario orario14= new Orario("18:30", "23:00", ristorante2, Giorno.martedi);
            Orario orario15 = new Orario("11:30", "15:00", ristorante2, Giorno.mercoledi);
            Orario orario16= new Orario("18:30", "23:00", ristorante2, Giorno.mercoledi);
            Orario orario17 = new Orario("11:30", "15:00", ristorante2, Giorno.giovedi);
            Orario orario18 = new Orario("18:30", "23:00", ristorante2, Giorno.giovedi);
            Orario orario19 = new Orario("11:30", "15:00", ristorante2, Giorno.venerdi);
            Orario orario20 = new Orario("18:30", "23:00", ristorante2, Giorno.venerdi);
            Orario orario21 = new Orario("11:30", "15:00", ristorante2, Giorno.sabato);
            Orario orario22 = new Orario("18:30", "23:00", ristorante2, Giorno.sabato);
            Orario orario23 = new Orario("11:30", "15:00", ristorante2, Giorno.domenica);
            Orario orario24 = new Orario("18:30", "23:00", ristorante2, Giorno.domenica);

            Orario orario80 = new Orario("Chiuso", "", ristorante5, Giorno.lunedi);
            Orario orario81 = new Orario("11:30", "15:00", ristorante5, Giorno.martedi);
            Orario orario82= new Orario("18:30", "23:00", ristorante5, Giorno.martedi);
            Orario orario83 = new Orario("11:30", "15:00", ristorante5, Giorno.mercoledi);
            Orario orario84= new Orario("18:30", "23:00", ristorante5, Giorno.mercoledi);
            Orario orario85 = new Orario("11:30", "15:00", ristorante5, Giorno.giovedi);
            Orario orario86 = new Orario("18:30", "23:00", ristorante5, Giorno.giovedi);
            Orario orario87 = new Orario("11:30", "15:00", ristorante5, Giorno.venerdi);
            Orario orario88 = new Orario("18:30", "23:00", ristorante5, Giorno.venerdi);
            Orario orario89 = new Orario("11:30", "15:00", ristorante5, Giorno.sabato);
            Orario orario90 = new Orario("18:30", "23:00", ristorante5, Giorno.sabato);
            Orario orario91 = new Orario("11:30", "15:00", ristorante5, Giorno.domenica);
            Orario orario92 = new Orario("18:30", "23:00", ristorante5, Giorno.domenica);

            Orario orario38 = new Orario("Chiuso", "", ristorante3, Giorno.lunedi);
            Orario orario25 = new Orario("11:30", "15:00", ristorante3, Giorno.martedi);
            Orario orario26 = new Orario("18:30", "23:00", ristorante3, Giorno.martedi);
            Orario orario27 = new Orario("11:30", "15:00", ristorante3, Giorno.mercoledi);
            Orario orario28= new Orario("18:30", "23:00", ristorante3, Giorno.mercoledi);
            Orario orario29 = new Orario("11:30", "15:00", ristorante3, Giorno.giovedi);
            Orario orario30 = new Orario("18:30", "23:00", ristorante3, Giorno.giovedi);
            Orario orario31 = new Orario("11:30", "15:00", ristorante3, Giorno.venerdi);
            Orario orario32 = new Orario("18:30", "23:00", ristorante3, Giorno.venerdi);
            Orario orario33 = new Orario("11:30", "15:00", ristorante3, Giorno.sabato);
            Orario orario34 = new Orario("18:30", "23:00", ristorante3, Giorno.sabato);
            Orario orario35 = new Orario("11:30", "15:00", ristorante3, Giorno.domenica);
            Orario orario36 = new Orario("18:30", "23:00", ristorante3, Giorno.domenica);
            orarioRepository.save(orario1);
            orarioRepository.save(orario2);
            orarioRepository.save(orario3);
            orarioRepository.save(orario4);
            orarioRepository.save(orario5);
            orarioRepository.save(orario6);
            orarioRepository.save(orario7);
            orarioRepository.save(orario8);
            orarioRepository.save(orario9);
            orarioRepository.save(orario10);
            orarioRepository.save(orario11);
            orarioRepository.save(orario12);
            orarioRepository.save(orario13);
            orarioRepository.save(orario14);
            orarioRepository.save(orario15);
            orarioRepository.save(orario16);
            orarioRepository.save(orario17);
            orarioRepository.save(orario18);
            orarioRepository.save(orario19);
            orarioRepository.save(orario20);
            orarioRepository.save(orario21);
            orarioRepository.save(orario22);
            orarioRepository.save(orario23);
            orarioRepository.save(orario24);
            orarioRepository.save(orario25);
            orarioRepository.save(orario26);
            orarioRepository.save(orario27);
            orarioRepository.save(orario28);
            orarioRepository.save(orario29);
            orarioRepository.save(orario30);
            orarioRepository.save(orario31);
            orarioRepository.save(orario32);
            orarioRepository.save(orario33);
            orarioRepository.save(orario34);
            orarioRepository.save(orario35);
            orarioRepository.save(orario36);
            orarioRepository.save(orario37);
            orarioRepository.save(orario38);
            orarioRepository.save(orario39);

            String path = new File("")
                    .getAbsolutePath();

            Immagine imm1 = new Immagine(path + "/src/main/resources/images/risto1.1.jpg", ristorante1);
            Immagine imm2 = new Immagine(path + "/src/main/resources/images/risto1.2.jpg", ristorante1);
            Immagine imm3 = new Immagine(path + "/src/main/resources/images/risto1.3.jpg", ristorante1);
            Immagine imm4 = new Immagine(path + "/src/main/resources/images/risto2.1.jpg", ristorante2);
            Immagine imm5 = new Immagine(path + "/src/main/resources/images/risto2.2.jpg", ristorante2);
            Immagine imm6 = new Immagine(path + "/src/main/resources/images/risto3.1.jpg", ristorante3);
            Immagine imm7 = new Immagine(path + "/src/main/resources/images/risto3.2.jpg", ristorante3);
            Immagine imm8 = new Immagine(path + "/src/main/resources/images/risto4.1.jpg", ristorante4);
            Immagine imm9 = new Immagine(path + "/src/main/resources/images/risto4.2.jpg", ristorante4);
            Immagine imm10 = new Immagine(path + "/src/main/resources/images/risto4.3.jpg", ristorante4);
            Immagine imm11 = new Immagine(path + "/src/main/resources/images/risto3.1.jpg", ristorante5);
            Immagine imm12 = new Immagine(path + "/src/main/resources/images/risto3.2.jpg", ristorante5);
            immagineRepository.save(imm1);
            immagineRepository.save(imm2);
            immagineRepository.save(imm3);
            immagineRepository.save(imm4);
            immagineRepository.save(imm5);
            immagineRepository.save(imm6);
            immagineRepository.save(imm7);
            immagineRepository.save(imm8);
            immagineRepository.save(imm9);
            immagineRepository.save(imm10);
            immagineRepository.save(imm11);
            immagineRepository.save(imm12);

            Utente ut1 = new Utente("Stefano", "Florio", "steflo",
                    passwordEncoder.encode("stefano"), "stefano@email.com",
                    "M", "3333333336", new Date(System.currentTimeMillis()),
                    getImmagineBlob(path + "/src/main/resources/images/profilo.jpg"), citta1, 435);
            ut1.getPreferiti().add(ristorante2);
            ut1.getPreferiti().add(ristorante3);
            utenteRepository.save(ut1);

            Utente ut2 = new Utente("Giuseppe", "Gasbarro", "ggas23",
                    passwordEncoder.encode("giuseppe"), "giuseppe@email.com",
                    "M", "3333333337", new Date(System.currentTimeMillis()),
                    getImmagineBlob(path + "/src/main/resources/images/profilo.jpg"), citta2, 617);
            ut2.getPreferiti().add(ristorante1);
            ut2.getPreferiti().add(ristorante4);
            utenteRepository.save(ut2);

            Utente ut3 = new Utente("Enrico", "Monte", "enrimon",
                    passwordEncoder.encode("enrico"), "enrico@email.com",
                    "M", "3333333338", new Date(System.currentTimeMillis()),
                    getImmagineBlob(path + "/src/main/resources/images/profilo.jpg"), citta1, 9);
            ut3.getPreferiti().add(ristorante1);
            ut3.getPreferiti().add(ristorante2);
            ut3.getPreferiti().add(ristorante3);
            utenteRepository.save(ut3);


            for(int i = 0; i < 3; i++) {
                Ristorante ristorante = new Ristorante();
                ristorante.setNome("Ristorante " + i);
                ristorante.setIndirizzo("Via del ristorante " + i);
                ristorante.setDescrizione("Questo è il ristorante " + i);
                ristorante.setPrezzoMedio(new Random().nextInt(20) + 10);
                ristorante.setSconto(new Random().nextInt(31));
                ristorante.setPunteggio(new Random().nextInt(6) + 5);
                ristorante.setCitta(citta1);
                ristorante.setLatitudine(42.0 + new Random().nextDouble());
                ristorante.setLongitudine(13.0 + new Random().nextDouble());
                ristorante.setPostiTot(new Random().nextInt(100) + 50);
                ristorante.getCategorie().add(b);
                ristorante.getCategorie().add(d);
                ristoranteRepository.save(ristorante);
                Immagine immagine1 = new Immagine(path + "/src/main/resources/images/risto2.1.jpg", ristorante);
                Immagine immagine2 = new Immagine(path + "/src/main/resources/images/risto2.2.jpg", ristorante);
                immagineRepository.save(immagine1);
                immagineRepository.save(immagine2);
                Orario orario50 = new Orario("Chiuso", "", ristorante, Giorno.martedi);
                Orario orario51 = new Orario("11:30", "15:00", ristorante, Giorno.lunedi);
                Orario orario52 = new Orario("18:30", "23:00", ristorante, Giorno.lunedi);
                Orario orario53 = new Orario("11:30", "15:00", ristorante, Giorno.mercoledi);
                Orario orario54 = new Orario("18:30", "23:00", ristorante, Giorno.mercoledi);
                Orario orario55 = new Orario("11:30", "15:00", ristorante, Giorno.giovedi);
                Orario orario56 = new Orario("18:30", "23:00", ristorante, Giorno.giovedi);
                Orario orario57 = new Orario("11:30", "15:00", ristorante, Giorno.venerdi);
                Orario orario58 = new Orario("18:30", "23:00", ristorante, Giorno.venerdi);
                Orario orario59 = new Orario("11:30", "15:00", ristorante, Giorno.sabato);
                Orario orario60 = new Orario("18:30", "23:00", ristorante, Giorno.sabato);
                Orario orario61 = new Orario("11:30", "15:00", ristorante, Giorno.domenica);
                Orario orario62 = new Orario("18:30", "23:00", ristorante, Giorno.domenica);
                orarioRepository.save(orario50);
                orarioRepository.save(orario51);
                orarioRepository.save(orario52);
                orarioRepository.save(orario53);
                orarioRepository.save(orario54);
                orarioRepository.save(orario55);
                orarioRepository.save(orario56);
                orarioRepository.save(orario57);
                orarioRepository.save(orario58);
                orarioRepository.save(orario59);
                orarioRepository.save(orario60);
                orarioRepository.save(orario61);
                orarioRepository.save(orario62);
                Pietanza pietanza41 = new Pietanza("Spaghetti al pomodoro", 7.5, TipologiaPietanza.primo, ristorante);
                Pietanza pietanza42 = new Pietanza("Gnocchetti al ragù", 8, TipologiaPietanza.primo, ristorante);
                Pietanza pietanza43 = new Pietanza("Salumi misti", 10, TipologiaPietanza.antipasto, ristorante);
                Pietanza pietanza44 = new Pietanza("Formaggi misti", 9, TipologiaPietanza.antipasto, ristorante);
                Pietanza pietanza45 = new Pietanza("Tagliata di maiale", 12, TipologiaPietanza.secondo, ristorante);
                Pietanza pietanza46 = new Pietanza("Tagliata di manzo", 14, TipologiaPietanza.secondo, ristorante);
                Pietanza pietanza47 = new Pietanza("Macedonia", 4.5, TipologiaPietanza.dessert, ristorante);
                Pietanza pietanza48 = new Pietanza("Cheesecake", 4, TipologiaPietanza.dessert, ristorante);
                Pietanza pietanza49 = new Pietanza("Coca-Cola", 2.5, TipologiaPietanza.bevanda, ristorante);
                Pietanza pietanza50 = new Pietanza("Acqua", 1.5, TipologiaPietanza.bevanda, ristorante);
                pietanzaRepository.save(pietanza41);
                pietanzaRepository.save(pietanza42);
                pietanzaRepository.save(pietanza43);
                pietanzaRepository.save(pietanza44);
                pietanzaRepository.save(pietanza45);
                pietanzaRepository.save(pietanza46);
                pietanzaRepository.save(pietanza47);
                pietanzaRepository.save(pietanza48);
                pietanzaRepository.save(pietanza49);
                pietanzaRepository.save(pietanza50);

                Prenotazione pr11 = new Prenotazione(new PrenotazioneId(ristorante, ut2,
                        System.currentTimeMillis()), System.currentTimeMillis() + 61818181,
                        "21:30", 7, ristorante.getSconto(), "Stefano", false);
                prenotazioneRepository.save(pr11);

                Prenotazione pr12 = new Prenotazione(new PrenotazioneId(ristorante, ut3,
                        System.currentTimeMillis()), System.currentTimeMillis() - 61818181,
                        "21:30", 9, ristorante.getSconto(), "Florio", true);
                prenotazioneRepository.save(pr12);


                Recensione rec11 = new Recensione(new RecensioneId(ristorante, ut2, System.currentTimeMillis()),
                        new Random().nextInt(6) + 5, new Random().nextInt(6) + 5, new Random().nextInt(6) + 5,
                        "Qualità/prezzo eccezionale, ma servizio nella norma");

                Recensione rec12 = new Recensione(new RecensioneId(ristorante, ut3, System.currentTimeMillis()),
                        new Random().nextInt(6) + 5, new Random().nextInt(6) + 5, new Random().nextInt(6) + 5,
                        "Abbiamo aspettato 2 ore per ricevere da mangiare");
                recensioneRepository.save(rec11);
                recensioneRepository.save(rec12);
            }

            for(int i = 3; i < 6; i++) {
                Ristorante ristorante = new Ristorante();
                ristorante.setNome("Ristorante " + i);
                ristorante.setIndirizzo("Via del ristorante " + i);
                ristorante.setDescrizione("Questo è il ristorante " + i);
                ristorante.setPrezzoMedio(new Random().nextInt(20) + 10);
                ristorante.setSconto(new Random().nextInt(31));
                ristorante.setPunteggio(new Random().nextInt(6) + 5);
                ristorante.setCitta(citta2);
                ristorante.setLatitudine(42.0 + new Random().nextDouble());
                ristorante.setLongitudine(13.0 + new Random().nextDouble());
                ristorante.setPostiTot(new Random().nextInt(100) + 50);
                ristorante.getCategorie().add(c);
                ristorante.getCategorie().add(d);
                ristorante.getCategorie().add(e);
                ristoranteRepository.save(ristorante);
                Immagine immagine1 = new Immagine(path + "/src/main/resources/images/risto1.1.jpg", ristorante);
                Immagine immagine2 = new Immagine(path + "/src/main/resources/images/risto1.2.jpg", ristorante);
                Immagine immagine3 = new Immagine(path + "/src/main/resources/images/risto1.3.jpg", ristorante);
                immagineRepository.save(immagine1);
                immagineRepository.save(immagine2);
                immagineRepository.save(immagine3);
                Orario orario50 = new Orario("Chiuso", "", ristorante, Giorno.lunedi);
                Orario orario51 = new Orario("11:30", "15:00", ristorante, Giorno.martedi);
                Orario orario52 = new Orario("18:30", "23:00", ristorante, Giorno.martedi);
                Orario orario53 = new Orario("11:30", "15:00", ristorante, Giorno.mercoledi);
                Orario orario54 = new Orario("18:30", "23:00", ristorante, Giorno.mercoledi);
                Orario orario55 = new Orario("11:30", "15:00", ristorante, Giorno.giovedi);
                Orario orario56 = new Orario("18:30", "23:00", ristorante, Giorno.giovedi);
                Orario orario57 = new Orario("11:30", "15:00", ristorante, Giorno.venerdi);
                Orario orario58 = new Orario("18:30", "23:00", ristorante, Giorno.venerdi);
                Orario orario59 = new Orario("11:30", "15:00", ristorante, Giorno.sabato);
                Orario orario60 = new Orario("18:30", "23:00", ristorante, Giorno.sabato);
                Orario orario61 = new Orario("11:30", "15:00", ristorante, Giorno.domenica);
                Orario orario62 = new Orario("18:30", "23:00", ristorante, Giorno.domenica);
                orarioRepository.save(orario50);
                orarioRepository.save(orario51);
                orarioRepository.save(orario52);
                orarioRepository.save(orario53);
                orarioRepository.save(orario54);
                orarioRepository.save(orario55);
                orarioRepository.save(orario56);
                orarioRepository.save(orario57);
                orarioRepository.save(orario58);
                orarioRepository.save(orario59);
                orarioRepository.save(orario60);
                orarioRepository.save(orario61);
                orarioRepository.save(orario62);
                Pietanza pietanza41 = new Pietanza("Spaghetti al pomodoro", 7.5, TipologiaPietanza.primo, ristorante);
                Pietanza pietanza42 = new Pietanza("Gnocchetti al ragù", 8, TipologiaPietanza.primo, ristorante);
                Pietanza pietanza43 = new Pietanza("Salumi misti", 10, TipologiaPietanza.antipasto, ristorante);
                Pietanza pietanza44 = new Pietanza("Formaggi misti", 9, TipologiaPietanza.antipasto, ristorante);
                Pietanza pietanza45 = new Pietanza("Tagliata di maiale", 12, TipologiaPietanza.secondo, ristorante);
                Pietanza pietanza46 = new Pietanza("Tagliata di manzo", 14, TipologiaPietanza.secondo, ristorante);
                Pietanza pietanza47 = new Pietanza("Macedonia", 4.5, TipologiaPietanza.dessert, ristorante);
                Pietanza pietanza48 = new Pietanza("Cheesecake", 4, TipologiaPietanza.dessert, ristorante);
                Pietanza pietanza49 = new Pietanza("Coca-Cola", 2.5, TipologiaPietanza.bevanda, ristorante);
                Pietanza pietanza50 = new Pietanza("Acqua", 1.5, TipologiaPietanza.bevanda, ristorante);
                pietanzaRepository.save(pietanza41);
                pietanzaRepository.save(pietanza42);
                pietanzaRepository.save(pietanza43);
                pietanzaRepository.save(pietanza44);
                pietanzaRepository.save(pietanza45);
                pietanzaRepository.save(pietanza46);
                pietanzaRepository.save(pietanza47);
                pietanzaRepository.save(pietanza48);
                pietanzaRepository.save(pietanza49);
                pietanzaRepository.save(pietanza50);
                Prenotazione pr10 = new Prenotazione(new PrenotazioneId(ristorante, ut1,
                        System.currentTimeMillis()), System.currentTimeMillis() + 81818181,
                        "20:00", 2, ristorante.getSconto(), "Stefano", false);
                prenotazioneRepository.save(pr10);

                Prenotazione pr11 = new Prenotazione(new PrenotazioneId(ristorante, ut2,
                        System.currentTimeMillis()), System.currentTimeMillis() - 61818181,
                        "21:30", 7, ristorante.getSconto(), "Stefano", false);
                prenotazioneRepository.save(pr11);

                Prenotazione pr12 = new Prenotazione(new PrenotazioneId(ristorante, ut3,
                        System.currentTimeMillis()), System.currentTimeMillis() - 61818181,
                        "21:30", 9, ristorante.getSconto(), "Florio", true);
                prenotazioneRepository.save(pr12);

                Recensione rec10 = new Recensione(new RecensioneId(ristorante, ut1, System.currentTimeMillis()),
                        new Random().nextInt(6) + 5, new Random().nextInt(6) + 5, new Random().nextInt(6) + 5,
                        "Ottime le cotture delle carni, tuttavia il conto è salato");

                Recensione rec11 = new Recensione(new RecensioneId(ristorante, ut2, System.currentTimeMillis()),
                        new Random().nextInt(6) + 5, new Random().nextInt(6) + 5, new Random().nextInt(6) + 5,
                        "Qualità/prezzo eccezionale, ma servizio nella norma");

                Recensione rec12 = new Recensione(new RecensioneId(ristorante, ut3, System.currentTimeMillis()),
                        new Random().nextInt(6) + 5, new Random().nextInt(6) + 5, new Random().nextInt(6) + 5,
                        "Abbiamo aspettato 2 ore per ricevere da mangiare");
                recensioneRepository.save(rec10);
                recensioneRepository.save(rec11);
                recensioneRepository.save(rec12);
            }

            for(int i = 6; i < 9; i++) {
                Ristorante ristorante = new Ristorante();
                ristorante.setNome("Ristorante " + i);
                ristorante.setIndirizzo("Via del ristorante " + i);
                ristorante.setDescrizione("Questo è il ristorante " + i);
                ristorante.setPrezzoMedio(new Random().nextInt(20) + 10);
                ristorante.setSconto(new Random().nextInt(31));
                ristorante.setPunteggio(new Random().nextInt(6) + 5);
                ristorante.setCitta(citta3);
                ristorante.setLatitudine(42.0 + new Random().nextDouble());
                ristorante.setLongitudine(13.0 + new Random().nextDouble());
                ristorante.setPostiTot(new Random().nextInt(100) + 50);
                ristorante.getCategorie().add(a);
                ristoranteRepository.save(ristorante);
                Immagine immagine1 = new Immagine(path + "/src/main/resources/images/risto3.1.jpg", ristorante);
                Immagine immagine2 = new Immagine(path + "/src/main/resources/images/risto3.2.jpg", ristorante);
                immagineRepository.save(immagine1);
                immagineRepository.save(immagine2);
                Orario orario50 = new Orario("Chiuso", "", ristorante, Giorno.mercoledi);
                Orario orario51 = new Orario("11:30", "15:00", ristorante, Giorno.martedi);
                Orario orario52 = new Orario("18:30", "23:00", ristorante, Giorno.martedi);
                Orario orario53 = new Orario("11:30", "15:00", ristorante, Giorno.lunedi);
                Orario orario54 = new Orario("18:30", "23:00", ristorante, Giorno.lunedi);
                Orario orario55 = new Orario("11:30", "15:00", ristorante, Giorno.giovedi);
                Orario orario56 = new Orario("18:30", "23:00", ristorante, Giorno.giovedi);
                Orario orario57 = new Orario("11:30", "15:00", ristorante, Giorno.venerdi);
                Orario orario58 = new Orario("18:30", "23:00", ristorante, Giorno.venerdi);
                Orario orario59 = new Orario("11:30", "15:00", ristorante, Giorno.sabato);
                Orario orario60 = new Orario("18:30", "23:00", ristorante, Giorno.sabato);
                Orario orario61 = new Orario("11:30", "15:00", ristorante, Giorno.domenica);
                Orario orario62 = new Orario("18:30", "23:00", ristorante, Giorno.domenica);
                orarioRepository.save(orario50);
                orarioRepository.save(orario51);
                orarioRepository.save(orario52);
                orarioRepository.save(orario53);
                orarioRepository.save(orario54);
                orarioRepository.save(orario55);
                orarioRepository.save(orario56);
                orarioRepository.save(orario57);
                orarioRepository.save(orario58);
                orarioRepository.save(orario59);
                orarioRepository.save(orario60);
                orarioRepository.save(orario61);
                orarioRepository.save(orario62);
                Pietanza pietanza41 = new Pietanza("Spaghetti al pomodoro", 7.5, TipologiaPietanza.primo, ristorante);
                Pietanza pietanza42 = new Pietanza("Gnocchetti al ragù", 8, TipologiaPietanza.primo, ristorante);
                Pietanza pietanza43 = new Pietanza("Salumi misti", 10, TipologiaPietanza.antipasto, ristorante);
                Pietanza pietanza44 = new Pietanza("Formaggi misti", 9, TipologiaPietanza.antipasto, ristorante);
                Pietanza pietanza45 = new Pietanza("Tagliata di maiale", 12, TipologiaPietanza.secondo, ristorante);
                Pietanza pietanza46 = new Pietanza("Tagliata di manzo", 14, TipologiaPietanza.secondo, ristorante);
                Pietanza pietanza47 = new Pietanza("Macedonia", 4.5, TipologiaPietanza.dessert, ristorante);
                Pietanza pietanza48 = new Pietanza("Cheesecake", 4, TipologiaPietanza.dessert, ristorante);
                Pietanza pietanza49 = new Pietanza("Coca-Cola", 2.5, TipologiaPietanza.bevanda, ristorante);
                Pietanza pietanza50 = new Pietanza("Acqua", 1.5, TipologiaPietanza.bevanda, ristorante);
                pietanzaRepository.save(pietanza41);
                pietanzaRepository.save(pietanza42);
                pietanzaRepository.save(pietanza43);
                pietanzaRepository.save(pietanza44);
                pietanzaRepository.save(pietanza45);
                pietanzaRepository.save(pietanza46);
                pietanzaRepository.save(pietanza47);
                pietanzaRepository.save(pietanza48);
                pietanzaRepository.save(pietanza49);
                pietanzaRepository.save(pietanza50);
                Prenotazione pr10 = new Prenotazione(new PrenotazioneId(ristorante, ut1,
                        System.currentTimeMillis()), System.currentTimeMillis() - 81818181,
                        "20:00", 2, ristorante.getSconto(), "Stefano", false);
                prenotazioneRepository.save(pr10);

                Prenotazione pr11 = new Prenotazione(new PrenotazioneId(ristorante, ut2,
                        System.currentTimeMillis()), System.currentTimeMillis() - 61818181,
                        "21:30", 7, ristorante.getSconto(), "Stefano", false);
                prenotazioneRepository.save(pr11);

                Prenotazione pr12 = new Prenotazione(new PrenotazioneId(ristorante, ut3,
                        System.currentTimeMillis()), System.currentTimeMillis() - 61818181,
                        "21:30", 9, ristorante.getSconto(), "Florio", true, true);
                prenotazioneRepository.save(pr12);

                Recensione rec10 = new Recensione(new RecensioneId(ristorante, ut1, System.currentTimeMillis()),
                        new Random().nextInt(6) + 5, new Random().nextInt(6) + 5, new Random().nextInt(6) + 5,
                        "Ottime le cotture delle carni, tuttavia il conto è salato");

                Recensione rec11 = new Recensione(new RecensioneId(ristorante, ut2, System.currentTimeMillis()),
                        new Random().nextInt(6) + 5, new Random().nextInt(6) + 5, new Random().nextInt(6) + 5,
                        "Qualità/prezzo eccezionale, ma servizio nella norma");

                Recensione rec12 = new Recensione(new RecensioneId(ristorante, ut3, System.currentTimeMillis()),
                        new Random().nextInt(6) + 5, new Random().nextInt(6) + 5, new Random().nextInt(6) + 5,
                        "Abbiamo aspettato 2 ore per ricevere da mangiare");
                recensioneRepository.save(rec10);
                recensioneRepository.save(rec11);
                recensioneRepository.save(rec12);
            }

            for(int i = 9; i < 12; i++) {
                Ristorante ristorante = new Ristorante();
                ristorante.setNome("Ristorante " + i);
                ristorante.setIndirizzo("Via del ristorante " + i);
                ristorante.setDescrizione("Questo è il ristorante " + i);
                ristorante.setPrezzoMedio(new Random().nextInt(20) + 10);
                ristorante.setSconto(new Random().nextInt(31));
                ristorante.setPunteggio(new Random().nextInt(6) + 5);
                ristorante.setCitta(citta4);
                ristorante.setLatitudine(42.0 + new Random().nextDouble());
                ristorante.setLongitudine(13.0 + new Random().nextDouble());
                ristorante.setPostiTot(new Random().nextInt(100) + 50);
                ristorante.getCategorie().add(e);
                ristorante.getCategorie().add(f);
                ristoranteRepository.save(ristorante);
                Immagine immagine1 = new Immagine(path + "/src/main/resources/images/risto4.1.jpg", ristorante);
                Immagine immagine2 = new Immagine(path + "/src/main/resources/images/risto4.2.jpg", ristorante);
                immagineRepository.save(immagine1);
                immagineRepository.save(immagine2);
                Orario orario50 = new Orario("Chiuso", "", ristorante, Giorno.lunedi);
                Orario orario51 = new Orario("11:30", "15:00", ristorante, Giorno.martedi);
                Orario orario52 = new Orario("18:30", "23:00", ristorante, Giorno.martedi);
                Orario orario53 = new Orario("11:30", "15:00", ristorante, Giorno.mercoledi);
                Orario orario54 = new Orario("18:30", "23:00", ristorante, Giorno.mercoledi);
                Orario orario55 = new Orario("11:30", "15:00", ristorante, Giorno.giovedi);
                Orario orario56 = new Orario("18:30", "23:00", ristorante, Giorno.giovedi);
                Orario orario57 = new Orario("11:30", "15:00", ristorante, Giorno.venerdi);
                Orario orario58 = new Orario("18:30", "23:00", ristorante, Giorno.venerdi);
                Orario orario59 = new Orario("11:30", "15:00", ristorante, Giorno.sabato);
                Orario orario60 = new Orario("18:30", "23:00", ristorante, Giorno.sabato);
                Orario orario61 = new Orario("11:30", "15:00", ristorante, Giorno.domenica);
                Orario orario62 = new Orario("18:30", "23:00", ristorante, Giorno.domenica);
                orarioRepository.save(orario50);
                orarioRepository.save(orario51);
                orarioRepository.save(orario52);
                orarioRepository.save(orario53);
                orarioRepository.save(orario54);
                orarioRepository.save(orario55);
                orarioRepository.save(orario56);
                orarioRepository.save(orario57);
                orarioRepository.save(orario58);
                orarioRepository.save(orario59);
                orarioRepository.save(orario60);
                orarioRepository.save(orario61);
                orarioRepository.save(orario62);
                Pietanza pietanza41 = new Pietanza("Spaghetti al pomodoro", 7.5, TipologiaPietanza.primo, ristorante);
                Pietanza pietanza42 = new Pietanza("Gnocchetti al ragù", 8, TipologiaPietanza.primo, ristorante);
                Pietanza pietanza43 = new Pietanza("Salumi misti", 10, TipologiaPietanza.antipasto, ristorante);
                Pietanza pietanza44 = new Pietanza("Formaggi misti", 9, TipologiaPietanza.antipasto, ristorante);
                Pietanza pietanza45 = new Pietanza("Tagliata di maiale", 12, TipologiaPietanza.secondo, ristorante);
                Pietanza pietanza46 = new Pietanza("Tagliata di manzo", 14, TipologiaPietanza.secondo, ristorante);
                Pietanza pietanza47 = new Pietanza("Macedonia", 4.5, TipologiaPietanza.dessert, ristorante);
                Pietanza pietanza48 = new Pietanza("Cheesecake", 4, TipologiaPietanza.dessert, ristorante);
                Pietanza pietanza49 = new Pietanza("Coca-Cola", 2.5, TipologiaPietanza.bevanda, ristorante);
                Pietanza pietanza50 = new Pietanza("Acqua", 1.5, TipologiaPietanza.bevanda, ristorante);
                pietanzaRepository.save(pietanza41);
                pietanzaRepository.save(pietanza42);
                pietanzaRepository.save(pietanza43);
                pietanzaRepository.save(pietanza44);
                pietanzaRepository.save(pietanza45);
                pietanzaRepository.save(pietanza46);
                pietanzaRepository.save(pietanza47);
                pietanzaRepository.save(pietanza48);
                pietanzaRepository.save(pietanza49);
                pietanzaRepository.save(pietanza50);
                Prenotazione pr10 = new Prenotazione(new PrenotazioneId(ristorante, ut1,
                        System.currentTimeMillis()), System.currentTimeMillis() + 81818181,
                        "20:00", 2, ristorante.getSconto(), "Stefano", false);
                prenotazioneRepository.save(pr10);

                Prenotazione pr11 = new Prenotazione(new PrenotazioneId(ristorante, ut2,
                        System.currentTimeMillis()), System.currentTimeMillis() - 61818181,
                        "21:30", 7, ristorante.getSconto(), "Stefano", false, true);
                prenotazioneRepository.save(pr11);

                Prenotazione pr12 = new Prenotazione(new PrenotazioneId(ristorante, ut3,
                        System.currentTimeMillis()), System.currentTimeMillis() - 61818181,
                        "21:30", 9, ristorante.getSconto(), "Florio", true);
                prenotazioneRepository.save(pr12);

                Recensione rec10 = new Recensione(new RecensioneId(ristorante, ut1, System.currentTimeMillis()),
                        new Random().nextInt(6) + 5, new Random().nextInt(6) + 5, new Random().nextInt(6) + 5,
                        "Ottime le cotture delle carni, tuttavia il conto è salato");

                Recensione rec11 = new Recensione(new RecensioneId(ristorante, ut2, System.currentTimeMillis()),
                        new Random().nextInt(6) + 5, new Random().nextInt(6) + 5, new Random().nextInt(6) + 5,
                        "Qualità/prezzo eccezionale, ma servizio nella norma");

                Recensione rec12 = new Recensione(new RecensioneId(ristorante, ut3, System.currentTimeMillis()),
                        new Random().nextInt(6) + 5, new Random().nextInt(6) + 5, new Random().nextInt(6) + 5,
                        "Abbiamo aspettato 2 ore per ricevere da mangiare");
                recensioneRepository.save(rec10);
                recensioneRepository.save(rec11);
                recensioneRepository.save(rec12);
            }

            for(int i = 12; i < 15; i++) {
                Ristorante ristorante = new Ristorante();
                ristorante.setNome("Ristorante " + i);
                ristorante.setIndirizzo("Via del ristorante " + i);
                ristorante.setDescrizione("Questo è il ristorante " + i);
                ristorante.setPrezzoMedio(new Random().nextInt(20) + 10);
                ristorante.setSconto(new Random().nextInt(31));
                ristorante.setPunteggio(new Random().nextInt(6) + 5);
                ristorante.setCitta(citta5);
                ristorante.setLatitudine(42.0 + new Random().nextDouble());
                ristorante.setLongitudine(13.0 + new Random().nextDouble());
                ristorante.setPostiTot(new Random().nextInt(100) + 50);
                ristorante.getCategorie().add(f);
                ristoranteRepository.save(ristorante);
                Immagine immagine1 = new Immagine(path + "/src/main/resources/images/risto2.1.jpg", ristorante);
                Immagine immagine2 = new Immagine(path + "/src/main/resources/images/risto2.2.jpg", ristorante);
                immagineRepository.save(immagine1);
                immagineRepository.save(immagine2);
                Orario orario50 = new Orario("Chiuso", "", ristorante, Giorno.martedi);
                Orario orario51 = new Orario("11:30", "15:00", ristorante, Giorno.lunedi);
                Orario orario52 = new Orario("18:30", "23:00", ristorante, Giorno.lunedi);
                Orario orario53 = new Orario("11:30", "15:00", ristorante, Giorno.mercoledi);
                Orario orario54 = new Orario("18:30", "23:00", ristorante, Giorno.mercoledi);
                Orario orario55 = new Orario("11:30", "15:00", ristorante, Giorno.giovedi);
                Orario orario56 = new Orario("18:30", "23:00", ristorante, Giorno.giovedi);
                Orario orario57 = new Orario("11:30", "15:00", ristorante, Giorno.venerdi);
                Orario orario58 = new Orario("18:30", "23:00", ristorante, Giorno.venerdi);
                Orario orario59 = new Orario("11:30", "15:00", ristorante, Giorno.sabato);
                Orario orario60 = new Orario("18:30", "23:00", ristorante, Giorno.sabato);
                Orario orario61 = new Orario("11:30", "15:00", ristorante, Giorno.domenica);
                Orario orario62 = new Orario("18:30", "23:00", ristorante, Giorno.domenica);
                orarioRepository.save(orario50);
                orarioRepository.save(orario51);
                orarioRepository.save(orario52);
                orarioRepository.save(orario53);
                orarioRepository.save(orario54);
                orarioRepository.save(orario55);
                orarioRepository.save(orario56);
                orarioRepository.save(orario57);
                orarioRepository.save(orario58);
                orarioRepository.save(orario59);
                orarioRepository.save(orario60);
                orarioRepository.save(orario61);
                orarioRepository.save(orario62);
                Pietanza pietanza41 = new Pietanza("Spaghetti al pomodoro", 7.5, TipologiaPietanza.primo, ristorante);
                Pietanza pietanza42 = new Pietanza("Gnocchetti al ragù", 8, TipologiaPietanza.primo, ristorante);
                Pietanza pietanza43 = new Pietanza("Salumi misti", 10, TipologiaPietanza.antipasto, ristorante);
                Pietanza pietanza44 = new Pietanza("Formaggi misti", 9, TipologiaPietanza.antipasto, ristorante);
                Pietanza pietanza45 = new Pietanza("Tagliata di maiale", 12, TipologiaPietanza.secondo, ristorante);
                Pietanza pietanza46 = new Pietanza("Tagliata di manzo", 14, TipologiaPietanza.secondo, ristorante);
                Pietanza pietanza47 = new Pietanza("Macedonia", 4.5, TipologiaPietanza.dessert, ristorante);
                Pietanza pietanza48 = new Pietanza("Cheesecake", 4, TipologiaPietanza.dessert, ristorante);
                Pietanza pietanza49 = new Pietanza("Coca-Cola", 2.5, TipologiaPietanza.bevanda, ristorante);
                Pietanza pietanza50 = new Pietanza("Acqua", 1.5, TipologiaPietanza.bevanda, ristorante);
                pietanzaRepository.save(pietanza41);
                pietanzaRepository.save(pietanza42);
                pietanzaRepository.save(pietanza43);
                pietanzaRepository.save(pietanza44);
                pietanzaRepository.save(pietanza45);
                pietanzaRepository.save(pietanza46);
                pietanzaRepository.save(pietanza47);
                pietanzaRepository.save(pietanza48);
                pietanzaRepository.save(pietanza49);
                pietanzaRepository.save(pietanza50);
                Prenotazione pr10 = new Prenotazione(new PrenotazioneId(ristorante, ut1,
                        System.currentTimeMillis()), System.currentTimeMillis() - 81818181,
                        "20:00", 2, ristorante.getSconto(), "Stefano", false, true);
                prenotazioneRepository.save(pr10);

                Prenotazione pr11 = new Prenotazione(new PrenotazioneId(ristorante, ut2,
                        System.currentTimeMillis()), System.currentTimeMillis() + 61818181,
                        "21:30", 7, ristorante.getSconto(), "Stefano", false);
                prenotazioneRepository.save(pr11);

                Prenotazione pr12 = new Prenotazione(new PrenotazioneId(ristorante, ut3,
                        System.currentTimeMillis()), System.currentTimeMillis() - 61818181,
                        "21:30", 9, ristorante.getSconto(), "Florio", true);
                prenotazioneRepository.save(pr12);

                Recensione rec10 = new Recensione(new RecensioneId(ristorante, ut1, System.currentTimeMillis()),
                        new Random().nextInt(6) + 5, new Random().nextInt(6) + 5, new Random().nextInt(6) + 5,
                        "Ottime le cotture delle carni, tuttavia il conto è salato");

                Recensione rec11 = new Recensione(new RecensioneId(ristorante, ut2, System.currentTimeMillis()),
                        new Random().nextInt(6) + 5, new Random().nextInt(6) + 5, new Random().nextInt(6) + 5,
                        "Qualità/prezzo eccezionale, ma servizio nella norma");

                Recensione rec12 = new Recensione(new RecensioneId(ristorante, ut3, System.currentTimeMillis()),
                        new Random().nextInt(6) + 5, new Random().nextInt(6) + 5, new Random().nextInt(6) + 5,
                        "Abbiamo aspettato 2 ore per ricevere da mangiare");
                recensioneRepository.save(rec10);
                recensioneRepository.save(rec11);
                recensioneRepository.save(rec12);
            }



            Prenotazione pr1 = new Prenotazione(new PrenotazioneId(ristorante1, ut1,
                    System.currentTimeMillis()), System.currentTimeMillis() + 81818181,
                    "20:00", 2, ristorante1.getSconto(), "Stefano", false, true);
            prenotazioneRepository.save(pr1);

            Prenotazione pr2 = new Prenotazione(new PrenotazioneId(ristorante2, ut1,
                    System.currentTimeMillis()), System.currentTimeMillis() + 61818181,
                    "21:30", 7, ristorante2.getSconto(), "Stefano", false);
            prenotazioneRepository.save(pr2);

            Prenotazione pr3 = new Prenotazione(new PrenotazioneId(ristorante4, ut1,
                    System.currentTimeMillis()), System.currentTimeMillis() - 61818181,
                    "21:30", 9, ristorante4.getSconto(), "Florio", true);
            prenotazioneRepository.save(pr3);

            Recensione rec1 = new Recensione(new RecensioneId(ristorante1, ut1, System.currentTimeMillis()), 7, 8, 5,
                    "Ottime le cotture delle carni, tuttavia il conto è salato");

            Recensione rec2 = new Recensione(new RecensioneId(ristorante1, ut2, System.currentTimeMillis()),10, 6, 8,
                    "Qualità/prezzo eccezionale, ma servizio nella norma");

            Recensione rec3 = new Recensione(new RecensioneId(ristorante1, ut3, System.currentTimeMillis()),6, 5, 7,
                    "Abbiamo aspettato 2 ore per ricevere da mangiare");

            Recensione rec4 = new Recensione(new RecensioneId(ristorante2, ut1, System.currentTimeMillis()),5, 5, 10,
                    "Vale quello che si spende");

            Recensione rec5 = new Recensione(new RecensioneId(ristorante3, ut3, System.currentTimeMillis()),7, 9, 4,
                    "La formula 'all you can eat' costa molto, ma le portate arrivano in fretta");

            Recensione rec6 = new Recensione(new RecensioneId(ristorante3, ut2, System.currentTimeMillis()),8, 6, 7,
                    "Sushi molto buono e primi ben fatti, ci ritornerò");

            Recensione rec7 = new Recensione(new RecensioneId(ristorante3, ut1, System.currentTimeMillis()),9, 9, 6,
                    "Mi è piaciuto tutto moltissimo");

            Recensione rec8 = new Recensione(new RecensioneId(ristorante3, ut2, System.currentTimeMillis()),8, 7, 7,
                    "Ottima qualità del pesce ad un ottimo prezzo");

            recensioneRepository.save(rec1);
            recensioneRepository.save(rec2);
            recensioneRepository.save(rec3);
            recensioneRepository.save(rec4);
            recensioneRepository.save(rec5);
            recensioneRepository.save(rec6);
            recensioneRepository.save(rec7);
            recensioneRepository.save(rec8);

            Ricerca ric1 = new Ricerca("lu", 3, ut1);
            Ricerca ric2 = new Ricerca("vasto", 2, ut1);
            Ricerca ric3 = new Ricerca("roma", 2, ut2);
            Ricerca ric4 = new Ricerca("shabu", 3, ut3);
            ricercaRepository.save(ric1);
            ricercaRepository.save(ric2);
            ricercaRepository.save(ric3);
            ricercaRepository.save(ric4);
        };
    }
    
    public String getImmagineBlob(String filePathStr) throws IOException {
        // get path object pointing to fil
        Path filePath = Paths.get(filePathStr);
        // get byte array with file contents
        byte[] fileContent = Files.readAllBytes(filePath);
        return new String(Base64.encodeBase64(fileContent), "UTF-8");        
    }
}
