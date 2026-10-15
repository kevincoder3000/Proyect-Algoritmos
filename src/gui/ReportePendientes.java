package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidad.Alumno;

public class ReportePendientes {

	private JFrame frmAlumnosConMatrcula;
	private JTable table;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportePendientes window = new ReportePendientes();
					window.frmAlumnosConMatrcula.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ReportePendientes() {
		initialize();
	}

	public void setVisible(boolean visible) {
		frmAlumnosConMatrcula.setVisible(visible);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAlumnosConMatrcula = new JFrame();
		frmAlumnosConMatrcula.setFont(new Font("Arial", Font.BOLD, 13));
		frmAlumnosConMatrcula.setTitle("Alumnos con matr\u00EDcula pendiente");
		frmAlumnosConMatrcula.setBounds(100, 100, 560, 300);
		
		frmAlumnosConMatrcula.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAlumnosConMatrcula.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 526, 172);
		frmAlumnosConMatrcula.getContentPane().add(scrollPane);

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

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAlumnosConMatrcula.dispose();
			}
		});
		btnCerrar.setBounds(284, 205, 100, 36);
		frmAlumnosConMatrcula.getContentPane().add(btnCerrar);

		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listar();
			}
		});
		btnListar.setBounds(142, 205, 100, 36);
		frmAlumnosConMatrcula.getContentPane().add(btnListar);
	}


	// Listar: alumnos registrados que todavía no se han matriculado (estado 0)
	private void listar() {
		modelo.setRowCount(0);

		for (int i = 0; i < Principal.aa.tamaño(); i++) {
			Alumno a = Principal.aa.obtener(i);
			if (a.getEstado() == 0) {
				Object[] fila = { a.getCodAlumno(), a.getNombres(), a.getApellidos(),
						a.getDni(), a.getEdad(), a.getCelular(), a.estadoAlumno() };
				modelo.addRow(fila);
			}
		}

		if (modelo.getRowCount() == 0) {
			JOptionPane.showMessageDialog(frmAlumnosConMatrcula,
					"No hay alumnos con matrícula pendiente.");
		}
	}
}
