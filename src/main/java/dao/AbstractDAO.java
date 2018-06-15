package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractDAO {

//	@Resource(name="dataSource")
//	private DataSource ds;

	protected void close(Connection cn, PreparedStatement st, ResultSet rs) {
		try {
			if (rs != null) rs.close();
		} catch (SQLException e) {}			
		try {
			if (st != null) st.close();
		} catch (SQLException e) {}			
		try {
			if (cn != null) cn.close();
		} catch (SQLException e) {}
	}
	
//	protected Connection getConnection() throws ClassNotFoundException, SQLException, NamingException {
//	return ds.getConnection();
//	//return getConnectionDS();
//	//return getConnectionDM();
//}

//private Connection getConnectionDS() throws NamingException, SQLException {
//	Context ctx = new InitialContext();
//	
//	DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/EShopDS");
//	return ds.getConnection();
//}
//
	protected Connection getConnectionDM() throws ClassNotFoundException, SQLException {
		Connection cn;
		// établir la connexion
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/coucheV2";
		String username = "root";
		String password = "";
		
		cn = DriverManager.getConnection(url, username, password);
		cn.setAutoCommit(false);
		return cn;
	}
}
