package ProgettoSettimanale.GestionePrenotazioni;

import ProgettoSettimanale.GestionePrenotazioni.ENUMS.TipoPostazione;
import ProgettoSettimanale.GestionePrenotazioni.entities.Edificio;
import ProgettoSettimanale.GestionePrenotazioni.entities.Postazione;
import ProgettoSettimanale.GestionePrenotazioni.entities.Prenotazione;
import ProgettoSettimanale.GestionePrenotazioni.entities.Utente;
import ProgettoSettimanale.GestionePrenotazioni.sevice.EdificioService;
import ProgettoSettimanale.GestionePrenotazioni.sevice.PostazioneService;
import ProgettoSettimanale.GestionePrenotazioni.sevice.PrenotazioneService;
import ProgettoSettimanale.GestionePrenotazioni.sevice.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@PropertySource("application.properties")
public class Runner implements CommandLineRunner {

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private EdificioService edificioService;

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Override
    public void run(String... args) throws Exception {


        Utente utente1 = new Utente();
        utente1.setNomeCompleto("Marco Coscarelli");
        utente1.setEmail("marcocoscarelli@epicode.com");
        utente1.setUsername("marcosc");
        utenteService.creaUtente(utente1);

        Edificio edificio1 = new Edificio();
        edificio1.setIndirizzo("Via col vento, 90");
        edificio1.setCitta("Napoli");
        edificio1.setNome("Centro direzionale");
        edificioService.creaEdificio(edificio1);

        Postazione postazione1 = new Postazione();
        postazione1.setMaxOccupanti(20);
        postazione1.setDescrizione("Sala conference");
        postazione1.setEdificio(edificio1);
        postazione1.setTipoPostazione(TipoPostazione.SALA_RIUNIONI);
        postazioneService.creaPostazione(postazione1);

        Prenotazione prenotazione1 = new Prenotazione();
        prenotazione1.setDataPrenotazione(LocalDate.of(2024, 10, 25));
        prenotazione1.setUtente(utente1);
        prenotazione1.setPostazione(postazione1);
        prenotazioneService.creaPrenotazione(prenotazione1);


        Prenotazione prenotazione2 = new Prenotazione();
        prenotazione2.setDataPrenotazione(LocalDate.of(2024, 10, 26));
        prenotazione2.setUtente(utente1);
        prenotazione2.setPostazione(postazione1);
        if (!prenotazioneService.existsPrenotazioneByUtenteIdAndData(1L, LocalDate.of(2024, 10, 25))) {
            prenotazioneService.creaPrenotazione(prenotazione2);
        }

        System.out.println("elenco prenotazioni Marco Coscarelli 25/10/2024");
        System.out.println(prenotazioneService.findByUtenteAndData(utente1, LocalDate.of(2024, 10, 25)));

        System.out.println("elenco postazioni di tipo SALA_RIUNIONI a Napoli ");
        System.out.println(postazioneService.findByTipoPostazioneAndCitta(TipoPostazione.SALA_RIUNIONI, "Napoli"));

        System.out.println("Controlla se esiste già prenotazione per utente e data");
        System.out.println(prenotazioneService.existsPrenotazioneByUtenteIdAndData(1L, LocalDate.of(2024, 10, 25)));


    }
}
