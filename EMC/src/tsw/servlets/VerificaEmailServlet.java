package tsw.servlets;

import tsw.model.UtenteDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/VerificaEmail")
public class VerificaEmailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UtenteDAO utenteDAO = new UtenteDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        response.setContentType("text/xml");
        if (email != null && email.matches("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w+)+$") && utenteDAO.doRetrieveByEmail(email) == null) {
            response.getWriter().append("<ok/>");
        } else {
            response.getWriter().append("<no/>");
        }

    }


}
