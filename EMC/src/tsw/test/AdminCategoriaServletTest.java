package tsw.test;


import static org.junit.jupiter.api.Assertions.*;

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
import tsw.model.Utente;
import tsw.servlets.AdminCategoriaServlet;

import javax.servlet.ServletException;
import java.io.IOException;

class AdminCategoriaServletTest extends Mockito {


    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    @Mock
    private CategoriaDAO dao;
    @InjectMocks
    private AdminCategoriaServlet servlet;
    private Categoria categoria = new Categoria(10, "Categoria1", "Descrizione1");


    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }


    @Test
    void TC_AggiuntaCategoria_1() throws ServletException, IOException {


        request.addParameter("nome", "Pluto");
        request.addParameter("descrizione", "Descrizione");


        String message = "L'aggiunta della categoria non va a buon fine poiché il campo nome è vuoto";
        servlet.doPost(request, response);
        String result = (String) request.getAttribute("notifica");
        assertEquals(message, result);
    }


}