package tsw.test;

import org.junit.jupiter.api.Test;
import tsw.model.Categoria;

import static org.junit.jupiter.api.Assertions.*;

class CategoriaTest {

    @Test
    void testCategoriaBean() {



        int id = 1;
        String nome = "Gina";
        String descrizione = "La gallina";

        Categoria categoria = new Categoria(id, nome, descrizione);
        Categoria categoria1 = new Categoria(id, nome, descrizione);
        String test = categoria.toString();
        String test1 = categoria1.toString();


        assertEquals(id, categoria.getId());
        assertEquals(nome, categoria.getNome());
        assertEquals(descrizione, categoria.getDescrizione());
        assertEquals(test, categoria.toString());

        categoria1.setId(id);
        categoria1.setNome(nome);
        categoria1.setDescrizione(descrizione);
        assertEquals(nome, categoria1.getNome());
        assertEquals(descrizione, categoria1.getDescrizione());
        assertEquals(test1, categoria1.toString());




    }


}