package tsw.servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tsw.model.Categoria;
import tsw.model.Prodotto;
import tsw.model.ProdottoDAO;


@WebServlet("/AdminProdotto")
public class AdminProdottoServlet extends HttpServlet {
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
            } else {

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


                    // modifica/aggiunta prodotto
                    prodotto = new Prodotto();
                    prodotto.setNome(nome);
                    prodotto.setDescrizione(descrizione);
                    prodotto.setPrezzoBase(Long.parseLong(prezzoCent));
                    prodotto.setIva(Integer.parseInt(iv));

                    String[] categorie = request.getParameterValues("categorie");
                    prodotto.setCategorie(categorie != null ? Arrays.stream(categorie).map(id -> {
                        Categoria c = new Categoria();
                        c.setId(Integer.parseInt(id));
                        return c;
                    }).collect(Collectors.toList()) : Collections.emptyList());

                    if (idstr.isEmpty()) { // aggiunta nuovo prodotto




                        if (prodottoDAO.doRetrieveByNomeSingolo(nome) != null) {
                            throw new MyServletException("Il prodotto che vuoi aggiungere è gia presente! Riprova.");
                        }

                        prodottoDAO.doSave(prodotto);
                        request.setAttribute("notifica", "Il prodotto è stato aggiunto con successo.");

                    }
                }
            }
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/adminprodotto.jsp");
        requestDispatcher.forward(request, response);
    }


}

