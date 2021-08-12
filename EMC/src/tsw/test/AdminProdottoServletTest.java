package tsw.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import tsw.model.Categoria;
import tsw.model.CategoriaDAO;
import tsw.model.Prodotto;
import tsw.servlets.AdminCategoriaServlet;
import tsw.servlets.AdminProdottoServlet;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdminProdottoServletTest {

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    List<Categoria> categorie = new ArrayList<>();


    @Mock
    private CategoriaDAO dao;
    @InjectMocks
    private AdminProdottoServlet servlet;
    private Prodotto prodotto = new Prodotto(1, "Categoria1", "Descrione1", 10, 22, 2);


    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }


    @Test
    void TC_AggiuntaProdotto_1() throws ServletException, IOException {

        request.addParameter("id", String.valueOf(1));
        request.addParameter("categorie", "Bronzo");
        request.addParameter("nome", "Pippo");
        request.addParameter("descrizione", "Descrizione");
        request.addParameter("prezzoCent", String.valueOf(2222));
        request.addParameter("iva", String.valueOf(22));


        String message = "Il prodotto è stato aggiunto con successo.";

        System.out.println(request.getAttribute("notifica"));
        String result = (String) request.getAttribute("notifica");
        assertEquals(message, result);
    }


}