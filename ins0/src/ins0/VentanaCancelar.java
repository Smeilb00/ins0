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

public class VentanaCancelar extends JFrame {
	private JPanel Principal;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;

	public VentanaCancelar() {
		setTitle("Gestionar Stock");
		setBounds(100, 100, 851, 336);
		Principal = new JPanel();
		Principal.setBackground(Color.LIGHT_GRAY);
		Principal.setBorder(new EmptyBorder(5, 5, 5, 5));
		Principal.setLayout(new BorderLayout(0, 0));
		setContentPane(Principal);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(70, 130, 180));
		Principal.add(desktopPane, BorderLayout.CENTER);
		JButton btnPedido = new JButton("Cancelar Pedido");
		
		btnPedido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPedido.setBounds(544, 233, 216, 30);
		desktopPane.add(btnPedido);
		
		textField = new JTextField();
		textField.setBounds(198, 80, 264, 20);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNumeroDePedido = new JLabel("Numero de pedido");
		lblNumeroDePedido.setForeground(new Color(255, 255, 255));
		lblNumeroDePedido.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumeroDePedido.setBounds(27, 81, 145, 14);
		desktopPane.add(lblNumeroDePedido);
		
		JLabel lblNewLabel = new JLabel("DATOS PEDIDO");
		lblNewLabel.setBounds(493, 24, 293, 185);
		desktopPane.add(lblNewLabel);
		
		JButton btnBuscarPedido = new JButton("Buscar Pedido");
		btnBuscarPedido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarPedido.setBounds(122, 131, 216, 30);
		desktopPane.add(btnBuscarPedido);
	}
}
