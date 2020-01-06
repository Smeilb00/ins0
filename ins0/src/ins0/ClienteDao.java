package ins0;

import java.sql.*;
import java.time.Instant;
import java.util.Calendar;

public class ClienteDao {
	public ClienteVo getCliente(int iD) {
		ClienteVo retorno = new ClienteVo();
		return retorno;
	}
	
	public void iniciarPedido(Connection conn, String direccionEntrega, String articulos, String nombreCliente, String tipoPedido) {
		try {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO `pedidos` (`IDCliente`, `NumPedido`, `Fecha`, `DireccionEntrega`, `Articulos`, `Nombre Cliente`, `TipoPedido`, `Estado`) VALUES (?, NULL, ?, ?, ?, ?, ?, 'Pendiente')");
			stmt.setInt(1, VentanaLogin.getID());
			
			Calendar hoy = Calendar.getInstance();
			java.sql.Date fecha = new java.sql.Date(hoy.get(Calendar.YEAR)-1900, hoy.get(Calendar.MONTH), hoy.get(Calendar.DAY_OF_MONTH));
			
			
			stmt.setDate(2, fecha);
			stmt.setString(3, direccionEntrega);
			stmt.setString(4, articulos);
			stmt.setString(5, nombreCliente);
			stmt.setString(6, tipoPedido);

			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void eliminarPedido(Connection conn, int numPedido) {
		try {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM Pedido WHERE numpedido = ?");
			stmt.setInt(1, numPedido);
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
