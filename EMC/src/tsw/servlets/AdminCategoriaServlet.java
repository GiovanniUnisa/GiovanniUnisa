package tsw.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tsw.model.Categoria;
import tsw.model.CategoriaDAO;


@WebServlet("/AdminCategoria")

public class AdminCategoriaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CategoriaDAO categoriaDAO = new CategoriaDAO();


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MyServletException.checkAdmin(request);

        String idstr = request.getParameter("id");
        if (idstr != null) {

            List<Categoria> categorie = ((List<Categoria>) getServletContext().getAttribute("categorie"));

            Categoria categoria = null;
            if (!idstr.isEmpty()) {
                int id = Integer.parseInt(idstr);
                categoria = categorie.stream().filter(c -> c.getId() == id).findAny().get();/* Categoria con quell'id */
            }

            if (request.getParameter("rimuovi") != null) {
                categoriaDAO.doDelete(categoria.getId());
                categorie.remove(categoria);
                request.setAttribute("notifica", "La categoria è stata rimossa con successo.");
            } else {

                String nome = request.getParameter("nome");
                String descrizione = request.getParameter("descrizione");

                if (nome != null && descrizione != null) { // modifica/aggiunta categoria

                    if (!(nome != null && nome.trim().length() > 0)) {
                        throw new MyServletException("Non hai inserito alcun nome! Riprova.");
                    }

                    if (!(descrizione != null && descrizione.trim().length() > 0)) {
                        throw new MyServletException("Non hai inserito alcuna descrizione! Riprova.");
                    }

                    if (categoria == null) { // aggiunta nuova categoria
                        categoria = new Categoria();
                        categoria.setNome(nome);
                        categoria.setDescrizione(descrizione);

                        if ((categoriaDAO.doRetrieveByNome(nome) != null)) {
                            throw new MyServletException("La categoria che vuoi inserire è gia presente! Riprova");
                        }

                        categoriaDAO.doSave(categoria);
                        categorie.add(categoria);
                        request.setAttribute("notifica", "La categoria è stata aggiunta con successo.");
                    } else { // modifica categoria esistente

                        if ((categoriaDAO.doRetrieveByNome(nome) != null) && (categoriaDAO.doRetrieveByDescrizione(descrizione) != null)) {
                            throw new MyServletException("Non hai modificato alcun parametro! Riprova");
                        }

                        categoria.setNome(nome);
                        categoria.setDescrizione(descrizione);

                        categoriaDAO.doUpdate(categoria);
                        request.setAttribute("notifica", "La categoria è stata modificata con successo.");
                    }
                }

                request.setAttribute("categoria", categoria);

            }
        }


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/admincategoria.jsp");
        requestDispatcher.forward(request, response);
    }


}

