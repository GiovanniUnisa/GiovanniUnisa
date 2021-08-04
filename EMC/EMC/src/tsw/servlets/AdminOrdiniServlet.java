package tsw.servlets;

import org.apache.taglibs.standard.tag.common.core.UrlSupport;
import tsw.model.CategoriaDAO;
import tsw.model.Utente;
import tsw.model.UtenteDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/AdminOrdini")

public class AdminOrdiniServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final UtenteDAO utenteDAO=new UtenteDAO();
    private final Utente utente=new Utente();


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        int id = utente.getId();
        Utente utente = utenteDAO.doRetrieveById(id);

        if (utente == null) {
            throw new MyServletException("utente non trovato.");
        }
        request.setAttribute("utente", utente);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/informazioniutente.jsp");
        requestDispatcher.forward(request, response);

    }


}
