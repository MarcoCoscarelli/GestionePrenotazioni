package ProgettoSettimanale.GestionePrenotazioni.sevice;

import ProgettoSettimanale.GestionePrenotazioni.ENUMS.TipoPostazione;
import ProgettoSettimanale.GestionePrenotazioni.entities.Postazione;
import ProgettoSettimanale.GestionePrenotazioni.repositories.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;

    public Postazione creaPostazione(Postazione postazione) {
        return postazioneRepository.save(postazione);
    }

    public Postazione getPostazione(long id) {
        return postazioneRepository.findById(id).get();
    }

    public List<Postazione> getPostazioni() {
        return postazioneRepository.findAll();
    }

    public List<Postazione> findByTipoPostazioneAndCitta(TipoPostazione tipoPostazione, String citta) {
        return postazioneRepository.findByTipoPostazioneAndCitta(tipoPostazione, citta);
    }

}
