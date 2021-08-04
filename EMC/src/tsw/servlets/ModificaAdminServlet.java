package tsw.servlets;



import tsw.model.UtenteDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/ModificaServlet")
public class ModificaAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtenteDAO utenteDAO = new UtenteDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idstr = request.getParameter("id");
		int id = Integer.parseInt(idstr);

		String username = request.getParameter("username");
		if (!(username != null && username.length() >= 6 && username.matches("^[0-9a-zA-Z]+$"))) {
			throw new MyServletException("Username non valido.");
		}

		String nome = request.getParameter("nome");
		if (!(nome != null && nome.trim().length() > 0 && nome.matches("^[ a-zA-Z\u00C0-\u00ff]+$"))) {
			throw new MyServletException("Nome non valido.");
		}

		String email = request.getParameter("email");
		if (!(email != null && email.matches("^\\w+([\\.-]?\\w+)@\\w+([\\.-]?\\w+)(\\.\\w+)+$"))) {
			throw new MyServletException("Email non valida.");
		}


		utenteDAO.doUpdate(username,nome,email,id);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/modificaSuccesso.jsp");
		requestDispatcher.forward(request, response);
	}



}