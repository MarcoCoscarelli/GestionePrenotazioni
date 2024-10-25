package ProgettoSettimanale.GestionePrenotazioni.repositories;

import ProgettoSettimanale.GestionePrenotazioni.entities.Prenotazione;
import ProgettoSettimanale.GestionePrenotazioni.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

    @Query("SELECT p FROM Prenotazione p WHERE p.utente = :utente AND p.dataPrenotazione = :dataPrenotazione")
    List<Prenotazione> findByUtenteAndData(@Param("utente") Utente utente, @Param("dataPrenotazione") LocalDate dataPrenotazione);


    @Query("SELECT COUNT(p) FROM Prenotazione p WHERE p.utente.id = :utenteId AND p.dataPrenotazione = :dataPrenotazione")
    long existsPrenotazioneByUtenteIdAndData(@Param("utenteId") Long utenteId, @Param("dataPrenotazione") LocalDate dataPrenotazione);


}
