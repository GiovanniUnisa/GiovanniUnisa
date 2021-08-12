package tsw.test;

import org.junit.Test;
import tsw.model.Categoria;
import tsw.model.Prodotto;
import tsw.model.Utente;
import tsw.model.UtenteDAO;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UtenteDAOTest {

    UtenteDAO utenteDAO = new UtenteDAO();


    @Test
    public void doRetrieveAll() {

        List<Utente> utente = new ArrayList<>();
        assertNotEquals(utente, utenteDAO.doRetrieveAll());

    }

    @Test
    public void doRetrieveById() {

        Utente utente = new Utente();

        utente = utenteDAO.doRetrieveById(1);
        assertEquals(1, utente.getId());
    }

    @Test
    public void doRetrieveByUsernamePassword() {

        Utente utente = new Utente();

        utente = utenteDAO.doRetrieveByUsernamePassword("giovanni", "password1");
        assertEquals("Giovanni", utente.getUsername());

    }

    @Test
    public void doRetrieveByUsername() {
        Utente utente = new Utente();

        utente = utenteDAO.doRetrieveByUsername("giovanni");
        assertEquals("Giovanni", utente.getUsername());
    }

    @Test
    public void doRetrieveByEmail() {

        Utente utente = new Utente();

        utente = utenteDAO.doRetrieveByEmail("utente1@libero.it");
        assertEquals("utente1@libero.it", utente.getEmail());
    }

    @Test
    public void doSave() {

        Utente utente = new Utente(5, "Prova", "Prova", "Email", "Prova", false);

        boolean succ = utenteDAO.doSave(utente);
        assertEquals(true, succ);


    }

    @Test
    public void doUpdate() {

        int succ = utenteDAO.doUpdate("Prova1","Email1", "Prova1",1);
        assertEquals(1, succ);



    }

    @Test
    public void doDelete() {

        int succ = utenteDAO.doDelete(1);
        assertEquals(1, succ);

    }
}