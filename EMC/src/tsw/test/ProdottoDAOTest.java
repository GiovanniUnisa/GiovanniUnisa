package tsw.test;

import org.junit.Test;
import tsw.model.Categoria;
import tsw.model.Prodotto;
import tsw.model.ProdottoDAO;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProdottoDAOTest {
    ProdottoDAO prodottoDAO = new ProdottoDAO();
    @Test
    public void doRetrieveAll() {

        List<Prodotto> prodottoList = new ArrayList<>();
        assertNotEquals(prodottoList,prodottoDAO.doRetrieveAll());

    }

    @Test
    public void doRetrieveById() {

        List<Prodotto> prodottoList = new ArrayList<>();
        assertNotEquals(prodottoList,prodottoDAO.doRetrieveById(1));

    }

    @Test
    public void doRetrieveByCategoria() {

        List<Prodotto> prodottoList = new ArrayList<>();
        assertNotEquals(prodottoList,prodottoDAO.doRetrieveByCategoria(1));

    }

    @Test
    public void doSave() {


        Prodotto prodotto= new Prodotto(11,"nome","descrizione", 3, 2, 2);
        int pippo = prodottoDAO.doSave(prodotto);
        assertEquals(1, pippo);

    }

    @Test
    public void doUpdate() {


        Prodotto prodotto= new Prodotto(11,"nome","descrizione", 3, 2, 2);
        boolean succ = prodottoDAO.doUpdate(prodotto);

        assertEquals(true, succ);

    }

    @Test
    public void doDelete() {

        int pippo = prodottoDAO.doDelete(1);
        assertEquals(1, pippo);

    }

    @Test
    public void doRetrieveByNome() {

        List<Prodotto> prodottoList = new ArrayList<>();
        assertNotEquals(prodottoList,prodottoDAO.doRetrieveByNome("nome"));

    }

    @Test
    public void doRetrieveByNomeSingolo() {

        List<Prodotto> prodottoList = new ArrayList<>();
        assertNotEquals(prodottoList,prodottoDAO.doRetrieveByNomeSingolo("nome"));

    }

    @Test
    public void doRetrieveByDescrizione() {

        List<Prodotto> prodottoList = new ArrayList<>();
        assertNotEquals(prodottoList,prodottoDAO.doRetrieveByDescrizione("descrizione"));

    }

    @Test
    public void doRetrieveByPrezzo() {

        List<Prodotto> prodottoList = new ArrayList<>();
        assertNotEquals(prodottoList,prodottoDAO.doRetrieveByPrezzo(3));

    }

    @Test
    public void doRetrieveByIva() {

        List<Prodotto> prodottoList = new ArrayList<>();
        assertNotEquals(prodottoList,prodottoDAO.doRetrieveByIva(2));

    }

    @Test
    public void doRetrieveByNomeOrDescrizione() {

        List<Prodotto> prodottoList = new ArrayList<>();
        assertNotEquals(prodottoList,prodottoDAO.doRetrieveByNomeOrDescrizione("nome"));

    }
}