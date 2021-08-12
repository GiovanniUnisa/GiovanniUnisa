package tsw.test;

import org.junit.jupiter.api.Test;
import tsw.model.Login;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {


    @Test
    void testLogin() {

        String id = "pippo";
        int idutente = 1;
        String token = "token";

        Login login = new Login(id, idutente, token);
        Login login1 = new Login(id, idutente, token);
        assertNotNull(login);
        String test = login.toString();
        String test1 = login1.toString();

        assertEquals(id, login.getId());
        assertEquals(idutente, login.getIdutente());
        assertEquals(token, login.getToken());
        assertEquals(test, login.toString());

        login1.setId(id);
        login1.setIdutente(idutente);
        login1.setToken(token);
        assertEquals(id, login1.getId());
        assertEquals(idutente, login1.getIdutente());
        assertEquals(token, login1.getToken());
        assertEquals(test1, login.toString());




    }
}