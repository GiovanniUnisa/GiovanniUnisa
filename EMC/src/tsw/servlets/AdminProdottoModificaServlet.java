package tsw.servlets;

import tsw.model.Categoria;
import tsw.model.CategoriaDAO;
import tsw.model.Prodotto;
import tsw.model.ProdottoDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Function;
import java.util.stream.Collectors;


@WebServlet("/AdminProdottoModifica")
public class AdminProdottoModificaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final ProdottoDAO prodottoDAO = new ProdottoDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MyServletException.checkAdmin(request);
        Prodotto prodotto;
        String idstr = request.getParameter("id");

        if (idstr != null) {

            if (request.getParameter("rimuovi") != null) {
                prodottoDAO.doDelete(Integer.parseInt(idstr));
                request.setAttribute("notifica", "Prodotto rimosso con successo.");
            } else { // modifica


                idstr = request.getParameter("id");

                String rb = request.getParameter("categorie");
                String nome = request.getParameter("nome");
                String descrizione = request.getParameter("descrizione");
                String prezzoCent = request.getParameter("prezzoCent");
                String iv = request.getParameter("iva");


                if (nome != null && descrizione != null && prezzoCent != null && iv != null) {

                    if (rb == null) {
                        throw new MyServletException("Non hai selezionato alcuna categoria! Riprova.");
                    }

                    if (!(nome != null && nome.trim().length() > 0)) {
                        throw new MyServletException("Non hai selezionato alcun nome! Riprova.");
                    }

                    if (!(descrizione != null && descrizione.trim().length() > 0)) {
                        throw new MyServletException("Non hai selezionato alcuna descrizione! Riprova.");
                    }
                    if (!(prezzoCent != null && prezzoCent.trim().length() > 0)) {
                        throw new MyServletException("Non hai selezionato alcun prezzo! Riprova.");
                    }
                    if (!(iv != null && iv.trim().length() > 0)) {
                        throw new MyServletException("Non hai selezionato alcun iva! Riprova.");
                    }


                    //modifica prodotto
                    prodotto = new Prodotto();
                    prodotto.setNome(nome);
                    prodotto.setDescrizione(descrizione);
                    prodotto.setPrezzoBase(Long.parseLong(prezzoCent));
                    prodotto.setIva(Integer.parseInt(iv));
                    prodotto.setIdcategoria(Integer.parseInt(rb));
                    if ((prodottoDAO.doRetrieveByNomeSingolo(nome) != null) && (prodottoDAO.doRetrieveByDescrizione(descrizione) != null)
                            && (prodottoDAO.doRetrieveByPrezzo(Long.parseLong(prezzoCent)) != null) && (prodottoDAO.doRetrieveByIva(Integer.parseInt(iv)) != null)) {
                        throw new MyServletException("Non hai modificato alcun parametro! Riprova");
                    }


                    prodottoDAO.doSaveModifica(prodotto);
                    prodottoDAO.doDelete(Integer.parseInt(idstr));


                    prodotto.setId(Integer.parseInt(idstr));
                    prodottoDAO.doUpdate(prodotto);
                    request.setAttribute("notifica", "Il prodotto è stato modificato con successo.");
                }
            }

        }
        int id = Integer.parseInt(idstr);
        request.setAttribute("id", id);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/adminProdottoModifica.jsp");
        requestDispatcher.forward(request, response);
    }


}

