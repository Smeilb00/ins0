package ins0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class TrabajadorDao {

	public TrabajadorVo getTrabajadorVo() {
		TrabajadorVo retorno = new TrabajadorVo();
		return retorno;
	}

	public void removeTrabajador(Connection conn, String DNI) {
		try {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM `Trabajador` WHERE `trabajador`.`DNI` = ?");
			stmt.setString(1, DNI);
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void modifyTrabajador(Connection conn, String Tipo, String Valor, String DNI) {
		if (Tipo.equals("Telefono")) {
			int telefono = Integer.parseInt(Valor);
			try {
				PreparedStatement stmt = conn.prepareStatement("UPDATE `Trabajador` SET ?=[?] WHERE DNI=?");
				stmt.setString(1, Tipo);
				stmt.setInt(2,  telefono);
				stmt.setString(3, DNI);
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			try {
				PreparedStatement stmt = conn.prepareStatement("UPDATE `Trabajador` SET ?=[?] WHERE DNI=?");
				stmt.setString(1, Tipo);
				stmt.setString(2,  Valor);
				stmt.setString(3, DNI);
				stmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void removeCliente(Connection conn, String DNI) {
		try {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM `Tlientes` WHERE `clientes`.`DNI` = ?");
			stmt.setString(1, DNI);
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void modifyCliente(Connection conn, String Tipo, String Valor, String DNI) {
		if (Tipo.equals("Telefono")) {
			int telefono = Integer.parseInt(Valor);
			try {
				PreparedStatement stmt = conn.prepareStatement("UPDATE `Clientes` SET ?=[?] WHERE DNI=?");
				stmt.setString(1, Tipo);
				stmt.setInt(2,  telefono);
				stmt.setString(3, DNI);
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(Tipo.equals("FechaNacimiento")) {
			/*
			 java.sql.Date fecha = new java.sql.Date(calendar.getDate().getTime());
		*/
			
		}else if(Tipo.equals("ID") || Tipo.equals("DNI")) {
			JOptionPane.showMessageDialog(null, "Este campo no se puede modificar.");
		}else {
			try {
				PreparedStatement stmt = conn.prepareStatement("UPDATE `Clientes` SET ?=[?] WHERE DNI=?");
				stmt.setString(1, Tipo);
				stmt.setString(2,  Valor);
				stmt.setString(3, DNI);
				stmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	

	public void addArticulo(Connection conn, String numeroSerie, String tipo, String subtipo, String marca, String date,
			int stock) {
		try {
			PreparedStatement stmt = conn.prepareStatement(
					"INSERT INTO `articulos` (`ID`, `NumeroSerie`, `Tipo`, `Subtipo`, `Marca`, `FechaLlegada`, `Stock`) VALUES (NULL, ?, ?, ?, ?, ?, ?)");
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

	public void modifyArticulo(Connection conn, String Tipo, String Valor, String ID) {
		if (Tipo.equals("Stock")) {
			int stock = Integer.parseInt(Valor);
			try {
				PreparedStatement stmt = conn.prepareStatement("UPDATE `Trabajador` SET ?=[?] WHERE ID=?");
				stmt.setString(1, Tipo);
				stmt.setInt(2,  stock);
				stmt.setString(3, ID);
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			try {
				PreparedStatement stmt = conn.prepareStatement("UPDATE `Trabajador` SET ?=[?] WHERE ID=?");
				stmt.setString(1, Tipo);
				stmt.setString(2,  Valor);
				stmt.setString(3, ID);
				stmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void gestionarAlmacen() {

	}

	public void solicitarReparacion(String DNI) {

	}
}
