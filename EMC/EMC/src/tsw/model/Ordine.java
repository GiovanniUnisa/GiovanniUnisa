package tsw.model;

import java.util.List;
import java.util.Objects;

public class Ordine {

    private int id;
    private String indirizzo;
    private String prezzotot;
    private List<Utente> utenti;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getPrezzotot() {
        return prezzotot;
    }

    public void setPrezzotot(String prezzotot) {
        this.prezzotot = prezzotot;
    }

    public List<Utente> getUtenti() {
        return utenti;
    }

    public void setUtenti(List<Utente> utenti) {
        this.utenti = utenti;
    }

    @Override
    public String toString() {
        return "Ordine{" +
                "id=" + id +
                ", indirizzo='" + indirizzo + '\'' +
                ", prezzotot='" + prezzotot + '\'' +
                ", utenti=" + utenti +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ordine ordine = (Ordine) o;
        return id == ordine.id &&
                Objects.equals(indirizzo, ordine.indirizzo) &&
                Objects.equals(prezzotot, ordine.prezzotot) &&
                Objects.equals(utenti, ordine.utenti);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, indirizzo, prezzotot, utenti);
    }
}
