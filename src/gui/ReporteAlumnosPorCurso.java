package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ReporteAlumnosPorCurso {

	private JFrame frmAlumnosMatriculadosPor;
	private JTextField txtCodCurso;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporteAlumnosPorCurso window = new ReporteAlumnosPorCurso();
					window.frmAlumnosMatriculadosPor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ReporteAlumnosPorCurso() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAlumnosMatriculadosPor = new JFrame();
		frmAlumnosMatriculadosPor.setTitle("Alumnos matriculados por curso");
		frmAlumnosMatriculadosPor.setBounds(100, 100, 450, 300);
		frmAlumnosMatriculadosPor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAlumnosMatriculadosPor.getContentPane().setLayout(null);
		
		JLabel lblCodCurso = new JLabel("Código del curso");
		lblCodCurso.setBounds(23, 22, 104, 19);
		frmAlumnosMatriculadosPor.getContentPane().add(lblCodCurso);
		
		txtCodCurso = new JTextField();
		txtCodCurso.setBounds(131, 22, 138, 18);
		frmAlumnosMatriculadosPor.getContentPane().add(txtCodCurso);
		txtCodCurso.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(279, 21, 104, 20);
		frmAlumnosMatriculadosPor.getContentPane().add(btnConsultar);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(177, 233, 84, 20);
		frmAlumnosMatriculadosPor.getContentPane().add(btnCerrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 51, 416, 172);
		frmAlumnosMatriculadosPor.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"C\u00F3digo", "Nombres", "Apellidos", "DNI", "Curso"
			}
		));
		scrollPane.setViewportView(table);
	}

}
