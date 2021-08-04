package tsw.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CategoriaDAO {

    public List<Categoria> doRetrieveAll() {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT id, nome, descrizione FROM categoria");
            ArrayList<Categoria> categorie = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Categoria c = new Categoria();
                c.setId(rs.getInt(1));
                c.setNome(rs.getString(2));
                c.setDescrizione(rs.getString(3));
                categorie.add(c);
            }
            return categorie;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSave(Categoria categoria) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO categoria (nome, descrizione) VALUES(?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, categoria.getNome());
            ps.setString(2, categoria.getDescrizione());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("Errore nella query di inserimento");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            categoria.setId(rs.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doUpdate(Categoria categoria) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE categoria SET nome=?, descrizione=? WHERE id=?");
            ps.setString(1, categoria.getNome());
            ps.setString(2, categoria.getDescrizione());
            ps.setInt(3, categoria.getId());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("Errore nella query di modifica");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doDelete(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM categoria WHERE id=?");
            ps.setInt(1, id);
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("Errore nella query di cancellazione");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Categoria doRetrieveByNome(String nome) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT nome FROM categoria WHERE nome=?");
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Categoria c = new Categoria();
                c.setNome(rs.getString(1));

                return c;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Categoria doRetrieveByDescrizione(String descrizione) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT descrizione FROM categoria WHERE descrizione=?");
            ps.setString(1, descrizione);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Categoria c = new Categoria();
                c.setDescrizione(rs.getString(1));

                return c;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}