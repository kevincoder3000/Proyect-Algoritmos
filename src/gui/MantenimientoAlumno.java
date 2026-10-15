package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MantenimientoAlumno {

	private JFrame frmMantenimientoAlumno;
	private JTextField txtCodigo;
	private JTextField txtAlumno;
	private JTextField txtApellidos;
	private JTextField txtDNI;
	private JTextField txtEdad;
	private JTextField txtCelular;
	private JTextField txtEstado;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantenimientoAlumno window = new MantenimientoAlumno();
					window.frmMantenimientoAlumno.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MantenimientoAlumno() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMantenimientoAlumno = new JFrame();
		frmMantenimientoAlumno.setTitle("Mantenimiento de Alumnos");
		frmMantenimientoAlumno.setBounds(100, 100, 481, 305);
		frmMantenimientoAlumno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMantenimientoAlumno.getContentPane().setLayout(null);
		
		JLabel lblCodigo = new JLabel("Código:");
		lblCodigo.setBounds(22, 18, 90, 25);
		frmMantenimientoAlumno.getContentPane().add(lblCodigo);
		
		JLabel lblAlumno = new JLabel("Alumno:");
		lblAlumno.setBounds(22, 47, 44, 12);
		frmMantenimientoAlumno.getContentPane().add(lblAlumno);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(22, 69, 61, 12);
		frmMantenimientoAlumno.getContentPane().add(lblApellidos);
		
		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setBounds(22, 91, 44, 12);
		frmMantenimientoAlumno.getContentPane().add(lblDNI);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(256, 24, 44, 12);
		frmMantenimientoAlumno.getContentPane().add(lblEdad);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(256, 47, 44, 12);
		frmMantenimientoAlumno.getContentPane().add(lblCelular);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(256, 69, 44, 12);
		frmMantenimientoAlumno.getContentPane().add(lblEstado);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(81, 21, 141, 18);
		frmMantenimientoAlumno.getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtAlumno = new JTextField();
		txtAlumno.setColumns(10);
		txtAlumno.setBounds(81, 44, 141, 18);
		frmMantenimientoAlumno.getContentPane().add(txtAlumno);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(81, 66, 141, 18);
		frmMantenimientoAlumno.getContentPane().add(txtApellidos);
		
		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		txtDNI.setBounds(81, 88, 141, 18);
		frmMantenimientoAlumno.getContentPane().add(txtDNI);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(310, 21, 141, 18);
		frmMantenimientoAlumno.getContentPane().add(txtEdad);
		
		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBounds(310, 44, 141, 18);
		frmMantenimientoAlumno.getContentPane().add(txtCelular);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(310, 66, 141, 18);
		frmMantenimientoAlumno.getContentPane().add(txtEstado);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(22, 124, 84, 20);
		frmMantenimientoAlumno.getContentPane().add(btnAdicionar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(107, 124, 84, 20);
		frmMantenimientoAlumno.getContentPane().add(btnConsultar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(280, 124, 84, 20);
		frmMantenimientoAlumno.getContentPane().add(btnEliminar);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(367, 124, 84, 20);
		frmMantenimientoAlumno.getContentPane().add(btnCerrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 152, 447, 106);
		frmMantenimientoAlumno.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"C\u00F3digo", "Nombres", "Apellidos", "DNI", "Celular", "Estado"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(194, 124, 84, 20);
		frmMantenimientoAlumno.getContentPane().add(btnModificar);
	}
}
