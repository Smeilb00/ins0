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

public class VentanaAceptar extends JFrame {
	private JPanel Principal;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public VentanaAceptar() {
		setTitle("Aceptar Pedidos");
		setBounds(100, 100, 851, 536);
		Principal = new JPanel();
		Principal.setBorder(new EmptyBorder(5, 5, 5, 5));
		Principal.setLayout(new BorderLayout(0, 0));
		setContentPane(Principal);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(70, 130, 180));
		Principal.add(desktopPane, BorderLayout.CENTER);
		JButton btnPedido = new JButton("Aceptar Pedidos");
		
		btnPedido.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPedido.setBounds(338, 370, 191, 30);
		desktopPane.add(btnPedido);
	}
}
