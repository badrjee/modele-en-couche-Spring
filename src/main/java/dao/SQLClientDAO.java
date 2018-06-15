package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Client;

public class SQLClientDAO extends AbstractDAO implements ClientDAO {

	@Override
	public void save(Client c) {
		Connection cn = null;
		PreparedStatement st = null;
		// initialisation du result set
		try {
			cn = getConnectionDM();

			String sql = "INSERT INTO client(nom) VALUES (?)";

			st = cn.prepareStatement(sql);

			st.setString(1, c.getName());

			st.executeUpdate();
			cn.commit();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(cn, st, null);
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Client findById(int id) {
		Connection cn = null;
		PreparedStatement st = null;
		// initialisation du result set
		ResultSet rs = null;
		Client cl = new Client();

		try {
			cn = getConnectionDM();

			String sql = "SELECT * FROM client WHERE id =" + id;

			st = cn.prepareStatement(sql);

			rs = st.executeQuery();

			// NE PAS OUBLIER car la connection �tablie d�sactive le
			// le commit automatique
			cn.commit();

			while (rs.next()) {
				cl.setName(rs.getString(2));
				cl.setId(rs.getInt(1));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			close(cn, st, rs);
		}

		return cl;
	}

	@Override
	public List<Client> findAll() {
		// nouvelle liste pour r�sultats
		List<Client> results = new ArrayList<>();
		Connection cn = null;
		PreparedStatement st = null;
		// initialisation du result set
		ResultSet rs = null;

		try {
			cn = getConnectionDM();

			String sql = "SELECT * FROM client";

			st = cn.prepareStatement(sql);

			rs = st.executeQuery();

			// NE PAS OUBLIER car la connection �tablie d�sactive le
			// le commit automatique
			cn.commit();

			while (rs.next()) {
				Client cl = new Client();
				cl.setName(rs.getString(2));
				cl.setId(rs.getInt(1));
				results.add(cl);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			close(cn, st, rs);
		}

		return results;
	}

}
