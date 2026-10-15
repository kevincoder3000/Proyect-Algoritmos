package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RegistroMatricula {

	private JFrame frmRegistroMatrcula;
	private JTextField txtNMatricula;
	private JTextField txtCodAlumno;
	private JTextField txtCodCurso;
	private JTextField txtHora;
	private JTextField txtFecha;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroMatricula window = new RegistroMatricula();
					window.frmRegistroMatrcula.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegistroMatricula() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistroMatrcula = new JFrame();
		frmRegistroMatrcula.setTitle("Registro de Matrícula");
		frmRegistroMatrcula.setBounds(100, 100, 511, 322);
		frmRegistroMatrcula.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistroMatrcula.getContentPane().setLayout(null);
		
		JLabel lblNMatricula = new JLabel("N° Matrícula");
		lblNMatricula.setBounds(25, 20, 91, 12);
		frmRegistroMatrcula.getContentPane().add(lblNMatricula);
		
		JLabel lblCdigoAlumno = new JLabel("Código alumno");
		lblCdigoAlumno.setBounds(25, 39, 91, 18);
		frmRegistroMatrcula.getContentPane().add(lblCdigoAlumno);
		
		JLabel lblCdigoCurso = new JLabel("Código curso");
		lblCdigoCurso.setBounds(25, 60, 91, 20);
		frmRegistroMatrcula.getContentPane().add(lblCdigoCurso);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(25, 108, 91, 12);
		frmRegistroMatrcula.getContentPane().add(lblFecha);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(25, 86, 91, 12);
		frmRegistroMatrcula.getContentPane().add(lblHora);
		
		txtNMatricula = new JTextField();
		txtNMatricula.setBounds(113, 17, 207, 18);
		frmRegistroMatrcula.getContentPane().add(txtNMatricula);
		txtNMatricula.setColumns(10);
		
		txtCodAlumno = new JTextField();
		txtCodAlumno.setColumns(10);
		txtCodAlumno.setBounds(113, 39, 207, 18);
		frmRegistroMatrcula.getContentPane().add(txtCodAlumno);
		
		txtCodCurso = new JTextField();
		txtCodCurso.setColumns(10);
		txtCodCurso.setBounds(113, 61, 207, 18);
		frmRegistroMatrcula.getContentPane().add(txtCodCurso);
		
		txtHora = new JTextField();
		txtHora.setColumns(10);
		txtHora.setBounds(113, 83, 120, 18);
		frmRegistroMatrcula.getContentPane().add(txtHora);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(113, 105, 120, 18);
		frmRegistroMatrcula.getContentPane().add(txtFecha);
		
		JButton btnMatricula = new JButton("Matrícular");
		btnMatricula.setBounds(10, 138, 91, 20);
		frmRegistroMatrcula.getContentPane().add(btnMatricula);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(106, 138, 91, 20);
		frmRegistroMatrcula.getContentPane().add(btnConsultar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(204, 138, 91, 20);
		frmRegistroMatrcula.getContentPane().add(btnModificar);
		
		JButton btnAnular = new JButton("Anular");
		btnAnular.setBounds(301, 138, 84, 20);
		frmRegistroMatrcula.getContentPane().add(btnAnular);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(395, 138, 84, 20);
		frmRegistroMatrcula.getContentPane().add(btnCerrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 168, 475, 108);
		frmRegistroMatrcula.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"N\u00B0 Matricula", "Alumno", "Curso", "Fecha", "Hora"
			}
		));
		scrollPane.setViewportView(table);
	}

}
