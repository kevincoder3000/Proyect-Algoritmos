package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidad.Alumno;

public class ReporteVigentes {

	private JFrame frmAlumnosConMa;
	private JTable table;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporteVigentes window = new ReporteVigentes();
					window.frmAlumnosConMa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ReporteVigentes() {
		initialize();
	}

	public void setVisible(boolean visible) {
		frmAlumnosConMa.setVisible(visible);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAlumnosConMa = new JFrame();
		frmAlumnosConMa.setTitle("Alumnos con matr\u00EDcula vigente");
		frmAlumnosConMa.setBounds(100, 100, 560, 300);
		
		frmAlumnosConMa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAlumnosConMa.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 526, 186);
		frmAlumnosConMa.getContentPane().add(scrollPane);

		// Tabla de solo lectura 
		modelo = new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"C\u00F3digo", "Nombres", "Apellidos", "DNI", "Edad", "Celular", "Estado"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		table = new JTable(modelo);
		scrollPane.setViewportView(table);

		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listar();
			}
		});
		btnListar.setBounds(156, 206, 100, 36);
		frmAlumnosConMa.getContentPane().add(btnListar);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAlumnosConMa.dispose();
			}
		});
		btnCerrar.setBounds(273, 206, 100, 36);
		frmAlumnosConMa.getContentPane().add(btnCerrar);
	}


	// Listar: alumnos con matrícula vigente, es decir, matriculados (estado 1)
	private void listar() {
		modelo.setRowCount(0);

		for (int i = 0; i < Principal.aa.tamaño(); i++) {
			Alumno a = Principal.aa.obtener(i);
			if (a.getEstado() == 1) {
				Object[] fila = { a.getCodAlumno(), a.getNombres(), a.getApellidos(),
						a.getDni(), a.getEdad(), a.getCelular(), a.estadoAlumno() };
				modelo.addRow(fila);
			}
		}

		if (modelo.getRowCount() == 0) {
			JOptionPane.showMessageDialog(frmAlumnosConMa,
					"No hay alumnos con matrícula vigente.");
		}
	}
}
