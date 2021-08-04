package tsw.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tsw.model.Prodotto;
import tsw.model.ProdottoDAO;

@WebServlet("/Ricerca")
public class RicercaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ProdottoDAO prodottoDAO = new ProdottoDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Prodotto> prodotti = prodottoDAO.doRetrieveByNomeOrDescrizione(request.getParameter("ric"));
		request.setAttribute("prodotti", prodotti);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/ricerca.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
