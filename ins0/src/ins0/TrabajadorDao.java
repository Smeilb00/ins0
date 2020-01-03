package ins0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TrabajadorDao {
	
	public TrabajadorVo getTrabajadorVo() {
		TrabajadorVo retorno = new TrabajadorVo();
		return retorno;
	}
	
	public void addTrabajador(TrabajadorVo trabajador) {
		
	}
	public void removeTrabajador (String DNI) {
		
	}
	public void modifyTrabajador(String DNI) {
		
	}
	public void addCliente(ClienteVo cliente) {
		
	}
	public void removeCliente (String DNI) {
		
	}
	public void modifyCliente(String DNI) {
		
	}
	public void addArticulo(Connection conn, String numeroSerie, String tipo, String subtipo, String marca, String date, int stock) {
		try {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO `articulos` (`ID`, `NumeroSerie`, `Tipo`, `Subtipo`, `Marca`, `FechaLlegada`, `Stock`) VALUES (NULL, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, numeroSerie);
			stmt.setString(2, tipo);
			stmt.setString(3, subtipo);
			stmt.setString(4, marca);
			stmt.setString(5, date);
			stmt.setInt(6, stock);
						
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void removeArticulo(Connection conn, int iD) {
		try {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM `articulos` WHERE `articulos`.`ID` = ?");
			stmt.setInt(1, iD);		
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void modifyArticulo(String DNI) {
		
	}
	public void gestionarAlmacen() {
		
	}
	public void solicitarReparacion(String DNI) {
		
	}
}
