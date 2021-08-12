package tsw.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class LoginDAO{

	public Login doRetrieveById(String id) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("SELECT id, idutente, token FROM login WHERE id=?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Login l = new Login();
				l.setId(rs.getString(1));
				l.setIdutente(rs.getInt(2));
				l.setToken(rs.getString(3));

				return l;
			}
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int doSave(Login login) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO login (id, idutente, token) VALUES(?, ?,?)", Statement.RETURN_GENERATED_KEYS);
			String id = UUID.randomUUID().toString();
			ps.setString(1, id);
			ps.setInt(2, login.getIdutente());
			ps.setString(3, login.getToken());
			if (ps.executeUpdate() != 1) {
				throw new RuntimeException("Errore nella query di inserimento");
			}
			login.setId(id);
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int doUpdate(Login login) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("UPDATE login SET idutente=?, token=? WHERE id=?");
			ps.setInt(1, login.getIdutente());
			ps.setString(2, login.getToken());
			ps.setString(3, login.getId());
			if (ps.executeUpdate() != 1) {
				throw new RuntimeException("UPDATE error.");
			}
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int doDelete(String id) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("DELETE FROM login WHERE id=?");
			ps.setString(1, id);
			if (ps.executeUpdate() != 1) {
				throw new RuntimeException("Errore nella query di cancellazione");
			}
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
