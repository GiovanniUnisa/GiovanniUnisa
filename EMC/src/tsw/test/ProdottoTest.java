package tsw.test;

import org.junit.jupiter.api.Test;
import tsw.model.Categoria;
import tsw.model.Ordine;
import tsw.model.Prodotto;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProdottoTest {

    private int id;
    private String nome;
    private String descrizione;
    private long prezzoBase;
    private int iva;
    private List<Categoria> categorie;
    private Categoria Rame = new Categoria();


    @Test
    void testProdotto() {

        int id = 1;
        String nome = "Indirizzo";
        String descrizione = "token";
        long prezzoBase = 2000;
        int iva = 22;
        int idcategoria = 1;


        Prodotto prodotto = new Prodotto(id, nome, descrizione, prezzoBase, iva, idcategoria);
        Prodotto prodotto1 = new Prodotto(id, nome, descrizione, prezzoBase, iva, idcategoria);
        String test = prodotto.toString();
        String test1 = prodotto1.toString();


        assertEquals(id, prodotto.getId());
        assertEquals(nome, prodotto.getNome());
        assertEquals(descrizione, prodotto.getDescrizione());
        assertEquals(prezzoBase, prodotto.getPrezzoBase());
        assertEquals(iva, prodotto.getIva());
        assertEquals(idcategoria, prodotto.getIdcategoria());
        assertEquals(test, prodotto.toString());

        prodotto1.setId(id);
        prodotto1.setDescrizione(descrizione);
        prodotto1.setPrezzoBase(prezzoBase);
        prodotto1.setIdcategoria(id);
        prodotto1.setNome(nome);
        prodotto1.setIva(iva);
        assertEquals(id, prodotto1.getId());
        assertEquals(nome, prodotto1.getNome());
        assertEquals(descrizione, prodotto1.getDescrizione());
        assertEquals(prezzoBase, prodotto1.getPrezzoBase());
        assertEquals(iva, prodotto1.getIva());
        assertEquals(idcategoria, prodotto1.getIdcategoria());
        assertEquals(test1, prodotto1.toString());

    }


}