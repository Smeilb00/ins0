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

public class VentanaPedido extends JFrame {
	private JPanel Principal;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtNombreCliente;
	private JTextField txtDireccionEntrega;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	public VentanaPedido() {
		setTitle("Crear Pedido");
		setBounds(100, 100, 851, 536);
		Principal = new JPanel();
		Principal.setBackground(Color.LIGHT_GRAY);
		Principal.setLayout(new BorderLayout(0, 0));
		setContentPane(Principal);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(70, 130, 180));
		Principal.add(desktopPane, BorderLayout.CENTER);

		JLabel lblDireccion = new JLabel("Direccion de Entrega:");
		lblDireccion.setForeground(new Color(255, 255, 255));
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDireccion.setBounds(57, 132, 147, 19);
		desktopPane.add(lblDireccion);
		
		JLabel lblProcesador = new JLabel("Procesador:");
		lblProcesador.setForeground(new Color(255, 255, 255));
		lblProcesador.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProcesador.setBounds(460, 102, 137, 19);
		desktopPane.add(lblProcesador);
		
		JLabel lblRAM = new JLabel("Memoria RAM:");
		lblRAM.setForeground(new Color(255, 255, 255));
		lblRAM.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRAM.setBounds(460, 132, 137, 19);
		desktopPane.add(lblRAM);
		
		JLabel lblCapacidad = new JLabel("Capacidad HDD:");
		lblCapacidad.setForeground(new Color(255, 255, 255));
		lblCapacidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCapacidad.setBounds(460, 162, 137, 19);
		desktopPane.add(lblCapacidad);
		
		JLabel lblDiscoSsd = new JLabel("Disco SSD:");
		lblDiscoSsd.setForeground(new Color(255, 255, 255));
		lblDiscoSsd.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDiscoSsd.setBounds(460, 189, 137, 19);
		desktopPane.add(lblDiscoSsd);
		
		JLabel lblPlacaBase = new JLabel("Placa Base:");
		lblPlacaBase.setForeground(new Color(255, 255, 255));
		lblPlacaBase.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPlacaBase.setBounds(460, 219, 137, 19);
		desktopPane.add(lblPlacaBase);
		
		JLabel lblRaton = new JLabel("Raton: ");
		lblRaton.setForeground(new Color(255, 255, 255));
		lblRaton.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRaton.setBounds(460, 249, 137, 19);
		desktopPane.add(lblRaton);
		
		JLabel lblTeclado = new JLabel("Teclado: ");
		lblTeclado.setForeground(new Color(255, 255, 255));
		lblTeclado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTeclado.setBounds(460, 279, 137, 19);
		desktopPane.add(lblTeclado);
		
		JLabel lblAltavoces = new JLabel("Altavoces:");
		lblAltavoces.setForeground(new Color(255, 255, 255));
		lblAltavoces.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAltavoces.setBounds(460, 309, 137, 19);
		desktopPane.add(lblAltavoces);
		
		JLabel lblMonitor = new JLabel("Monitor");
		lblMonitor.setForeground(new Color(255, 255, 255));
		lblMonitor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMonitor.setBounds(460, 339, 137, 19);
		desktopPane.add(lblMonitor);
		
