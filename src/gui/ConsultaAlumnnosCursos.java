package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConsultaAlumnnosCursos {

	private JFrame frmConsultaDeAlumnos;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaAlumnnosCursos window = new ConsultaAlumnnosCursos();
					window.frmConsultaDeAlumnos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConsultaAlumnnosCursos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConsultaDeAlumnos = new JFrame();
		frmConsultaDeAlumnos.setTitle("Consulta de alumnos y cursos");
		frmConsultaDeAlumnos.setBounds(100, 100, 516, 325);
		frmConsultaDeAlumnos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmConsultaDeAlumnos.getContentPane().setLayout(null);
		
		JLabel lblTipoConsulta = new JLabel("Tipo de consulta");
		lblTipoConsulta.setBounds(20, 20, 110, 25);
		frmConsultaDeAlumnos.getContentPane().add(lblTipoConsulta);
		
		JComboBox cboTipoConsulta = new JComboBox();
		cboTipoConsulta.setModel(new DefaultComboBoxModel(new String[] {"Alumnos", "Cursos"}));
		cboTipoConsulta.setBounds(140, 20, 170, 25);
		frmConsultaDeAlumnos.getContentPane().add(cboTipoConsulta);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(330, 20, 100, 25);
		frmConsultaDeAlumnos.getContentPane().add(btnConsultar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 55, 464, 189);
		frmConsultaDeAlumnos.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Nombre", "Apellidos", "Curso", "Correo electr\u00F3nico", "Tel\u00E9fono"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(210, 254, 100, 25);
		frmConsultaDeAlumnos.getContentPane().add(btnCerrar);
	}
}
