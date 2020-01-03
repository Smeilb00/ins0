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

public class PedidoVentana extends JFrame {
	private JPanel Principal;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtNombreCliente;
	private JTextField textField;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	public PedidoVentana() {
		setTitle("Crear Pedido");
		setBounds(100, 100, 851, 536);
		Principal = new JPanel();
		Principal.setBackground(Color.LIGHT_GRAY);
		Principal.setBorder(new EmptyBorder(5, 5, 5, 5));
		Principal.setLayout(new BorderLayout(0, 0));
		setContentPane(Principal);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		Principal.add(desktopPane, BorderLayout.CENTER);

		JLabel lblDireccion = new JLabel("Direccion de Entrega:");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDireccion.setBounds(62, 84, 137, 19);
		desktopPane.add(lblDireccion);
		JButton btnPedido = new JButton("Crear Pedido");
		btnPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DataConnection conectar = new DataConnection();
				Connection conn = conectar.DataConn();
				
				
				
				
				
			}
		});
		btnPedido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPedido.setBounds(338, 370, 121, 30);
		desktopPane.add(btnPedido);
		
		JLabel lblProcesador = new JLabel("Procesador:");
		lblProcesador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProcesador.setBounds(465, 54, 121, 19);
		desktopPane.add(lblProcesador);
		
		JLabel lblRAM = new JLabel("Memoria RAM:");
		lblRAM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRAM.setBounds(465, 84, 121, 19);
		desktopPane.add(lblRAM);
		
		JLabel lblCapacidad = new JLabel("Capacidad HDD:");
		lblCapacidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCapacidad.setBounds(465, 114, 121, 19);
		desktopPane.add(lblCapacidad);
		
		JLabel lblDiscoSsd = new JLabel("Disco SSD:");
		lblDiscoSsd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDiscoSsd.setBounds(465, 141, 121, 19);
		desktopPane.add(lblDiscoSsd);
		
		JLabel lblPlacaBase = new JLabel("Placa Base:");
		lblPlacaBase.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlacaBase.setBounds(465, 171, 121, 19);
		desktopPane.add(lblPlacaBase);
		
		JLabel lblRaton = new JLabel("Raton: ");
		lblRaton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRaton.setBounds(465, 201, 121, 19);
		desktopPane.add(lblRaton);
		
		JLabel lblTeclado = new JLabel("Teclado: ");
		lblTeclado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTeclado.setBounds(465, 231, 121, 19);
		desktopPane.add(lblTeclado);
		
		JLabel lblAltavoces = new JLabel("Altavoces:");
		lblAltavoces.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAltavoces.setBounds(465, 261, 121, 19);
		desktopPane.add(lblAltavoces);
		
		JLabel lblMonitor = new JLabel("Monitor");
		lblMonitor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMonitor.setBounds(465, 291, 121, 19);
		desktopPane.add(lblMonitor);
		
		JLabel lblSistemaOperativo = new JLabel("Sistema Operativo:");
		lblSistemaOperativo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSistemaOperativo.setBounds(465, 321, 121, 19);
		desktopPane.add(lblSistemaOperativo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(62, 54, 137, 19);
		desktopPane.add(lblNombre);
		
		JLabel lblTipoDePedido = new JLabel("Tipo de Pedido:");
		lblTipoDePedido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipoDePedido.setBounds(62, 114, 137, 19);
		desktopPane.add(lblTipoDePedido);
		
		txtNombreCliente = new JTextField();
		txtNombreCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombreCliente.setBounds(209, 53, 194, 20);
		desktopPane.add(txtNombreCliente);
		txtNombreCliente.setColumns(10);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(209, 85, 194, 20);
		desktopPane.add(textField);
		
		JComboBox BoxProcesadores = new JComboBox();
		BoxProcesadores.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BoxProcesadores.setModel(new DefaultComboBoxModel(new String[] {"No", "Intel 7\u00AA generaci\u00F3n", "Intel de 5\u00AA generaci\u00F3n"}));
		BoxProcesadores.setToolTipText("");
		BoxProcesadores.setBounds(596, 55, 160, 20);
		desktopPane.add(BoxProcesadores);
		
		JComboBox BoxRAM = new JComboBox();
		BoxRAM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BoxRAM.setModel(new DefaultComboBoxModel(new String[] {"No", "8Gb", "16Gb"}));
		BoxRAM.setToolTipText("");
		BoxRAM.setBounds(596, 85, 160, 20);
		desktopPane.add(BoxRAM);
		
		JComboBox BoxHDD = new JComboBox();
		BoxHDD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BoxHDD.setModel(new DefaultComboBoxModel(new String[] {"No", "WD 250 Gb", "WD 500 Gb", "WD 1 Tb"}));
		BoxHDD.setToolTipText("");
		BoxHDD.setBounds(596, 115, 160, 20);
		desktopPane.add(BoxHDD);
		
		JComboBox BoxSSD = new JComboBox();
		BoxSSD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BoxSSD.setModel(new DefaultComboBoxModel(new String[] {"No", "WD 124 Gb", "WD 248 Gb"}));
		BoxSSD.setToolTipText("");
		BoxSSD.setBounds(596, 142, 160, 20);
		desktopPane.add(BoxSSD);
		
		JComboBox BoxPlacaBase = new JComboBox();
		BoxPlacaBase.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BoxPlacaBase.setModel(new DefaultComboBoxModel(new String[] {"No", "ATX", "MiniATX", "BX"}));
		BoxPlacaBase.setToolTipText("");
		BoxPlacaBase.setBounds(596, 172, 160, 20);
		desktopPane.add(BoxPlacaBase);
		
		JComboBox BoxRaton = new JComboBox();
		BoxRaton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BoxRaton.setModel(new DefaultComboBoxModel(new String[] {"No", "Logitech G203 8000DPI", "Logitech B100"}));
		BoxRaton.setToolTipText("");
		BoxRaton.setBounds(596, 202, 160, 20);
		desktopPane.add(BoxRaton);
		
		JComboBox BoxTeclado = new JComboBox();
		BoxTeclado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BoxTeclado.setModel(new DefaultComboBoxModel(new String[] {"No", "Logitech MK850", "Mars Gaming MCP 118"}));
		BoxTeclado.setToolTipText("");
		BoxTeclado.setBounds(596, 232, 160, 20);
		desktopPane.add(BoxTeclado);
		
		JComboBox BoxAuriculares = new JComboBox();
		BoxAuriculares.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BoxAuriculares.setModel(new DefaultComboBoxModel(new String[] {"No", "160W", "40W"}));
		BoxAuriculares.setToolTipText("");
		BoxAuriculares.setBounds(596, 262, 160, 20);
		desktopPane.add(BoxAuriculares);
		
		JComboBox BoxMonitor = new JComboBox();
		BoxMonitor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BoxMonitor.setModel(new DefaultComboBoxModel(new String[] {"No", "FullHD 60 Hz", "Wide Screen", "FullHD 144Hz", "2K", "4K"}));
		BoxMonitor.setToolTipText("");
		BoxMonitor.setBounds(596, 292, 160, 20);
		desktopPane.add(BoxMonitor);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"No", "Windows 7 ", "Windows 8", "Windows 8.1", "Windows 10", "Windows 10 pro", "Ubuntu ", "Debian"}));
		comboBox_1.setToolTipText("");
		comboBox_1.setBounds(596, 322, 160, 20);
		desktopPane.add(comboBox_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Compra");
		buttonGroup_1.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton.setBackground(Color.LIGHT_GRAY);
		rdbtnNewRadioButton.setBounds(90, 141, 109, 23);
		desktopPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnReparacion = new JRadioButton("Reparacion");
		buttonGroup_1.add(rdbtnReparacion);
		rdbtnReparacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnReparacion.setBackground(Color.LIGHT_GRAY);
		rdbtnReparacion.setBounds(90, 171, 109, 23);
		desktopPane.add(rdbtnReparacion);
		
		JLabel lblPcCompleto = new JLabel("PC Completo:");
		lblPcCompleto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPcCompleto.setBounds(62, 235, 137, 19);
		desktopPane.add(lblPcCompleto);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Predefinido Oficina", "Predefinido Casa", "Predefinido Gaming"}));
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_2.setToolTipText("");
		comboBox_2.setBounds(209, 236, 160, 20);
		desktopPane.add(comboBox_2);
	}
}
