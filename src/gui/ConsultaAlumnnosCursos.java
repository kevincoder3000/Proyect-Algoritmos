package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entidad.Alumno;
import entidad.Curso;
import entidad.Matricula;

public class ConsultaAlumnnosCursos {

	private JFrame frmConsultaDeAlumnos;
	private JComboBox<String> cboTipoConsulta;
	private JTextField txtCodigo;
	private JTable table;
	private DefaultTableModel modelo;

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


	public void setVisible(boolean visible) {
		frmConsultaDeAlumnos.setVisible(visible);
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

		cboTipoConsulta = new JComboBox<String>();
		cboTipoConsulta.setModel(new DefaultComboBoxModel<String>(new String[] {"Alumnos", "Cursos"}));
		cboTipoConsulta.setBounds(140, 20, 170, 25);
		frmConsultaDeAlumnos.getContentPane().add(cboTipoConsulta);

		JLabel lblCodigo = new JLabel("Código");
		lblCodigo.setBounds(20, 55, 110, 25);
		frmConsultaDeAlumnos.getContentPane().add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(140, 55, 170, 25);
		frmConsultaDeAlumnos.getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultar();
			}
		});
		btnConsultar.setBounds(330, 55, 100, 25);
		frmConsultaDeAlumnos.getContentPane().add(btnConsultar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 90, 464, 150);
		frmConsultaDeAlumnos.getContentPane().add(scrollPane);

		// Tabla de solo lectura con dos columnas: Dato y Valor
		modelo = new DefaultTableModel(
			new Object[][] {},
			new String[] { "Dato", "Valor" }
		) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(modelo);
		scrollPane.setViewportView(table);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmConsultaDeAlumnos.dispose();
			}
		});
		btnCerrar.setBounds(210, 254, 100, 25);
		frmConsultaDeAlumnos.getContentPane().add(btnCerrar);
	}


	// Consultar: busca por el código escrito, según el tipo elegido
	private void consultar() {
		modelo.setRowCount(0);

		int codigo;
		try {
			codigo = Integer.parseInt(txtCodigo.getText().trim());
		} catch (NumberFormatException ex) {
			mensaje("Ingrese un código válido.");
			txtCodigo.requestFocus();
			return;
		}

		if (cboTipoConsulta.getSelectedIndex() == 0) {
			consultarAlumno(codigo);
		} else {
			consultarCurso(codigo);
		}
	}

	// Datos completos del alumno y, si está matriculado, los del curso
	private void consultarAlumno(int codigo) {
		Alumno a = Principal.aa.buscar(codigo);
		if (a == null) {
			mensaje("No existe un alumno con ese código.");
			txtCodigo.requestFocus();
			return;
		}

		agregar("Código", a.getCodAlumno());
		agregar("Nombres", a.getNombres());
		agregar("Apellidos", a.getApellidos());
		agregar("DNI", a.getDni());
		agregar("Edad", a.getEdad());
		agregar("Celular", a.getCelular());
		agregar("Estado", a.estadoAlumno());

		// Solo si está matriculado (estado 1) se muestran los datos del curso
		if (a.getEstado() == 1) {
			Matricula m = Principal.am.buscarPorAlumno(a.getCodAlumno());
			if (m != null) {
				Curso c = Principal.ac.buscar(m.getCodCurso());
				if (c != null) {
					agregar("--- Curso matriculado ---", "");
					agregarCurso(c);
				}
			}
		}
	}

	// Datos completos del curso
	private void consultarCurso(int codigo) {
		Curso c = Principal.ac.buscar(codigo);
		if (c == null) {
			mensaje("No existe un curso con ese código.");
			txtCodigo.requestFocus();
			return;
		}
		agregarCurso(c);
	}

	private void agregarCurso(Curso c) {
		agregar("Código del curso", c.getCodCurso());
		agregar("Asignatura", c.getAsignatura());
		agregar("Ciclo", c.numCiclo());
		agregar("Créditos", c.getCreditos());
		agregar("Horas", c.getHora());
	}

	private void agregar(String dato, Object valor) {
		modelo.addRow(new Object[] { dato, valor });
	}

	private void mensaje(String texto) {
		JOptionPane.showMessageDialog(frmConsultaDeAlumnos, texto);
	}
}