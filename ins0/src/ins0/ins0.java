package ins0;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.*;
import java.sql.Connection;

public class ins0 extends JFrame {
	private static String conectado = "";
	private static int iD = 0;
	public static String getConectado() {
		return ins0.conectado;
	}

	public static void setConectado(String conectado) {
		ins0.conectado = conectado;
	}

	private JPanel Principal;
	private JTextField usuarioText;
	private JPasswordField passwordText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ins0 frame = new ins0();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ins0() {
		setTitle("Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 750);
		Principal = new JPanel();
		Principal.setBorder(new EmptyBorder(5, 5, 5, 5));
		Principal.setLayout(new BorderLayout(0, 0));
		setContentPane(Principal);
				
		JTabbedPane Pestanhas = new JTabbedPane(JTabbedPane.TOP);
		Pestanhas.setForeground(Color.BLACK);
		Pestanhas.setBackground(Color.LIGHT_GRAY);
		Principal.add(Pestanhas, BorderLayout.CENTER);
		
		JDesktopPane Login = new JDesktopPane();
		Login.setBackground(Color.LIGHT_GRAY);
		Pestanhas.addTab("Login", null, Login, null);
		
		
		
		JLabel lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setBounds(44, 44, 82, 28);
		Login.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasea.setBounds(44, 118, 82, 28);
		Login.add(lblContrasea);
		
		usuarioText = new JTextField();
		usuarioText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		usuarioText.setBounds(151, 45, 203, 28);
		Login.add(usuarioText);
		usuarioText.setColumns(10);
		
		JLabel salida = new JLabel("");
		salida.setBounds(658, 89, 91, 45);
		Login.add(salida);
		
		passwordText = new JPasswordField();
		passwordText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordText.setBounds(151, 118, 203, 30);
		Login.add(passwordText);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DataConnection conectar = new DataConnection();
				Connection conn = conectar.DataConn();
				conectar.comprobarUsuario(conn, usuarioText.getText(), passwordText.getText());
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.setBounds(317, 191, 121, 30);
		Login.add(btnLogin);
		
		JButton btnRegistro = new JButton("Registro");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ins0.conectado != "" && ins0.conectado != "Cliente") {
					RegistroVentana v2 = new RegistroVentana();
					v2.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Debes estar registrado como trabajador para poder agregar nuevos usuarios");
				}
				
			}
		});
		btnRegistro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistro.setBounds(99, 191, 121, 30);
		Login.add(btnRegistro);
		
		JButton btnCrearPedido = new JButton("Crear Pedido");
		btnCrearPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PedidoVentana v3 = new PedidoVentana();
				v3.setVisible(true);
			}
		});
		btnCrearPedido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCrearPedido.setBounds(546, 49, 121, 30);
		Login.add(btnCrearPedido);
		
		JButton btnModificardatos = new JButton("Modificar Datos");
		btnModificardatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarVentana v4 = new ModificarVentana();
				v4.setVisible(true);
			}
		});
		btnModificardatos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificardatos.setBounds(546, 123, 143, 30);
		Login.add(btnModificardatos);
		
	}
}
