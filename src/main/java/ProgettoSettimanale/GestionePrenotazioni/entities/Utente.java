package ProgettoSettimanale.GestionePrenotazioni.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Utente {
    @OneToMany(mappedBy = "utente")
    List<Prenotazione> prenotazioni;
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String nomeCompleto;
    private String email;

    @Override
    public String toString() {
        return "Utente{" +
                "email='" + email + '\'' +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", username='" + username + '\'' +
                ", id=" + id +
                '}';
    }
}
