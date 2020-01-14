package ins0;

import java.sql.*;

public class DataConnection {

	public Connection DataConn() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://83.32.59.1:50001/ins0?useSSL=false", "ins0", "");
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
					.prepareStatement("SELECT DNI,Contrasenha,ID FROM `clientes` where DNI=? and Contrasenha=?");
			stmt.setString(1, usuario);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				if (usuario.equals(rs.getString(1)) && password.equals(rs.getString(2))) {
					VentanaLogin.setConectado("Cliente");
					VentanaLogin.setID(rs.getInt(3));
				}
			} else {
				PreparedStatement stmt2 = conn.prepareStatement(
						"SELECT DNI,Contrasenha,Posicion,ID FROM trabajador WHERE DNI = ? and Contrasenha = ?");
				stmt2.setString(1, usuario);
				stmt2.setString(2, password);

				rs = stmt2.executeQuery();
				if (rs.next()) {
					if (usuario.equals(rs.getString(1)) && password.equals(rs.getString(2))) {
						VentanaLogin.setConectado(rs.getString(3));
						VentanaLogin.setID(rs.getInt(4));
					}
				}
			}
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void getEstadoPedido(Connection conn, int iD, VentanaEstadoPedidos v7) {
		try {
			ResultSet rs;

			if (VentanaLogin.getConectado().equals("Cliente")) {
				PreparedStatement stmt = conn
						.prepareStatement("SELECT NumPedido,Estado FROM pedidos WHERE IDCliente=?");
				stmt.setInt(1, VentanaLogin.getID());
				rs = stmt.executeQuery();

			} else {
				PreparedStatement stmt = conn
						.prepareStatement("SELECT NumPedido,Estado FROM pedidos WHERE IDTrabajador=?");
				stmt.setInt(1, VentanaLogin.getID());
				rs = stmt.executeQuery();
			}
			String[] titulos = new String[2];

			titulos[0] = "Numero de pedido";
			titulos[1] = "Estado del pedido";
			v7.getModelo().addRow(titulos);
			
			while (rs.next()) {
				String numPedido = rs.getString(1);
				String estado = rs.getString(2);

				String[] filas = new String[2];
				filas[0] = numPedido;
				filas[1] = estado;

				v7.getModelo().addRow(filas);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void aceptarPedidos(Connection conn) {
        PreparedStatement stmt;
        PreparedStatement stmt3;
        PreparedStatement stmt4;
        PreparedStatement stmt5;
        PreparedStatement stmt6;
        ResultSet rs3;
        ResultSet rs5;
        try {
            stmt = conn.prepareStatement("SELECT NumPedido, Articulos FROM pedidos WHERE Estado = ? ");
            stmt.setString(1, "Pendiente");
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                String[] articulos;
                articulos = (rs.getString(2).split(","));
                boolean aceptar = true;
                for(int i = 0; i<articulos.length;i++) {
                    stmt3 = conn.prepareStatement("SELECT Stock FROM articulos WHERE ID = ?");
                    stmt3.setInt(1, Integer.parseInt(articulos[i]));
                    rs3 = stmt3.executeQuery();

                    if(rs3.next() && rs3.getInt(1)<=4) {
                        aceptar=false;
                    }

                }
                if(aceptar) {
                    stmt4 = conn.prepareStatement("UPDATE pedidos SET estado=?, IDTrabajador=? WHERE Estado='Pendiente'");
                    stmt4.setString(1, "Aceptado");
                    stmt4.setInt(2,VentanaLogin.getID());
                    stmt4.executeUpdate();
                    stmt4.close();
                    
                    for(int i = 0; i<articulos.length;i++) {
                    	 stmt5 = conn.prepareStatement("SELECT Stock FROM articulos WHERE ID = ?");
                         stmt5.setInt(1, Integer.parseInt(articulos[i]));
                         rs5 = stmt5.executeQuery();
                         while(rs5.next()) {
                        	 stmt6 = conn.prepareStatement("UPDATE articulos SET Stock=? WHERE ID=?");
                        	 stmt6.setInt(1,rs5.getInt(1)-1);
                        	 stmt6.setInt(2, Integer.parseInt(articulos[i]));
                        	 stmt6.executeUpdate();
                         }


                    }
                }
            }



        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
}
