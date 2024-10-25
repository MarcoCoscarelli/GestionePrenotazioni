package ProgettoSettimanale.GestionePrenotazioni.sevice;

import ProgettoSettimanale.GestionePrenotazioni.entities.Prenotazione;
import ProgettoSettimanale.GestionePrenotazioni.entities.Utente;
import ProgettoSettimanale.GestionePrenotazioni.repositories.PostazioneRepository;
import ProgettoSettimanale.GestionePrenotazioni.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private PostazioneRepository postazioneRepository;


    public Prenotazione getPrenotazione(long id) {
        return prenotazioneRepository.findById(id).get();
    }

    public List<Prenotazione> getPrenotazioni() {
        return prenotazioneRepository.findAll();
    }

    public void creaPrenotazione(Prenotazione prenotazione) {
        prenotazioneRepository.save(prenotazione);
    }


    public List<Prenotazione> findByUtenteAndData(Utente utente, LocalDate data) {
        return prenotazioneRepository.findByUtenteAndData(utente, data);
    }

    public boolean existsPrenotazioneByUtenteIdAndData(Long utenteId, LocalDate data) {
        if (prenotazioneRepository.existsPrenotazioneByUtenteIdAndData(utenteId, data) > 0) {
            return true;
        } else {
            return false;
        }
    }
}
