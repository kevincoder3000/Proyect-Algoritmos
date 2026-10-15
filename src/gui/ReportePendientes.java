package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ReportePendientes {

	private JFrame frmAlumnosConMatrcula;
	private JTable table;

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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAlumnosConMatrcula = new JFrame();
		frmAlumnosConMatrcula.setFont(new Font("Arial", Font.BOLD, 13));
		frmAlumnosConMatrcula.setTitle("Alumnos con matr\u00EDcula pendiente");
		frmAlumnosConMatrcula.setBounds(100, 100, 450, 300);
		frmAlumnosConMatrcula.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAlumnosConMatrcula.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 416, 172);
		frmAlumnosConMatrcula.getContentPane().add(scrollPane);
		
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
				"C\u00F3digo", "Nombres", "Apellidos", "DNI", "Estado"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(229, 205, 100, 36);
		frmAlumnosConMatrcula.getContentPane().add(btnCerrar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(87, 205, 100, 36);
		frmAlumnosConMatrcula.getContentPane().add(btnListar);
	}
}
