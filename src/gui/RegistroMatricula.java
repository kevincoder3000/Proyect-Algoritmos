package gui;

import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
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

public class RegistroMatricula {

	private JFrame frmRegistroMatrcula;
	private JTextField txtNMatricula;
	private JTextField txtCodAlumno;
	private JTextField txtCodCurso;
	private JTextField txtHora;
	private JTextField txtFecha;
	private JTable table;
	private DefaultTableModel modelo;

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
		listar();
	}

	// Permite abrir la ventana desde Principal: new RegistroMatricula().setVisible(true);
	public void setVisible(boolean visible) {
		frmRegistroMatrcula.setVisible(visible);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistroMatrcula = new JFrame();
		frmRegistroMatrcula.setTitle("Registro de Matrícula");
		frmRegistroMatrcula.setBounds(100, 100, 511, 322);
		// DISPOSE: al cerrar esta ventana no se cierra todo el programa
		frmRegistroMatrcula.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		txtHora.setEditable(false);
		txtHora.setBounds(113, 83, 120, 18);
		frmRegistroMatrcula.getContentPane().add(txtHora);

		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setEditable(false);
		txtFecha.setBounds(113, 105, 120, 18);
		frmRegistroMatrcula.getContentPane().add(txtFecha);

		// ---------- Botones ----------
		JButton btnMatricula = new JButton("Matricular");
		btnMatricula.setMargin(new Insets(0, 0, 0, 0));
		btnMatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				matricular();
			}
		});
		btnMatricula.setBounds(10, 138, 91, 20);
		frmRegistroMatrcula.getContentPane().add(btnMatricula);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setMargin(new Insets(0, 0, 0, 0));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultar();
			}
		});
		btnConsultar.setBounds(106, 138, 91, 20);
		frmRegistroMatrcula.getContentPane().add(btnConsultar);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.setMargin(new Insets(0, 0, 0, 0));
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificar();
			}
		});
		btnModificar.setBounds(204, 138, 91, 20);
		frmRegistroMatrcula.getContentPane().add(btnModificar);

		JButton btnAnular = new JButton("Anular");
		btnAnular.setMargin(new Insets(0, 0, 0, 0));
		btnAnular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anular();
			}
		});
		btnAnular.setBounds(301, 138, 84, 20);
		frmRegistroMatrcula.getContentPane().add(btnAnular);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setMargin(new Insets(0, 0, 0, 0));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRegistroMatrcula.dispose();
			}
		});
		btnCerrar.setBounds(395, 138, 84, 20);
		frmRegistroMatrcula.getContentPane().add(btnCerrar);

		// ---------- Tabla ----------
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 168, 475, 108);
		frmRegistroMatrcula.getContentPane().add(scrollPane);

		modelo = new DefaultTableModel();
		modelo.addColumn("N° Matrícula");
		modelo.addColumn("Alumno");
		modelo.addColumn("Curso");
		modelo.addColumn("Fecha");
		modelo.addColumn("Hora");

		table = new JTable(modelo);
		scrollPane.setViewportView(table);
	}

	// ================== LÓGICA DE LOS BOTONES ==================

	// Matricular: el número, la fecha y la hora los asigna el sistema
	private void matricular() {
		if (!txtCodAlumno.getText().trim().matches("\\d{9}")) {
			mensaje("El código de alumno debe tener 9 dígitos.");
			txtCodAlumno.requestFocus();
			return;
		}
		if (!txtCodCurso.getText().trim().matches("\\d{4}")) {
			mensaje("El código de curso debe tener 4 dígitos.");
			txtCodCurso.requestFocus();
			return;
		}
		int codAlumno = Integer.parseInt(txtCodAlumno.getText().trim());
		int codCurso = Integer.parseInt(txtCodCurso.getText().trim());

		Alumno a = Principal.aa.buscar(codAlumno);
		if (a == null) {
			mensaje("No existe un alumno con ese código.");
			txtCodAlumno.requestFocus();
			return;
		}
		Curso c = Principal.ac.buscar(codCurso);
		if (c == null) {
			mensaje("No existe un curso con ese código.");
			txtCodCurso.requestFocus();
			return;
		}
		if (Principal.am.buscarPorAlumno(codAlumno) != null) {
			mensaje("Ese alumno ya tiene una matrícula.");
			txtCodAlumno.requestFocus();
			return;
		}

		// Fecha y hora del sistema
		String fecha = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

		Matricula m = new Matricula(0, codAlumno, codCurso, fecha, hora);
		Principal.am.adicionar(m);
		a.setEstado(1); // Matriculado

		listar();
		limpiar();
		mensaje("Matrícula registrada con el número " + m.getNumMatricula());
	}

	// Consultar: busca por el N° de matrícula escrito
	private void consultar() {
		Matricula m = buscarPorNumero();
		if (m == null) return;

		txtCodAlumno.setText("" + m.getCodAlumno());
		txtCodCurso.setText("" + m.getCodCurso());
		txtFecha.setText(m.getFecha());
		txtHora.setText(m.getHora());
	}

	// Modificar: solo se puede cambiar el curso (en cualquier momento)
	private void modificar() {
		Matricula m = buscarPorNumero();
		if (m == null) return;

		if (!txtCodCurso.getText().trim().matches("\\d{4}")) {
			mensaje("El código de curso debe tener 4 dígitos.");
			txtCodCurso.requestFocus();
			return;
		}
		int codCurso = Integer.parseInt(txtCodCurso.getText().trim());
		if (Principal.ac.buscar(codCurso) == null) {
			mensaje("No existe un curso con ese código.");
			txtCodCurso.requestFocus();
			return;
		}

		Principal.am.modificarCurso(m, codCurso);

		listar();
		limpiar();
		mensaje("Matrícula modificada.");
	}

	// Anular: elimina la matrícula (con confirmación) y el alumno vuelve a "Registrado"
	private void anular() {
		Matricula m = buscarPorNumero();
		if (m == null) return;

		// Solo se puede anular si el alumno no está retirado (estado 2)
		Alumno alumno = Principal.aa.buscar(m.getCodAlumno());
		if (alumno != null && alumno.getEstado() == 2) {
			mensaje("No se puede anular: el alumno está retirado.");
			return;
		}

		int r = JOptionPane.showConfirmDialog(frmRegistroMatrcula,
				"¿Anular la matrícula " + m.getNumMatricula() + "?",
				"Confirmar", JOptionPane.YES_NO_OPTION);
		if (r == JOptionPane.YES_OPTION) {
			Principal.am.eliminar(m);
			Alumno a = Principal.aa.buscar(m.getCodAlumno());
			if (a != null) {
				a.setEstado(0); // Registrado
			}
			listar();
			limpiar();
		}
	}

	// ================== MÉTODOS AUXILIARES ==================

	// Llena la tabla con todas las matrículas (muestra nombres, no códigos)
	private void listar() {
		modelo.setRowCount(0);
		for (int i = 0; i < Principal.am.tamaño(); i++) {
			Matricula m = Principal.am.obtener(i);
			Alumno a = Principal.aa.buscar(m.getCodAlumno());
			Curso c = Principal.ac.buscar(m.getCodCurso());

			String alumno = (a != null) ? a.getNombres() + " " + a.getApellidos()
					: "" + m.getCodAlumno();
			String curso = (c != null) ? c.getAsignatura() : "" + m.getCodCurso();

			Object[] fila = { m.getNumMatricula(), alumno, curso,
					m.getFecha(), m.getHora() };
			modelo.addRow(fila);
		}
	}

	// Limpia las cajas de texto
	private void limpiar() {
		txtNMatricula.setText("");
		txtCodAlumno.setText("");
		txtCodCurso.setText("");
		txtHora.setText("");
		txtFecha.setText("");
		txtNMatricula.requestFocus();
	}

	// Busca la matrícula cuyo número está escrito en txtNMatricula
	private Matricula buscarPorNumero() {
		int numero;
		try {
			numero = Integer.parseInt(txtNMatricula.getText().trim());
		} catch (NumberFormatException ex) {
			mensaje("Ingrese un número de matrícula válido.");
			txtNMatricula.requestFocus();
			return null;
		}
		Matricula m = Principal.am.buscar(numero);
		if (m == null) {
			mensaje("No existe una matrícula con ese número.");
			txtNMatricula.requestFocus();
		}
		return m;
	}

	private void mensaje(String texto) {
		JOptionPane.showMessageDialog(frmRegistroMatrcula, texto);
	}
}