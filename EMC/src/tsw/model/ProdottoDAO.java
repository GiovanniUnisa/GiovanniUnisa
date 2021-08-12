package tsw.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProdottoDAO {


    public List<Prodotto> doRetrieveAll() {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con
                    .prepareStatement("SELECT id, nome, descrizione, prezzoBase,iva, idcategoria FROM prodotto ");

            ArrayList<Prodotto> prodotti = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Prodotto p = new Prodotto();
                p.setId(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setDescrizione(rs.getString(3));
                p.setPrezzoBase(rs.getLong(4));
                p.setIva(rs.getInt(5));
                p.setIdcategoria(rs.getInt(6));
                prodotti.add(p);
            }
            return prodotti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Prodotto doRetrieveById(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con
                    .prepareStatement("SELECT id, nome, descrizione, prezzoBase,iva,idcategoria FROM prodotto WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Prodotto p = new Prodotto();
                p.setId(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setDescrizione(rs.getString(3));
                p.setPrezzoBase(rs.getLong(4));
                p.setIva(rs.getInt(5));
                p.setIdcategoria(rs.getInt(6));
                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Prodotto> doRetrieveByCategoria(int categoria) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT id, nome, descrizione, prezzoBase, iva, idcategoria FROM prodotto  WHERE idcategoria=? ");
            ps.setInt(1, categoria);

            ArrayList<Prodotto> prodotti = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Prodotto p = new Prodotto();
                p.setId(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setDescrizione(rs.getString(3));
                p.setPrezzoBase(rs.getLong(4));
                p.setIva(rs.getInt(5));
                p.setIdcategoria(rs.getInt(6));
                prodotti.add(p);
            }
            return prodotti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int doSave(Prodotto prodotto) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO prodotto (nome, descrizione, prezzoBase,iva,idcategoria) VALUES(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, prodotto.getNome());
            ps.setString(2, prodotto.getDescrizione());
            ps.setLong(3, prodotto.getPrezzoBase());
            ps.setInt(4, prodotto.getIva());
            ps.setInt(5, prodotto.getIdcategoria());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            prodotto.setId(id);


            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int doSaveModifica(Prodotto prodotto) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO prodotto (nome, descrizione, prezzoBase,iva,idcategoria) VALUES(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, prodotto.getNome());
            ps.setString(2, prodotto.getDescrizione());
            ps.setLong(3, prodotto.getPrezzoBase());
            ps.setInt(4, prodotto.getIva());
            ps.setInt(5, prodotto.getIdcategoria());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            prodotto.setId(id);


            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }






    public boolean doUpdate(Prodotto prodotto) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con
                    .prepareStatement("UPDATE prodotto SET nome=?, descrizione=?, prezzoBase=?, iva=?,idcategoria=? WHERE id=?");
            ps.setString(1, prodotto.getNome());
            ps.setString(2, prodotto.getDescrizione());
            ps.setLong(3, prodotto.getPrezzoBase());
            ps.setInt(4, prodotto.getIva());
            ps.setInt(5, prodotto.getId());
            ps.setInt(6, prodotto.getIdcategoria());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("UPDATE error.");
            }


            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public int doDelete(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM prodotto WHERE id=?");
            ps.setInt(1, id);
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("DELETE error.");
            }
            return 1;
        } catch (SQLException e) {
            return 0;
        }
    }

    public List<Prodotto> doRetrieveByNome(String against) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT id, nome, descrizione, prezzoBase,iva, idcategoria FROM prodotto WHERE MATCH(nome) AGAINST(? IN BOOLEAN MODE)");
            ps.setString(1, against);
            ArrayList<Prodotto> prodotti = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Prodotto p = new Prodotto();
                p.setId(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setDescrizione(rs.getString(3));
                p.setPrezzoBase(rs.getLong(4));
                p.setIva(rs.getInt(5));
                p.setIdcategoria(rs.getInt(6));

                prodotti.add(p);
            }
            return prodotti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Prodotto doRetrieveByNomeSingolo(String nome) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT id, nome, descrizione, prezzoBase,iva, idcategoria FROM prodotto WHERE nome =?");
            ps.setString(1, nome);
            Prodotto prodotto;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Prodotto p = new Prodotto();
                p.setId(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setDescrizione(rs.getString(3));
                p.setPrezzoBase(rs.getLong(4));
                p.setIva(rs.getInt(5));
                p.setIdcategoria(rs.getInt(6));

                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Prodotto doRetrieveByDescrizione(String descrizione) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT descrizione FROM prodotto WHERE descrizione =?");
            ps.setString(1, descrizione);
            Prodotto prodotto;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Prodotto p = new Prodotto();
                p.setDescrizione(rs.getString(1));
                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Prodotto doRetrieveByPrezzo(long prezzo) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT prezzoBase FROM prodotto WHERE prezzoBase =?");
            ps.setLong(1, prezzo);
            Prodotto prodotto;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Prodotto p = new Prodotto();
                p.setPrezzoBase(rs.getLong(1));
                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Prodotto doRetrieveByIva(int iva) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT iva FROM prodotto WHERE iva =?");
            ps.setInt(1, iva);
            Prodotto prodotto;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Prodotto p = new Prodotto();
                p.setIva(rs.getInt(1));
                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Prodotto> doRetrieveByNomeOrDescrizione(String against) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT id, nome, descrizione, prezzoBase, iva, idcategoria FROM prodotto WHERE MATCH(nome, descrizione) AGAINST(?)");
            ps.setString(1, against);
            ArrayList<Prodotto> prodotti = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Prodotto p = new Prodotto();
                p.setId(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setDescrizione(rs.getString(3));
                p.setPrezzoBase(rs.getLong(4));
                p.setIva(rs.getInt(5));
                p.setIdcategoria(rs.getInt(6));
                prodotti.add(p);
            }
            return prodotti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
