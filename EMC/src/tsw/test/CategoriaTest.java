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

        String intTest = categoria.toString();
        assertEquals(id, categoria.getId());
        assertEquals(nome, categoria.getNome());
        assertEquals(descrizione, categoria.getDescrizione());
        assertEquals(intTest, categoria.toString());


    }


}