package tsw.test;

import org.junit.jupiter.api.Test;
import tsw.model.Ordine;
import tsw.model.Utente;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class UtenteTest {

    @Test
    void testUtente() {

        int id = 1;
        String username = "Indirizzo";
        String passwordhash = "token";
        String nome = "Nome";
        String email = "Email";
        boolean admin = false;

        Utente utente = new Utente(id, username, passwordhash, nome, email, admin);
        Utente utente1 = new Utente(id, username, passwordhash, nome, email, admin);
        String test = utente.toString();
        String test1 = utente1.toString();


        assertEquals(id, utente.getId());
        assertEquals(username, utente.getUsername());
        assertEquals(passwordhash, utente.getPasswordhash());
        assertEquals(nome, utente.getNome());
        assertEquals(email, utente.getEmail());
        assertEquals(admin, utente.isAdmin());
        assertEquals(test, utente.toString());

        utente1.setId(id);
        utente1.setUsername(username);
        utente1.setPasswordhash(passwordhash);
        utente1.setNome(nome);
        utente1.setEmail(email);
        utente1.setAdmin(admin);
        assertEquals(id, utente1.getId());
        assertEquals(username, utente1.getUsername());
        assertEquals(passwordhash, utente1.getPasswordhash());
        assertEquals(nome, utente1.getNome());
        assertEquals(email, utente1.getEmail());
        assertEquals(admin, utente1.isAdmin());
        assertEquals(test1, utente1.toString());

    }


}