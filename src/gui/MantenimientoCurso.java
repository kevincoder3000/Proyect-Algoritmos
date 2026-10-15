package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entidad.Curso;

public class MantenimientoCurso {

	private JFrame frmMantenimientoDeCursos;
	private JTextField txtCodigo;
	private JTextField txtAsignatura;
	private JComboBox<String> cboCiclo;
	private JTextField txtCreditos;
	private JTextField txtHoras;
	private JTable table;
	private DefaultTableModel modelo;

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
		listar();
	}

	// Permite abrir la ventana desde Principal: new MantenimientoCurso().setVisible(true);
	public void setVisible(boolean visible) {
		frmMantenimientoDeCursos.setVisible(visible);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMantenimientoDeCursos = new JFrame();
		frmMantenimientoDeCursos.setTitle("Mantenimiento de Cursos");
		frmMantenimientoDeCursos.setBounds(100, 100, 511, 335);
		// DISPOSE: al cerrar esta ventana no se cierra todo el programa
		frmMantenimientoDeCursos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMantenimientoDeCursos.getContentPane().setLayout(null);

		JLabel lblCodigo = new JLabel("C�digo:");
		lblCodigo.setBounds(30, 9, 44, 34);
		frmMantenimientoDeCursos.getContentPane().add(lblCodigo);

		JLabel lblAsignatura = new JLabel("Asignatura:");
		lblAsignatura.setBounds(30, 31, 68, 34);
		frmMantenimientoDeCursos.getContentPane().add(lblAsignatura);

		JLabel lblCiclo = new JLabel("Ciclo:");
		lblCiclo.setBounds(30, 64, 44, 12);
		frmMantenimientoDeCursos.getContentPane().add(lblCiclo);

		JLabel lblCreditos = new JLabel("Cr�ditos:");
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

		// Combo de ciclo: la posici�n (0 a 5) es el n�mero que guarda Curso
		cboCiclo = new JComboBox<String>(new String[] {
				"Primero", "Segundo", "Tercero", "Cuarto", "Quinto", "Sexto" });
		cboCiclo.setBounds(118, 61, 119, 18);
		frmMantenimientoDeCursos.getContentPane().add(cboCiclo);

		txtCreditos = new JTextField();
		txtCreditos.setColumns(10);
		txtCreditos.setBounds(118, 83, 119, 18);
		frmMantenimientoDeCursos.getContentPane().add(txtCreditos);

		txtHoras = new JTextField();
		txtHoras.setColumns(10);
		txtHoras.setBounds(118, 105, 119, 18);
		frmMantenimientoDeCursos.getContentPane().add(txtHoras);

		// ---------- Botones ----------
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
			}
		});
		btnAdicionar.setBounds(10, 140, 90, 20);
		frmMantenimientoDeCursos.getContentPane().add(btnAdicionar);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultar();
			}
		});
		btnConsultar.setBounds(105, 140, 90, 20);
		frmMantenimientoDeCursos.getContentPane().add(btnConsultar);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificar();
			}
		});
		btnModificar.setBounds(201, 140, 90, 20);
		frmMantenimientoDeCursos.getContentPane().add(btnModificar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		btnEliminar.setBounds(295, 140, 90, 20);
		frmMantenimientoDeCursos.getContentPane().add(btnEliminar);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMantenimientoDeCursos.dispose();
			}
		});
		btnCerrar.setBounds(394, 140, 90, 20);
		frmMantenimientoDeCursos.getContentPane().add(btnCerrar);

		// ---------- Tabla ----------
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 170, 474, 106);
		frmMantenimientoDeCursos.getContentPane().add(scrollPane);

		modelo = new DefaultTableModel();
		modelo.addColumn("C�digo");
		modelo.addColumn("Asignatura");
		modelo.addColumn("Ciclo");
		modelo.addColumn("Cr�ditos");
		modelo.addColumn("Horas");

		table = new JTable(modelo);
		scrollPane.setViewportView(table);
	}

	// ================== L�GICA DE LOS BOTONES ==================

	// Adicionar: el c�digo se escribe y debe tener 4 d�gitos
	private void adicionar() {
		if (!txtCodigo.getText().trim().matches("\\d{4}")) {
			mensaje("El c�digo debe tener 4 d�gitos (1000 a 9999).");
			txtCodigo.requestFocus();
			return;
		}
		int codigo = Integer.parseInt(txtCodigo.getText().trim());

		if (Principal.ac.buscar(codigo) != null) {
			mensaje("Ese c�digo ya est� registrado.");
			txtCodigo.requestFocus();
			return;
		}
		if (!datosValidos()) return;

		Curso x = new Curso(codigo,
				txtAsignatura.getText().trim(),
				cboCiclo.getSelectedIndex(),
				Integer.parseInt(txtCreditos.getText().trim()),
				Integer.parseInt(txtHoras.getText().trim()));
		Principal.ac.adicionar(x);

		listar();
		limpiar();
		mensaje("Curso registrado.");
	}

	// Consultar: busca por el c�digo escrito y muestra los datos
	private void consultar() {
		Curso x = buscarPorCodigo();
		if (x == null) return;

		txtAsignatura.setText(x.getAsignatura());
		cboCiclo.setSelectedIndex(x.getCiclo());
		txtCreditos.setText("" + x.getCreditos());
		txtHoras.setText("" + x.getHora());
	}

	// Modificar: primero Consultar, cambia los datos y luego Modificar
	// (el c�digo no se puede cambiar)
	private void modificar() {
		Curso x = buscarPorCodigo();
		if (x == null) return;
		if (!datosValidos()) return;

		x.setAsignatura(txtAsignatura.getText().trim());
		x.setCiclo(cboCiclo.getSelectedIndex());
		x.setCreditos(Integer.parseInt(txtCreditos.getText().trim()));
		x.setHora(Integer.parseInt(txtHoras.getText().trim()));

		listar();
		limpiar();
		mensaje("Curso modificado.");
	}

	// Eliminar: pide confirmaci�n
	private void eliminar() {
		Curso x = buscarPorCodigo();
		if (x == null) return;

		int r = JOptionPane.showConfirmDialog(frmMantenimientoDeCursos,
				"�Eliminar el curso " + x.getAsignatura() + "?",
				"Confirmar", JOptionPane.YES_NO_OPTION);
		if (r == JOptionPane.YES_OPTION) {
			Principal.ac.eliminar(x);
			listar();
			limpiar();
		}
	}

	// ================== M�TODOS AUXILIARES ==================

	// Llena la tabla con todos los cursos
	private void listar() {
		modelo.setRowCount(0);
		for (int i = 0; i < Principal.ac.tamanio(); i++) {
			Curso x = Principal.ac.obtener(i);
			Object[] fila = { x.getCodCurso(), x.getAsignatura(), x.numCiclo(),
					x.getCreditos(), x.getHora() };
			modelo.addRow(fila);
		}
	}

	// Limpia las cajas de texto
	private void limpiar() {
		txtCodigo.setText("");
		txtAsignatura.setText("");
		cboCiclo.setSelectedIndex(0);
		txtCreditos.setText("");
		txtHoras.setText("");
		txtCodigo.requestFocus();
	}

	// Busca el curso cuyo c�digo est� escrito en txtCodigo
	private Curso buscarPorCodigo() {
		int codigo;
		try {
			codigo = Integer.parseInt(txtCodigo.getText().trim());
		} catch (NumberFormatException ex) {
			mensaje("Ingrese un c�digo v�lido.");
			txtCodigo.requestFocus();
			return null;
		}
		Curso x = Principal.ac.buscar(codigo);
		if (x == null) {
			mensaje("No existe un curso con ese c�digo.");
			txtCodigo.requestFocus();
		}
		return x;
	}

	// Revisa que los datos escritos sean correctos
	private boolean datosValidos() {
		if (txtAsignatura.getText().trim().isEmpty()) {
			mensaje("Ingrese la asignatura.");
			txtAsignatura.requestFocus();
			return false;
		}
		if (!txtCreditos.getText().trim().matches("\\d{1,2}")) {
			mensaje("Ingrese los cr�ditos (solo n�meros).");
			txtCreditos.requestFocus();
			return false;
		}
		if (!txtHoras.getText().trim().matches("\\d{1,2}")) {
			mensaje("Ingrese las horas (solo n�meros).");
			txtHoras.requestFocus();
			return false;
		}
		return true;
	}

	private void mensaje(String texto) {
		JOptionPane.showMessageDialog(frmMantenimientoDeCursos, texto);
	}
}