		JLabel lblSistemaOperativo = new JLabel("Sistema Operativo:");
		lblSistemaOperativo.setForeground(new Color(255, 255, 255));
		lblSistemaOperativo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSistemaOperativo.setBounds(460, 369, 137, 19);
		desktopPane.add(lblSistemaOperativo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(57, 102, 137, 19);
		desktopPane.add(lblNombre);
		
		JLabel lblTipoDePedido = new JLabel("Tipo de Pedido:");
		lblTipoDePedido.setForeground(new Color(255, 255, 255));
		lblTipoDePedido.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTipoDePedido.setBounds(57, 162, 137, 19);
		desktopPane.add(lblTipoDePedido);
		
		txtNombreCliente = new JTextField();
		txtNombreCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombreCliente.setBounds(214, 101, 194, 20);
		desktopPane.add(txtNombreCliente);
		txtNombreCliente.setColumns(10);
		
		txtDireccionEntrega = new JTextField();
		txtDireccionEntrega.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDireccionEntrega.setColumns(10);
		txtDireccionEntrega.setBounds(214, 131, 194, 20);
		desktopPane.add(txtDireccionEntrega);
		
		JComboBox BoxProcesadores = new JComboBox();
		BoxProcesadores.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BoxProcesadores.setModel(new DefaultComboBoxModel(new String[] {"No", "Intel 7\u00AA generaci\u00F3n", "Intel de 5\u00AA generaci\u00F3n"}));
		BoxProcesadores.setToolTipText("");
		BoxProcesadores.setBounds(616, 102, 160, 20);
		desktopPane.add(BoxProcesadores);
		
		JComboBox BoxRAM = new JComboBox();
		BoxRAM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BoxRAM.setModel(new DefaultComboBoxModel(new String[] {"No", "8Gb", "16Gb"}));
		BoxRAM.setToolTipText("");
		BoxRAM.setBounds(616, 132, 160, 20);
		desktopPane.add(BoxRAM);
		
		JComboBox BoxHDD = new JComboBox();
		BoxHDD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BoxHDD.setModel(new DefaultComboBoxModel(new String[] {"No", "WD 250 Gb", "WD 500 Gb", "WD 1 Tb"}));
		BoxHDD.setToolTipText("");
		BoxHDD.setBounds(616, 162, 160, 20);
		desktopPane.add(BoxHDD);
		
		JComboBox BoxSSD = new JComboBox();
		BoxSSD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BoxSSD.setModel(new DefaultComboBoxModel(new String[] {"No", "WD 124 Gb", "WD 248 Gb"}));
		BoxSSD.setToolTipText("");
		BoxSSD.setBounds(616, 189, 160, 20);
		desktopPane.add(BoxSSD);
		
		JComboBox BoxPlacaBase = new JComboBox();
		BoxPlacaBase.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BoxPlacaBase.setModel(new DefaultComboBoxModel(new String[] {"No", "ATX", "MiniATX", "BX"}));
		BoxPlacaBase.setToolTipText("");
		BoxPlacaBase.setBounds(616, 219, 160, 20);
		desktopPane.add(BoxPlacaBase);
		
		JComboBox BoxRaton = new JComboBox();
		BoxRaton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BoxRaton.setModel(new DefaultComboBoxModel(new String[] {"No", "Logitech G203 8000DPI", "Logitech B100"}));
		BoxRaton.setToolTipText("");
		BoxRaton.setBounds(616, 249, 160, 20);
		desktopPane.add(BoxRaton);
		
		JComboBox BoxTeclado = new JComboBox();
		BoxTeclado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BoxTeclado.setModel(new DefaultComboBoxModel(new String[] {"No", "Logitech MK850", "Mars Gaming MCP 118"}));
		BoxTeclado.setToolTipText("");
		BoxTeclado.setBounds(616, 279, 160, 20);
		desktopPane.add(BoxTeclado);
		
		JComboBox BoxAuriculares = new JComboBox();
		BoxAuriculares.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BoxAuriculares.setModel(new DefaultComboBoxModel(new String[] {"No", "160W", "40W"}));
		BoxAuriculares.setToolTipText("");
		BoxAuriculares.setBounds(616, 309, 160, 20);
		desktopPane.add(BoxAuriculares);
		
		JComboBox BoxMonitor = new JComboBox();
		BoxMonitor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BoxMonitor.setModel(new DefaultComboBoxModel(new String[] {"No", "FullHD 60 Hz", "Wide Screen", "FullHD 144Hz", "2K", "4K"}));
		BoxMonitor.setToolTipText("");
		BoxMonitor.setBounds(616, 339, 160, 20);
		desktopPane.add(BoxMonitor);
		
		JComboBox BoxSistemaOperativo = new JComboBox();
		BoxSistemaOperativo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BoxSistemaOperativo.setModel(new DefaultComboBoxModel(new String[] {"No", "Windows 7 ", "Windows 8", "Windows 8.1", "Windows 10", "Windows 10 pro", "Ubuntu ", "Debian"}));
		BoxSistemaOperativo.setToolTipText("");
		BoxSistemaOperativo.setBounds(616, 369, 160, 20);
		desktopPane.add(BoxSistemaOperativo);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Compra");
		rdbtnNewRadioButton.setForeground(new Color(255, 255, 255));
		buttonGroup_1.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton.setBackground(new Color(70, 130, 180));
		rdbtnNewRadioButton.setBounds(85, 189, 109, 23);
		desktopPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnReparacion = new JRadioButton("Reparacion");
		rdbtnReparacion.setForeground(new Color(255, 255, 255));
		buttonGroup_1.add(rdbtnReparacion);
		rdbtnReparacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnReparacion.setBackground(new Color(70, 130, 180));
		rdbtnReparacion.setBounds(85, 219, 109, 23);
		desktopPane.add(rdbtnReparacion);
		
		JLabel lblPcCompleto = new JLabel("PC Completo:");
		lblPcCompleto.setForeground(new Color(255, 255, 255));
		lblPcCompleto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPcCompleto.setBounds(57, 283, 137, 19);
		desktopPane.add(lblPcCompleto);
		
		JComboBox BoxPCCompleto = new JComboBox();
		BoxPCCompleto.setModel(new DefaultComboBoxModel(new String[] {"No", "Predefinido Oficina", "Predefinido Casa", "Predefinido Gaming"}));
		BoxPCCompleto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BoxPCCompleto.setToolTipText("");
		BoxPCCompleto.setBounds(204, 284, 160, 20);
		desktopPane.add(BoxPCCompleto);
		
		JLabel lblCrearPedido = new JLabel("CREAR PEDIDO");
		lblCrearPedido.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblCrearPedido.setForeground(new Color(255, 255, 255));
		lblCrearPedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrearPedido.setBounds(57, 26, 694, 45);
		desktopPane.add(lblCrearPedido);
		
		JButton btnPedido = new JButton("Crear Pedido");
		btnPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DataConnection conectar = new DataConnection();
				Connection conn = conectar.DataConn();
				String articulos = null;

				if (BoxPCCompleto.getSelectedItem().toString().equals("No")) {
					if (BoxHDD.getSelectedItem().toString() != "No") {
						articulos += BoxHDD.getSelectedItem().toString() + ",";
					}
					if (BoxRAM.getSelectedItem().toString() != "No") {
						articulos += BoxRAM.getSelectedItem().toString() + ",";
					}
					if (BoxProcesadores.getSelectedItem().toString() != "No") {
						articulos += BoxProcesadores.getSelectedItem().toString() + ",";
					}
					if (BoxMonitor.getSelectedItem().toString() != "No") {
						articulos += BoxMonitor.getSelectedItem().toString() + ",";
					}
					if (BoxSSD.getSelectedItem().toString() != "No") {
						articulos += BoxSSD.getSelectedItem().toString() + ",";
					}
					if (BoxTeclado.getSelectedItem().toString() != "No") {
						articulos += BoxTeclado.getSelectedItem().toString() + ",";
					}
					if (BoxPlacaBase.getSelectedItem().toString() != "No") {
						articulos += BoxPlacaBase.getSelectedItem().toString() + ",";
					}
					if (BoxRaton.getSelectedItem().toString() != "No") {
						articulos += BoxRaton.getSelectedItem().toString() + ",";
					}
					if (BoxAuriculares.getSelectedItem().toString() != "No") {
						articulos += BoxAuriculares.getSelectedItem().toString();
					}
				}else {
					articulos += BoxPCCompleto.getSelectedItem().toString();
				}
				
				ClienteDao c1 = new ClienteDao();
				c1.iniciarPedido(conn, txtDireccionEntrega.getText(),articulos ,txtNombreCliente.getText(), "Compra");
			}
		});
		btnPedido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPedido.setBounds(333, 418, 121, 30);
		desktopPane.add(btnPedido);
		
		
	}
}
