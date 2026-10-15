package gui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MantenimientoCurso {

	private JFrame frmMantenimientoDeCursos;
	private JTextField txtCodigo;
	private JTextField txtAsignatura;
	private JTextField txtCiclo;
	private JTextField txtCreditos;
	private JTextField txtHoras;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantenimientoCurso window = new MantenimientoCurso();
					window.frmMantenimientoDeCursos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MantenimientoCurso() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMantenimientoDeCursos = new JFrame();
		frmMantenimientoDeCursos.setTitle("Mantenimiento de Cursos");
		frmMantenimientoDeCursos.setBounds(100, 100, 511, 335);
		frmMantenimientoDeCursos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMantenimientoDeCursos.getContentPane().setLayout(null);

		JLabel lblCodigo = new JLabel("Código:");
		lblCodigo.setBounds(30, 9, 44, 34);
		frmMantenimientoDeCursos.getContentPane().add(lblCodigo);

		JLabel lblAsignatura = new JLabel("Asignatura:");
		lblAsignatura.setBounds(30, 31, 68, 34);
		frmMantenimientoDeCursos.getContentPane().add(lblAsignatura);

		JLabel lblCiclo = new JLabel("Ciclo:");
		lblCiclo.setBounds(30, 64, 44, 12);
		frmMantenimientoDeCursos.getContentPane().add(lblCiclo);

		JLabel lblCreditos = new JLabel("Créditos:");
		lblCreditos.setBounds(30, 86, 68, 12);
		frmMantenimientoDeCursos.getContentPane().add(lblCreditos);

		JLabel lblHoras = new JLabel("Horas:");
		lblHoras.setBounds(30, 108, 44, 12);
		frmMantenimientoDeCursos.getContentPane().add(lblHoras);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(118, 17, 96, 18);
		frmMantenimientoDeCursos.getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);

		txtAsignatura = new JTextField();
		txtAsignatura.setBounds(118, 39, 252, 18);
		frmMantenimientoDeCursos.getContentPane().add(txtAsignatura);
		txtAsignatura.setColumns(10);

		txtCiclo = new JTextField();
		txtCiclo.setColumns(10);
		txtCiclo.setBounds(118, 61, 119, 18);
		frmMantenimientoDeCursos.getContentPane().add(txtCiclo);

		txtCreditos = new JTextField();
		txtCreditos.setColumns(10);
		txtCreditos.setBounds(118, 83, 119, 18);
		frmMantenimientoDeCursos.getContentPane().add(txtCreditos);

		txtHoras = new JTextField();
		txtHoras.setColumns(10);
		txtHoras.setBounds(118, 105, 119, 18);
		frmMantenimientoDeCursos.getContentPane().add(txtHoras);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(10, 140, 90, 20);
		frmMantenimientoDeCursos.getContentPane().add(btnAdicionar);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(105, 140, 90, 20);
		frmMantenimientoDeCursos.getContentPane().add(btnConsultar);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(201, 140, 90, 20);
		frmMantenimientoDeCursos.getContentPane().add(btnModificar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(295, 140, 90, 20);
		frmMantenimientoDeCursos.getContentPane().add(btnEliminar);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(394, 140, 90, 20);
		frmMantenimientoDeCursos.getContentPane().add(btnCerrar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 170, 474, 106);
		frmMantenimientoDeCursos.getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, },
				new String[] { "C\u00F3digo", "Asignatura", "Ciclo", "Cr\u00E9ditos", "Horas" }));
		scrollPane.setViewportView(table);
	}
}
