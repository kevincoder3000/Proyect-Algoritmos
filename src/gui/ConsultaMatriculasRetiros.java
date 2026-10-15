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
import entidad.Retiro;

public class ConsultaMatriculasRetiros {

	private JFrame frmConsultaDeMatrculas;
	private JComboBox<String> cboTipoConsulta;
	private JTextField txtNumero;
	private JTable table;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaMatriculasRetiros window = new ConsultaMatriculasRetiros();
					window.frmConsultaDeMatrculas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConsultaMatriculasRetiros() {
		initialize();
	}

	// Permite abrir la ventana desde Principal: new ConsultaMatriculasRetiros().setVisible(true);
	public void setVisible(boolean visible) {
		frmConsultaDeMatrculas.setVisible(visible);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConsultaDeMatrculas = new JFrame();
		frmConsultaDeMatrculas.setTitle("Consulta de matrículas y retiros");
		frmConsultaDeMatrculas.setBounds(100, 100, 492, 347);
		frmConsultaDeMatrculas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmConsultaDeMatrculas.getContentPane().setLayout(null);

		JLabel lblTipoConsulta = new JLabel("Tipo de consulta");
		lblTipoConsulta.setBounds(20, 20, 110, 25);
		frmConsultaDeMatrculas.getContentPane().add(lblTipoConsulta);

		cboTipoConsulta = new JComboBox<String>();
		cboTipoConsulta.setModel(new DefaultComboBoxModel<String>(new String[] {"Matrículas", "Retiros"}));
		cboTipoConsulta.setBounds(140, 20, 170, 25);
		frmConsultaDeMatrculas.getContentPane().add(cboTipoConsulta);

		JLabel lblNumero = new JLabel("Número");
		lblNumero.setBounds(20, 55, 110, 25);
		frmConsultaDeMatrculas.getContentPane().add(lblNumero);

		txtNumero = new JTextField();
		txtNumero.setBounds(140, 55, 170, 25);
		frmConsultaDeMatrculas.getContentPane().add(txtNumero);
		txtNumero.setColumns(10);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultar();
			}
		});
		btnConsultar.setBounds(330, 55, 100, 25);
		frmConsultaDeMatrculas.getContentPane().add(btnConsultar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 90, 442, 170);
		frmConsultaDeMatrculas.getContentPane().add(scrollPane);

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
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmConsultaDeMatrculas.dispose();
			}
		});
		btnCerrar.setBounds(193, 274, 100, 25);
		frmConsultaDeMatrculas.getContentPane().add(btnCerrar);
	}

	

	// Consultar: busca por el número escrito, según el tipo elegido
	private void consultar() {
		modelo.setRowCount(0);

		int numero;
		try {
			numero = Integer.parseInt(txtNumero.getText().trim());
		} catch (NumberFormatException ex) {
			mensaje("Ingrese un número válido.");
			txtNumero.requestFocus();
			return;
		}

		if (cboTipoConsulta.getSelectedIndex() == 0) {
			consultarMatricula(numero);
		} else {
			consultarRetiro(numero);
		}
	}

	// Datos de la matrícula, del alumno y del curso
	private void consultarMatricula(int numMatricula) {
		Matricula m = Principal.am.buscar(numMatricula);
		if (m == null) {
			mensaje("No existe una matrícula con ese número.");
			txtNumero.requestFocus();
			return;
		}

		agregar("N° Matrícula", m.getNumMatricula());
		agregar("Fecha", m.getFecha());
		agregar("Hora", m.getHora());
		agregarAlumnoYCurso(m);
	}

	// Datos del retiro, del alumno y del curso (a través de su matrícula)
	private void consultarRetiro(int numRetiro) {
		Retiro r = Principal.ar.buscar(numRetiro);
		if (r == null) {
			mensaje("No existe un retiro con ese número.");
			txtNumero.requestFocus();
			return;
		}

		agregar("N° Retiro", r.getNumRetiro());
		agregar("N° Matrícula", r.getNumMatricula());
		agregar("Fecha", r.getFecha());
		agregar("Hora", r.getHora());

		Matricula m = Principal.am.buscar(r.getNumMatricula());
		if (m != null) {
			agregarAlumnoYCurso(m);
		}
	}

	// Agrega los datos completos del alumno y del curso de una matrícula
	private void agregarAlumnoYCurso(Matricula m) {
		Alumno a = Principal.aa.buscar(m.getCodAlumno());
		if (a != null) {
			agregar("--- Alumno ---", "");
			agregar("Código", a.getCodAlumno());
			agregar("Nombres", a.getNombres());
			agregar("Apellidos", a.getApellidos());
			agregar("DNI", a.getDni());
			agregar("Edad", a.getEdad());
			agregar("Celular", a.getCelular());
			agregar("Estado", a.estadoAlumno());
		}

		Curso c = Principal.ac.buscar(m.getCodCurso());
		if (c != null) {
			agregar("--- Curso ---", "");
			agregar("Código del curso", c.getCodCurso());
			agregar("Asignatura", c.getAsignatura());
			agregar("Ciclo", c.numCiclo());
			agregar("Créditos", c.getCreditos());
			agregar("Horas", c.getHora());
		}
	}

	private void agregar(String dato, Object valor) {
		modelo.addRow(new Object[] { dato, valor });
	}

	private void mensaje(String texto) {
		JOptionPane.showMessageDialog(frmConsultaDeMatrculas, texto);
	}
}