package ProgettoSettimanale.GestionePrenotazioni.entities;

import ProgettoSettimanale.GestionePrenotazioni.ENUMS.TipoPostazione;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Postazione {

    @OneToMany(mappedBy = "postazione")
    List<Prenotazione> prenotazioni;
    @Id
    @GeneratedValue
    private Long id;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    private TipoPostazione tipoPostazione;
    private int maxOccupanti;
    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private Edificio edificio;

    @Override
    public String toString() {
        return "Postazione{" +
                "id=" + id +
                ", descrizione='" + descrizione + '\'' +
                ", tipoPostazione=" + tipoPostazione +
                ", maxOccupanti=" + maxOccupanti +
                ", edificio=" + edificio +
                '}';
    }
}
