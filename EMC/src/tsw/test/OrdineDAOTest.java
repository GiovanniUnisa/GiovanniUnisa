package tsw.test;

import org.junit.Test;
import tsw.model.Categoria;
import tsw.model.CategoriaDAO;
import tsw.model.Ordine;
import tsw.model.OrdineDAO;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OrdineDAOTest {
    OrdineDAO ordineDAO = new OrdineDAO();
    @Test
    public void doSave() {

        int pippo = ordineDAO.doSave("indirizzo",2,"prezzo");
        assertEquals(1, pippo);

    }

    @Test
    public void doRetrieveByUtente() {

        List<Ordine> ordineList = new ArrayList<>();
        assertNotEquals(ordineList,ordineDAO.doRetrieveByUtente(2));

    }
}