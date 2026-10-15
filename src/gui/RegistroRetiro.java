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

public class RegistroRetiro {

	private JFrame frmRegistroRetiro;
	private JTextField txtNRetiro;
	private JTextField txtNMatricula;
	private JTextField txtFecha;
	private JTextField txtHora;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroRetiro window = new RegistroRetiro();
					window.frmRegistroRetiro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegistroRetiro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistroRetiro = new JFrame();
		frmRegistroRetiro.setTitle("Registro Retiro");
		frmRegistroRetiro.setBounds(100, 100, 450, 300);
		frmRegistroRetiro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistroRetiro.getContentPane().setLayout(null);
		
		JLabel lblNRetiro = new JLabel("N° Retiro:");
		lblNRetiro.setBounds(24, 20, 68, 12);
		frmRegistroRetiro.getContentPane().add(lblNRetiro);
		
		JLabel lblNMatrcula = new JLabel("N° Matrícula:");
		lblNMatrcula.setBounds(24, 42, 91, 12);
		frmRegistroRetiro.getContentPane().add(lblNMatrcula);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(24, 64, 68, 12);
		frmRegistroRetiro.getContentPane().add(lblFecha);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setBounds(24, 85, 68, 12);
		frmRegistroRetiro.getContentPane().add(lblHora);
		
		txtNRetiro = new JTextField();
		txtNRetiro.setBounds(134, 17, 132, 18);
		frmRegistroRetiro.getContentPane().add(txtNRetiro);
		txtNRetiro.setColumns(10);
		
		txtNMatricula = new JTextField();
		txtNMatricula.setColumns(10);
		txtNMatricula.setBounds(134, 39, 132, 18);
		frmRegistroRetiro.getContentPane().add(txtNMatricula);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(134, 61, 132, 18);
		frmRegistroRetiro.getContentPane().add(txtFecha);
		
		txtHora = new JTextField();
		txtHora.setColumns(10);
		txtHora.setBounds(134, 82, 132, 18);
		frmRegistroRetiro.getContentPane().add(txtHora);
		
		JButton btnRegistrarRetiro = new JButton("Registrar Retiro");
		btnRegistrarRetiro.setBounds(10, 118, 137, 20);
		frmRegistroRetiro.getContentPane().add(btnRegistrarRetiro);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(303, 118, 123, 20);
		frmRegistroRetiro.getContentPane().add(btnCerrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 145, 416, 108);
		frmRegistroRetiro.getContentPane().add(scrollPane);
		
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
				"N\u00B0 Retiro", "N\u00B0 Matricula", "Alumno", "Curso", "Fecha", "Hora"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(156, 118, 137, 20);
		frmRegistroRetiro.getContentPane().add(btnConsultar);
	}

}
