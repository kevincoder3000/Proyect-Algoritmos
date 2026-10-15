package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entidad.Alumno;

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
	private DefaultTableModel modelo;

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
		listar();
	}


	public void setVisible(boolean visible) {
		frmMantenimientoAlumno.setVisible(visible);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMantenimientoAlumno = new JFrame();
		frmMantenimientoAlumno.setTitle("Mantenimiento de Alumnos");
		frmMantenimientoAlumno.setBounds(100, 100, 481, 305);
		// DISPOSE: al cerrar esta ventana no se cierra todo el programa
		frmMantenimientoAlumno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMantenimientoAlumno.getContentPane().setLayout(null);

		JLabel lblCodigo = new JLabel("C�digo:");
		lblCodigo.setBounds(22, 18, 90, 25);
		frmMantenimientoAlumno.getContentPane().add(lblCodigo);

		JLabel lblAlumno = new JLabel("Nombres:");
		lblAlumno.setBounds(22, 47, 60, 12);
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

		// El estado lo calcula el sistema
		txtEstado = new JTextField();
		txtEstado.setEditable(false);
		txtEstado.setColumns(10);
		txtEstado.setBounds(310, 66, 141, 18);
		frmMantenimientoAlumno.getContentPane().add(txtEstado);

		
		// ---------- Tabla ----------
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 152, 447, 106);
		frmMantenimientoAlumno.getContentPane().add(scrollPane);

		modelo = new DefaultTableModel();
		modelo.addColumn("C�digo");
		modelo.addColumn("Nombres");
		modelo.addColumn("Apellidos");
		modelo.addColumn("DNI");
		modelo.addColumn("Edad");
		modelo.addColumn("Celular");
		modelo.addColumn("Estado");

		table = new JTable(modelo);
		scrollPane.setViewportView(table);
	}

	// ================== L�GICA DE LOS BOTONES ==================

	// Adicionar: el c�digo y el estado los asigna el sistema
	private void adicionar() {
		if (!datosValidos()) return;

		String dni = txtDNI.getText().trim();
		if (Principal.aa.buscarDni(dni) != null) {
			mensaje("Ese DNI ya est� registrado.");
			txtDNI.requestFocus();
			return;
		}

		Alumno x = new Alumno(0,
				txtAlumno.getText().trim(),
				txtApellidos.getText().trim(),
				dni,
				Integer.parseInt(txtEdad.getText().trim()),
				Integer.parseInt(txtCelular.getText().trim()),
				0);
		Principal.aa.adicionar(x);

		listar();
		limpiar();
		mensaje("Alumno registrado con c�digo " + x.getCodAlumno());
	}

	// Consultar: busca por el c�digo escrito y muestra los datos
	private void consultar() {
		Alumno x = buscarPorCodigo();
		if (x == null) return;

		txtAlumno.setText(x.getNombres());
		txtApellidos.setText(x.getApellidos());
		txtDNI.setText(x.getDni());
		txtEdad.setText("" + x.getEdad());
		txtCelular.setText("" + x.getCelular());
		txtEstado.setText(x.estadoAlumno());
	}

	// Modificar: primero Consultar, cambia los datos y luego Modificar
	private void modificar() {
		Alumno x = buscarPorCodigo();
		if (x == null) return;
		if (!datosValidos()) return;

		String dni = txtDNI.getText().trim();
		Alumno otro = Principal.aa.buscarDni(dni);
		if (otro != null && otro != x) {
			mensaje("Ese DNI pertenece a otro alumno.");
			txtDNI.requestFocus();
			return;
		}

		x.setNombres(txtAlumno.getText().trim());
		x.setApellidos(txtApellidos.getText().trim());
		x.setDni(dni);
		x.setEdad(Integer.parseInt(txtEdad.getText().trim()));
		x.setCelular(Integer.parseInt(txtCelular.getText().trim()));

		listar();
		limpiar();
		mensaje("Alumno modificado.");
	}

	// Eliminar: pide confirmaci�n
	private void eliminar() {
		Alumno x = buscarPorCodigo();
		if (x == null) return;

		int r = JOptionPane.showConfirmDialog(frmMantenimientoAlumno,
				"�Eliminar a " + x.getNombres() + " " + x.getApellidos() + "?",
				"Confirmar", JOptionPane.YES_NO_OPTION);
		if (r == JOptionPane.YES_OPTION) {
			Principal.aa.eliminar(x);
			listar();
			limpiar();
		}
	}

	// ================== M�TODOS AUXILIARES ==================

	// Llena la tabla con todos los alumnos
	private void listar() {
		modelo.setRowCount(0);
		for (int i = 0; i < Principal.aa.tamanio(); i++) {
			Alumno x = Principal.aa.obtener(i);
			Object[] fila = { x.getCodAlumno(), x.getNombres(), x.getApellidos(),
					x.getDni(), x.getEdad(), x.getCelular(), x.estadoAlumno() };
			modelo.addRow(fila);
		}
	}

	// Limpia las cajas de texto
	private void limpiar() {
		txtCodigo.setText("");
		txtAlumno.setText("");
		txtApellidos.setText("");
		txtDNI.setText("");
		txtEdad.setText("");
		txtCelular.setText("");
		txtEstado.setText("");
		txtCodigo.requestFocus();
	}

	// Busca el alumno cuyo c�digo est� escrito en txtCodigo
	private Alumno buscarPorCodigo() {
		int codigo;
		try {
			codigo = Integer.parseInt(txtCodigo.getText().trim());
		} catch (NumberFormatException ex) {
			mensaje("Ingrese un c�digo v�lido.");
			txtCodigo.requestFocus();
			return null;
		}
		Alumno x = Principal.aa.buscar(codigo);
		if (x == null) {
			mensaje("No existe un alumno con ese c�digo.");
			txtCodigo.requestFocus();
		}
		return x;
	}

	// Revisa que los datos escritos sean correctos
	private boolean datosValidos() {
		if (txtAlumno.getText().trim().isEmpty()) {
			mensaje("Ingrese los nombres.");
			txtAlumno.requestFocus();
			return false;
		}
		if (txtApellidos.getText().trim().isEmpty()) {
			mensaje("Ingrese los apellidos.");
			txtApellidos.requestFocus();
			return false;
		}
		if (!txtDNI.getText().trim().matches("\\d{8}")) {
			mensaje("El DNI debe tener 8 d�gitos.");
			txtDNI.requestFocus();
			return false;
		}
		if (!txtEdad.getText().trim().matches("\\d{1,3}")) {
			mensaje("Ingrese una edad v�lida.");
			txtEdad.requestFocus();
			return false;
		}
		if (!txtCelular.getText().trim().matches("\\d{9}")) {
			mensaje("El celular debe tener 9 d�gitos.");
			txtCelular.requestFocus();
			return false;
		}
		return true;
	}

	private void mensaje(String texto) {
		JOptionPane.showMessageDialog(frmMantenimientoAlumno, texto);
	


//---------- Botones ----------
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
			}
		});
		btnAdicionar.setBounds(22, 124, 84, 20);
		frmMantenimientoAlumno.getContentPane().add(btnAdicionar);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultar();
			}
		});
		btnConsultar.setBounds(107, 124, 84, 20);
		frmMantenimientoAlumno.getContentPane().add(btnConsultar);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificar();
			}
		});
		btnModificar.setBounds(194, 124, 84, 20);
		frmMantenimientoAlumno.getContentPane().add(btnModificar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		btnEliminar.setBounds(280, 124, 84, 20);
		frmMantenimientoAlumno.getContentPane().add(btnEliminar);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMantenimientoAlumno.dispose();
			}
		});
		btnCerrar.setBounds(367, 124, 84, 20);
		frmMantenimientoAlumno.getContentPane().add(btnCerrar);
		}

}