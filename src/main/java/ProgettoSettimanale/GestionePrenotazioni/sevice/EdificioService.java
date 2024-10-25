package ProgettoSettimanale.GestionePrenotazioni.sevice;

import ProgettoSettimanale.GestionePrenotazioni.entities.Edificio;
import ProgettoSettimanale.GestionePrenotazioni.repositories.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdificioService {

    @Autowired
    private EdificioRepository edificioRepository;

    public Edificio creaEdificio(Edificio edificio) {
        return edificioRepository.save(edificio);
    }

    public Edificio getEdificio(long id) {
        return edificioRepository.findById(id).get();
    }

    public List<Edificio> getEdifici() {
        return edificioRepository.findAll();
    }
}
