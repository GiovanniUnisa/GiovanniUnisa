package tsw.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdineDAO {


    public int doSave(String indirizzo, int idu, String prezzo) {

        Ordine ordine = new Ordine();

        try (Connection con = ConPool.getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO ordine (prezzo,indirizzo,idutente) VALUES(?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, prezzo);
            ps.setString(2, indirizzo);
            ps.setInt(3, idu);
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("Errone nella query di inserimento");
            }


            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            ordine.setId(id);

            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<Ordine> doRetrieveByUtente(int utente) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT id, prezzo, indirizzo FROM ordine WHERE idutente=? ");
            ps.setInt(1, utente);
            ArrayList<Ordine> ordini = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ordine o = new Ordine();
                o.setId(rs.getInt(1));
                o.setPrezzotot(rs.getString(2));
                o.setIndirizzo(rs.getString(3));
                ordini.add(o);
            }
            return ordini;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Utente> getUtenti(Connection con, int idOrdine) throws SQLException {
        PreparedStatement ps = con.prepareStatement(
                "SELECT id, username, passwordhash, nome, email, admin FROM utente LEFT JOIN utente_ordine ON id=idutente WHERE idordine=?");
        ps.setInt(1, idOrdine);
        ArrayList<Utente> utenti = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Utente p = new Utente();
            p.setId(rs.getInt(1));
            p.setUsername(rs.getString(2));
            p.setPasswordhash(rs.getString(3));
            p.setNome(rs.getString(4));
            p.setEmail(rs.getString(5));
            p.setAdmin(rs.getBoolean(6));
            utenti.add(p);
        }
        return utenti;
    }


}
