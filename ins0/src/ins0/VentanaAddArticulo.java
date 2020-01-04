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

public class VentanaAddArticulo extends JFrame {
	private JPanel Principal;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtNumeroDeSerie;
	private JTextField txtMarca;
	private JTextField txtFechaDeLlegada;
	private JTextField txtStock;

	public VentanaAddArticulo() {
		setTitle("A\u00F1adir Articulo");
		setBounds(100, 100, 851, 536);
		Principal = new JPanel();
		Principal.setBackground(Color.LIGHT_GRAY);
		Principal.setBorder(new EmptyBorder(5, 5, 5, 5));
		Principal.setLayout(new BorderLayout(0, 0));
		setContentPane(Principal);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		Principal.add(desktopPane, BorderLayout.CENTER);
		JButton btnArticulo = new JButton("A\u00F1adir Art\u00EDculo");
		btnArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {}
		});
		btnArticulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnArticulo.setBounds(338, 370, 121, 30);
		desktopPane.add(btnArticulo);
		
		JLabel lblNumeroDeSerie = new JLabel("Numero de Serie:");
		lblNumeroDeSerie.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumeroDeSerie.setBounds(52, 52, 137, 19);
		desktopPane.add(lblNumeroDeSerie);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipo.setBounds(52, 82, 137, 19);
		desktopPane.add(lblTipo);
		
		JLabel lblSubtipo = new JLabel("Subtipo:");
		lblSubtipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSubtipo.setBounds(52, 112, 137, 19);
		desktopPane.add(lblSubtipo);
		
		JLabel lblMarca = new JLabel("Marca: ");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMarca.setBounds(52, 142, 137, 19);
		desktopPane.add(lblMarca);
		
		JLabel lblFechaDeLlegada = new JLabel("Fecha de Llegada:");
		lblFechaDeLlegada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaDeLlegada.setBounds(52, 171, 137, 19);
		desktopPane.add(lblFechaDeLlegada);
		
		JLabel lblStock = new JLabel("Stock: ");
		lblStock.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStock.setBounds(52, 201, 137, 19);
		desktopPane.add(lblStock);
		
		txtNumeroDeSerie = new JTextField();
		txtNumeroDeSerie.setBounds(199, 53, 208, 20);
		desktopPane.add(txtNumeroDeSerie);
		txtNumeroDeSerie.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(199, 143, 208, 20);
		desktopPane.add(txtMarca);
		
		txtFechaDeLlegada = new JTextField();
		txtFechaDeLlegada.setText("aaaa/mm/dd");
		txtFechaDeLlegada.setColumns(10);
		txtFechaDeLlegada.setBounds(199, 172, 208, 20);
		desktopPane.add(txtFechaDeLlegada);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(199, 202, 208, 20);
		desktopPane.add(txtStock);
		
		JComboBox BoxTipo = new JComboBox();
		BoxTipo.setToolTipText("Procesador\r\nPlaca Base\r\nRAM\r\nROM HDD\r\nROM SSD\r\n");
		BoxTipo.setBounds(199, 83, 208, 20);
		desktopPane.add(BoxTipo);
	}
}
