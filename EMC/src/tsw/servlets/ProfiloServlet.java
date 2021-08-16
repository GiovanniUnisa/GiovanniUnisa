package tsw.servlets;


import tsw.model.Utente;
import tsw.model.UtenteDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/Profilo")
public class ProfiloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UtenteDAO utenteDAO = new UtenteDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Utente utente=new Utente();
        utente = utenteDAO.doRetrieveById(id);

        request.setAttribute("utente", utente);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/informazioniUtente.jsp");
        requestDispatcher.forward(request, response);

    }


}
