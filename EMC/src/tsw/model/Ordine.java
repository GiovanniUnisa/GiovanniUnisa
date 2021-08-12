package tsw.model;

import java.util.List;
import java.util.Objects;

public class Ordine {

    private int id;
    private String indirizzo;
    private String prezzotot;
    private Utente utente;

    public Ordine(int id, String indirizzo, String prezzotot, Utente utente) {
        this.id = id;
        this.indirizzo = indirizzo;
        this.prezzotot = prezzotot;
        this.utente = utente;
    }

    public Ordine() {


    }

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

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utenti) {
        this.utente = utenti;
    }

    @Override
    public String toString() {
        return "Ordine{" +
                "id=" + id +
                ", indirizzo='" + indirizzo + '\'' +
                ", prezzotot='" + prezzotot + '\'' +
                ", utenti=" + utente +
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
                Objects.equals(utente, ordine.utente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, indirizzo, prezzotot, utente);
    }
}
