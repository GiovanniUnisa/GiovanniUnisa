package tsw.servlets;

import tsw.model.ProdottoDAO;
import tsw.model.Utente;
import tsw.model.UtenteDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ModificaForm")
public class ModificaServlet extends HttpServlet {


    UtenteDAO utenteDAO = new UtenteDAO();


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idstr = request.getParameter("id");
        int id = Integer.parseInt(idstr);

        String admin = request.getParameter("admin");
        boolean b = Boolean.parseBoolean(admin);
        System.out.println(b);


        if (request.getParameter("val") == null) {
            if (admin.equals("false")) {
                utenteDAO.doDelete(id);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/rimuovi.jsp");
                requestDispatcher.forward(request, response);
            } else {
                request.setAttribute("notifica", "Non puoi rimuovere un admin");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/rimuoviAdminNotValid.jsp");
                requestDispatcher.forward(request, response);
            }

        } else {
            request.setAttribute("id", id);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/modifica.jsp");
            requestDispatcher.forward(request, response);

        }
    }


}
