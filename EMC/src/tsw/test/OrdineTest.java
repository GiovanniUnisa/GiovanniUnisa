package tsw.test;

import org.junit.jupiter.api.Test;
import tsw.model.Login;
import tsw.model.Ordine;
import tsw.model.Utente;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrdineTest {

    @Test
    void testOrdine() {

        int id = 1;
        String indirizzo = "Indirizzo";
        String prezzo = "token";
        Utente utente = new Utente(1, "Pippo", "pass", "Nome", "Email", true);
        Ordine ordine = new Ordine(id, indirizzo, prezzo, utente);

        assertNotNull(ordine);
        String test = ordine.toString();

        assertEquals(id, ordine.getId());
        assertEquals(indirizzo, ordine.getIndirizzo());
        assertEquals(prezzo, ordine.getPrezzotot());
        assertEquals(utente, ordine.getUtente());
        assertEquals(test, ordine.toString());



    }


}