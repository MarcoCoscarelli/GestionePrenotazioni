package ProgettoSettimanale.GestionePrenotazioni.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Edificio {

    @OneToMany(mappedBy = "edificio")
    List<Postazione> postazioni;
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String indirizzo;
    private String citta;

    @Override
    public String toString() {
        return "Edificio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", citta='" + citta + '\'' +
                '}';
    }
}