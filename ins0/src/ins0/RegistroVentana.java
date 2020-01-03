package ins0;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.border.*;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.awt.event.ActionEvent;

public class RegistroVentana extends JFrame {
	private JPanel Principal;
	private JTextField txtNombre;
	private JTextField txtDNI;
	private JTextField txtDireccion;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JPasswordField txtContrasenha;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public RegistroVentana() {
		setTitle("Registro de Usuarios");
		setBounds(100, 100, 851, 536);
		Principal = new JPanel();
		Principal.setBackground(Color.LIGHT_GRAY);
		Principal.setBorder(new EmptyBorder(5, 5, 5, 5));
		Principal.setLayout(new BorderLayout(0, 0));
		setContentPane(Principal);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		Principal.add(desktopPane, BorderLayout.CENTER);

		JRadioButton rdbtnCliente = new JRadioButton("Cliente");
		buttonGroup.add(rdbtnCliente);
		rdbtnCliente.setBackground(Color.LIGHT_GRAY);
		rdbtnCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnCliente.setBounds(181, 38, 109, 23);
		desktopPane.add(rdbtnCliente);

		JRadioButton rdbtnTrabajador = new JRadioButton("Trabajador");
		buttonGroup.add(rdbtnTrabajador);
		rdbtnTrabajador.setBackground(Color.LIGHT_GRAY);
		rdbtnTrabajador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnTrabajador.setBounds(292, 38, 109, 23);
		desktopPane.add(rdbtnTrabajador);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipo.setBounds(83, 40, 84, 19);
		desktopPane.add(lblTipo);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(83, 100, 84, 19);
		desktopPane.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido.setBounds(371, 100, 88, 19);
		desktopPane.add(lblApellido);

		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDni.setBounds(83, 168, 84, 14);
		desktopPane.add(lblDni);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasea.setBounds(371, 166, 88, 19);
		desktopPane.add(lblContrasea);

		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDireccion.setBounds(83, 240, 80, 14);
		desktopPane.add(lblDireccion);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefono.setBounds(371, 230, 88, 23);
		desktopPane.add(lblTelefono);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombre.setBounds(181, 100, 180, 21);
		desktopPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtDNI = new JTextField();
		txtDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDNI.setColumns(10);
		txtDNI.setBounds(181, 165, 180, 21);
		desktopPane.add(txtDNI);

		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(181, 237, 180, 21);
		desktopPane.add(txtDireccion);

		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtApellido.setColumns(10);
		txtApellido.setBounds(469, 101, 180, 21);
		desktopPane.add(txtApellido);

		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(469, 233, 180, 21);
		desktopPane.add(txtTelefono);

		txtContrasenha = new JPasswordField();
		txtContrasenha.setBounds(469, 167, 180, 20);
		desktopPane.add(txtContrasenha);

		JLabel lblFechaNacimiento = new JLabel("Fecha de Nacimiento:");
		lblFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaNacimiento.setBounds(83, 295, 142, 14);
		desktopPane.add(lblFechaNacimiento);

		JDateChooser calendar = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
		calendar.setBounds(235, 289, 180, 29);
		desktopPane.add(calendar);

		JLabel lblPosicion = new JLabel("Posicion:");
		lblPosicion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPosicion.setBounds(469, 297, 88, 23);
		desktopPane.add(lblPosicion);

		JComboBox<String> txtPosicion = new JComboBox<String>();
		txtPosicion.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Cliente", "Almacen", "Administrador", "Atencion al Cliente" }));
		txtPosicion.setBounds(529, 300, 120, 20);
		desktopPane.add(txtPosicion);
		JButton btnRegistro = new JButton("Registro");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				DataConnection conectar = new DataConnection();
				Connection conn = conectar.DataConn();

				if (rdbtnCliente.isSelected()) {
					try {
						if (ins0.getConectado().equals("Trabajador")) {
							PreparedStatement stmt = conn.prepareStatement(
									"INSERT INTO `clientes` (`Nombre`, `Apellido`, `ID`, `Telefono`, `Direccion`, `DNI`, `FechaNacimiento`, `Contrasenha`) VALUES (?, ?, NULL, ?, ?, ?, ?, ?)");

							stmt.setString(1, txtNombre.getText());
							stmt.setString(2, txtApellido.getText());
							stmt.setInt(3, Integer.parseInt(txtTelefono.getText()));
							stmt.setString(4, txtDireccion.getText());
							stmt.setString(5, txtDNI.getText());
							java.sql.Date fecha = new java.sql.Date(calendar.getDate().getTime());
							stmt.setDate(6, fecha);
							stmt.setString(7, txtContrasenha.getText());

							stmt.executeUpdate();
							
							stmt.close();
						}

					} catch (SQLException e) {
						e.printStackTrace();
					}
				} else if (rdbtnTrabajador.isSelected()) {
					if (ins0.getConectado().equals("Administrador")) {
						try {
							PreparedStatement stmt = conn.prepareStatement(
									"INSERT INTO `trabajador` (`Posicion`, `Nombre`, `Apellido`, `DNI`, `Direccion`, `Telefono`, `ID`, `Contrasenha`) VALUES (?, ?, ?, ?, ?, ?, NULL, ?)");

							stmt.setString(1, txtPosicion.getSelectedItem().toString());
							stmt.setString(2, txtNombre.getText());
							stmt.setString(3, txtApellido.getText());
							stmt.setString(4, txtDNI.getText());
							stmt.setString(5, txtDireccion.getText());
							stmt.setInt(6, Integer.parseInt(txtTelefono.getText()));
							stmt.setString(7, txtContrasenha.getText());

							stmt.executeUpdate();

							stmt.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		btnRegistro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistro.setBounds(338, 370, 121, 30);
		desktopPane.add(btnRegistro);
	}
}
