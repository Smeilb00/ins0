package ins0;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.border.*;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.awt.event.ActionEvent;

public class VentanaLogin extends JFrame {
	
	private JPanel Principal;
	private JPasswordField passwordField;
	private JTextField textField;
	private JLabel lblLogin;

	public VentanaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("LOGIN");
		Image icon = new ImageIcon(getClass().getResource("o2.png")).getImage();
		setIconImage(icon);
		setBounds(400,200,629,309);
		Principal = new JPanel();	
		Principal.setBackground(new Color(70, 130, 180));
		Principal.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(Principal);
		Principal.setLayout(null);
		
		JLabel lblUser = new JLabel("USER");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setForeground(new Color(255, 255, 255));
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUser.setBounds(102, 114, 100, 14);
		Principal.add(lblUser);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(102, 151, 100, 14);
		Principal.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(224, 147, 277, 27);
		Principal.add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(224, 110, 277, 26);
		Principal.add(textField);
		textField.setColumns(10);
		
		lblLogin = new JLabel("LOGIN");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogin.setBounds(93, 51, 427, 27);
		Principal.add(lblLogin);
		
		JButton btnNewButton_1 = new JButton("LOGIN");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setForeground(new Color(70, 130, 180));
		btnNewButton_1.setBounds(262, 202, 89, 23);
		Principal.add(btnNewButton_1);
		Icon X = new ImageIcon(getClass().getResource("X.png"));
		

	}
}

