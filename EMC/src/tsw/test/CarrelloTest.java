package tsw.test;

import org.junit.jupiter.api.Test;
import tsw.model.Carrello;
import tsw.model.Prodotto;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarrelloTest {

    @Test
    void testCarrelloBean() {


        int quantita = 2;
        Prodotto prodotto = new Prodotto(10, "Prova", "Desc", 20, 22, 1);

        Carrello.ProdottoQuantita prodottoQuantita = new Carrello.ProdottoQuantita(prodotto, quantita);
        String test = prodottoQuantita.getProdotto().toString();

        assertEquals(10, prodottoQuantita.getProdotto().getId());
        assertEquals("Prova", prodottoQuantita.getProdotto().getNome());
        assertEquals("Desc", prodottoQuantita.getProdotto().getDescrizione());
        assertEquals(20, prodottoQuantita.getProdotto().getPrezzoBase());
        assertEquals(22, prodottoQuantita.getProdotto().getIva());
        assertEquals(1, prodottoQuantita.getProdotto().getIdcategoria());
        assertEquals(test, prodottoQuantita.getProdotto().toString());

    }


}