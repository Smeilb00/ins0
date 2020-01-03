package ins0;

import java.sql.*;

public class DataConnection {

	public Connection DataConn() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://77.27.115.50:50001/ins0?useSSL=false", "ins0", "");
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void selectData(Connection conn) {

		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM articulos");
			ResultSet rs = stmt.executeQuery();
			int count = 0;
			while (rs.next()) {
				count++;
				System.out.println("Articulo " + count + ": " + rs.getString("Tipo"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void comprobarUsuario(Connection conn, String usuario, String password) {
		try {
			PreparedStatement stmt = conn
					.prepareStatement("SELECT DNI,Contrasenha FROM `clientes` where DNI=? and Contrasenha=?");
			stmt.setString(1, usuario);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				if (usuario.equals(rs.getString(1)) && password.equals(rs.getString(2))) {
					ins0.setConectado("Cliente");
				}
			} else {
				PreparedStatement stmt2 = conn
						.prepareStatement("SELECT DNI,Contrasenha,Posicion FROM trabajador WHERE DNI = ? and Contrasenha = ?");
				stmt2.setString(1, usuario);
				stmt2.setString(2, password);

				rs = stmt2.executeQuery();
				if (rs.next()) {
					if (usuario.equals(rs.getString(1)) && password.equals(rs.getString(2))) {
						ins0.setConectado(rs.getString(3));
					}
				}
			}
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
