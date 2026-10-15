package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class ReporteVigentes {

	private JFrame frmAlumnosConMa;
	private JTable table;

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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAlumnosConMa = new JFrame();
		frmAlumnosConMa.setTitle("Alumnos con matr\u00EDcula vigente");
		frmAlumnosConMa.setBounds(100, 100, 450, 300);
		frmAlumnosConMa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAlumnosConMa.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 416, 186);
		frmAlumnosConMa.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, "", null, null, null},
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
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(101, 206, 100, 36);
		frmAlumnosConMa.getContentPane().add(btnListar);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(218, 206, 100, 36);
		frmAlumnosConMa.getContentPane().add(btnCerrar);
	}

}
