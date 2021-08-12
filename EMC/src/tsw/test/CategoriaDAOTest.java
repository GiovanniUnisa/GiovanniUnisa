package tsw.test;

import org.junit.Test;
import tsw.model.Categoria;
import tsw.model.CategoriaDAO;
import tsw.model.ConPool;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CategoriaDAOTest {

    CategoriaDAO categoriaDAO = new CategoriaDAO();


    @Test
    public void doRetrieveAll() {

        List<Categoria> categoria = new ArrayList<>();
        assertNotEquals(categoria, categoriaDAO.doRetrieveAll());

    }


    @Test
    public void doSave() {


        Categoria categoriaValida = new Categoria(10, "Categoria1", "Descrione1");
        Categoria categoriaNonValida = new Categoria(11, "Categoria1", "Descrione1");

        int succ = categoriaDAO.doSave(categoriaValida);
        assertEquals(1, succ);


    }

    @Test
    public void doUpdate() {

        Categoria categoriaUpdate = new Categoria(4, "CategoriaNuova", "DescrizioneNuova");
        boolean succ = categoriaDAO.doUpdate(categoriaUpdate);

        assertEquals(true, succ);


    }

    @Test
    public void doDelete() {

        int succ = categoriaDAO.doDelete(7);
        assertEquals(1, succ);

    }

    @Test
    public void doRetrieveByNome() {

        Categoria categoria = new Categoria();

        categoria = categoriaDAO.doRetrieveByNome("Ottone");
        assertEquals("Ottone", categoria.getNome());

    }

    @Test
    public void doRetrieveByDescrizione() {

        Categoria categoria = new Categoria();

        categoria = categoriaDAO.doRetrieveByDescrizione("Prodotti in Ottone");
        assertEquals("Prodotti in Ottone", categoria.getDescrizione());


    }
}