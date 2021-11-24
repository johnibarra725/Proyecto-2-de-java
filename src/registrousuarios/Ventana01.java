package registrousuarios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Point;
import java.awt.SystemColor;
public class Ventana01 extends JFrame {
	
	private String urlDB = "jdbc:postgresql://localhost:5432/escuela";
    private String userDB = "postgres";
    private String passDB = "johnibarra2";
    PreparedStatement ps;
    ResultSet rs;
	public Connection getConnection() {
		Connection conexion = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			conexion = DriverManager.getConnection(urlDB,userDB,passDB);
			//JOptionPane.showMessageDialog(null, "Conexion exitosa","conexion",1);
		}catch(Exception ex) {
			System.err.print("Error, "+ex);
			
		}
		return conexion;
		
	}
	
	private JPanel contentPane;
	private JTextField txtIdpersona;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
    private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		
	
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana01 frame = new Ventana01();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	
	public Ventana01() {
		setUndecorated(true);
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Registro de usuarios");
		this.setLocationRelativeTo(null);
	
		txtIdpersona = new JTextField();
		txtIdpersona.setVisible(false);
		setBounds(100, 100, 634, 666);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBackground(SystemColor.controlHighlight);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conexion = null;
				
				try {
					conexion = getConnection();
					ps = conexion.prepareStatement("select * from persona where clave=?");
					ps.setString(1,textField_1.getText());
					rs = ps.executeQuery();
					
					if(rs.next()) {
						
						textField_2.setText(rs.getString("clave"));
						textField_3.setText(rs.getString("nombre"));
						textField_4.setText(rs.getString("direccion"));
						textField_5.setText(rs.getString("telefono"));
						textField_6.setText(rs.getString("correo_electronico"));
						textField_7.setText(String.valueOf(rs.getDate("fecha_nacimiento")));
						comboBox.setSelectedItem(rs.getString("genero"));
						txtIdpersona.setText(String.valueOf(rs.getInt("idPersona")));
					}
					
					else {
						JOptionPane.showMessageDialog(null, "No existe una persona con esa clave","Error",0);
					}
					conexion.close();
				}catch(Exception ex) {
					
					System.err.print("Error, "+ex);
				}
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(463, 28, 100, 30);
		contentPane.add(btnNewButton);
		txtIdpersona.setFont(new Font("Arial", Font.PLAIN, 12));
		txtIdpersona.setBounds(463, 68, 100, 19);
		contentPane.add(txtIdpersona);
		txtIdpersona.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_1.setBounds(303, 28, 150, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Clave:");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBounds(36, 133, 56, 24);
		contentPane.add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.PLAIN, 14));
		textField_2.setBounds(117, 133, 476, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNombre.setBounds(36, 183, 76, 24);
		contentPane.add(lblNombre);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDireccion.setBounds(36, 232, 76, 24);
		contentPane.add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTelefono.setBounds(36, 282, 76, 24);
		contentPane.add(lblTelefono);
		
		JLabel lblCorreoElectronico = new JLabel("Correo electronico:");
		lblCorreoElectronico.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCorreoElectronico.setBounds(36, 336, 134, 24);
		contentPane.add(lblCorreoElectronico);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha nacimiento:");
		lblFechaDeNacimiento.setFont(new Font("Arial", Font.PLAIN, 16));
		lblFechaDeNacimiento.setBounds(36, 390, 139, 24);
		contentPane.add(lblFechaDeNacimiento);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.PLAIN, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(117, 185, 476, 24);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Arial", Font.PLAIN, 14));
		textField_4.setColumns(10);
		textField_4.setBounds(117, 234, 476, 24);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Arial", Font.PLAIN, 14));
		textField_5.setColumns(10);
		textField_5.setBounds(117, 284, 476, 24);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Arial", Font.PLAIN, 14));
		textField_6.setColumns(10);
		textField_6.setBounds(180, 338, 413, 24);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Arial", Font.PLAIN, 14));
		textField_7.setColumns(10);
		textField_7.setBounds(180, 392, 413, 24);
		contentPane.add(textField_7);
		
		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setFont(new Font("Arial", Font.PLAIN, 16));
		lblGenero.setBounds(36, 446, 64, 24);
		contentPane.add(lblGenero);
		
		
		
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.setBackground(SystemColor.controlHighlight);
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conexion = null;
				try {
					conexion = getConnection();
					ps=conexion.prepareStatement("INSERT INTO persona(clave,nombre,direccion,telefono,correo_electronico,fecha_nacimiento,genero) VALUES(?,?,?,?,?,?,?)");
					ps.setString(1,textField_2.getText());
					ps.setString(2,textField_3.getText());
					ps.setString(3,textField_4.getText());
					ps.setString(4,textField_5.getText());
					ps.setString(5,textField_6.getText());
					ps.setDate(6,Date.valueOf(textField_7.getText()));
					ps.setString(7,comboBox.getSelectedItem().toString());
					int resultado = ps.executeUpdate();
					
					if(resultado>0) {
						
						JOptionPane.showMessageDialog(null, "Registro exitoso","Registro",1);
						limpiarCajas();
					}
					
					else {
						JOptionPane.showMessageDialog(null, "Error al ingresar los registros");
						limpiarCajas();
					}
					conexion.close();
				}catch(Exception ex) {
					System.err.print("Error, "+ex);
				}
			}
		});
		btnInsertar.setFont(new Font("Arial", Font.BOLD, 14));
		btnInsertar.setBounds(51, 539, 100, 30);
		contentPane.add(btnInsertar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBackground(SystemColor.controlHighlight);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conexion = null;
				try {
					conexion = getConnection();
					ps=conexion.prepareStatement("update persona set clave=?,nombre=?,direccion=?,telefono=?,correo_electronico=?,fecha_nacimiento=?,genero=? where idpersona=?");
					ps.setString(1,textField_2.getText());
					ps.setString(2,textField_3.getText());
					ps.setString(3,textField_4.getText());
					ps.setString(4,textField_5.getText());
					ps.setString(5,textField_6.getText());
					ps.setDate(6,Date.valueOf(textField_7.getText()));
					ps.setString(7,comboBox.getSelectedItem().toString());
					ps.setInt(8, Integer.parseInt(txtIdpersona.getText()));
					int resultado = ps.executeUpdate();
					
					if(resultado>0) {
						
						JOptionPane.showMessageDialog(null, "Registro modificado correctamente","Registro",1);
						limpiarCajas();
					}
					
					else {
						JOptionPane.showMessageDialog(null, "Error al modificar el registro");
						limpiarCajas();
					}
					conexion.close();
				}catch(Exception ex) {
					System.err.print("Error, "+ex);
				}
			}
		});
		btnModificar.setFont(new Font("Arial", Font.BOLD, 14));
		btnModificar.setBounds(180, 539, 100, 30);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(SystemColor.controlHighlight);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection conexion = null;
				try {
					conexion = getConnection();
					ps=conexion.prepareStatement("delete from persona where idpersona=?");
				
					ps.setInt(1, Integer.parseInt(txtIdpersona.getText()));
					int resultado = ps.executeUpdate();
					
					if(resultado>0) {
						
						JOptionPane.showMessageDialog(null, "Registro eliminado correctamente","Registro",1);
						limpiarCajas();
					}
					
					else {
						JOptionPane.showMessageDialog(null, "Error al eliminar el registro");
						limpiarCajas();
					}
					conexion.close();
				}catch(Exception ex) {
					System.err.print("Error, "+ex);
				}
			}
		});
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 14));
		btnEliminar.setBounds(310, 539, 100, 30);
		contentPane.add(btnEliminar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBackground(SystemColor.controlHighlight);
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCajas();
			}
		});
		btnLimpiar.setFont(new Font("Arial", Font.BOLD, 14));
		btnLimpiar.setBounds(444, 539, 100, 30);
		contentPane.add(btnLimpiar);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar", "Masculino", "Femenino"}));
		comboBox.setBounds(138, 450, 455, 21);
		contentPane.add(comboBox);
		
		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(36, 28, 100, 30);
		contentPane.add(btnNewButton_1);
	}
public void limpiarCajas() {
		
		textField_1.setText(null);
		textField_2.setText(null);
		textField_3.setText(null);
		textField_4.setText(null);
		textField_5.setText(null);
		textField_6.setText(null);
		textField_7.setText(null);
		comboBox.setSelectedIndex(0);
	}
}
