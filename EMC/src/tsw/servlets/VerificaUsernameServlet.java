package tsw.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tsw.model.UtenteDAO;

@WebServlet("/VerificaUsername")
public class VerificaUsernameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final UtenteDAO utenteDAO = new UtenteDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		response.setContentType("text/xml");
		if (username != null && username.length() >= 6 && username.matches("^[0-9a-zA-Z]+$")
				&& utenteDAO.doRetrieveByUsername(username) == null) {
			response.getWriter().append("<ok/>");
		} else {
			response.getWriter().append("<no/>");
		}

	}



}
