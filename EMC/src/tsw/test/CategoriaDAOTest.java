package tsw.test;

import org.junit.Test;
import tsw.model.Categoria;
import tsw.model.CategoriaDAO;

import static org.junit.Assert.*;

public class CategoriaDAOTest {

    @Test
    public void doRetrieveAll() {
    }

    @Test
    public void doSave() {


        Categoria categoria = new Categoria(111, "Categoria1", "Descrione1");
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        int pippo = categoriaDAO.doSave(categoria);

        assertEquals(11, pippo);

    }

    @Test
    public void doUpdate() {
    }

    @Test
    public void doDelete() {
    }

    @Test
    public void doRetrieveByNome() {
    }

    @Test
    public void doRetrieveByDescrizione() {
    }
}