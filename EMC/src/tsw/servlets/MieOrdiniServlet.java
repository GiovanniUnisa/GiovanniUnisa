package tsw.servlets;

import tsw.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/MieiOrdini")
public class MieOrdiniServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final OrdineDAO ordineDAO = new OrdineDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        int id = Integer.parseInt(request.getParameter("id"));

        List<Ordine> ordini = ordineDAO.doRetrieveByUtente(id);
        request.setAttribute("ordini", ordini);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/ordini.jsp");
        requestDispatcher.forward(request, response);
    }


}
