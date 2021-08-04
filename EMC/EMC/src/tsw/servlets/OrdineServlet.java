package tsw.servlets;

import tsw.model.Ordine;
import tsw.model.OrdineDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Ordine")
public class OrdineServlet extends HttpServlet {

    OrdineDAO ordineDAO=new OrdineDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("utente") == null) {
            throw new MyServletException("Utente non loggato.");
        }
        else {
            int id = Integer.parseInt(request.getParameter(("id")));
            String prezzo = request.getParameter("prezzo");
            String indirizzo = request.getParameter("indirizzo");


            if (!(indirizzo.trim().length() > 0)) {
                throw new MyServletException("Non hai specificato un indirizzo! Riprova.");
            }

            ordineDAO.doSave(indirizzo, id, prezzo);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/verificaOrdine.jsp");
        requestDispatcher.forward(request, response);


    }
}
