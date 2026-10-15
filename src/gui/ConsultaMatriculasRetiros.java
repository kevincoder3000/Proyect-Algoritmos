package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConsultaMatriculasRetiros {

	private JFrame frmConsultaDeMatrculas;
	private JTable table;

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
		
		JComboBox cboTipoConsulta = new JComboBox();
		cboTipoConsulta.setModel(new DefaultComboBoxModel(new String[] {"Matrículas", "Retiros"}));
		cboTipoConsulta.setBounds(140, 20, 170, 25);
		frmConsultaDeMatrculas.getContentPane().add(cboTipoConsulta);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(330, 20, 100, 25);
		frmConsultaDeMatrculas.getContentPane().add(btnConsultar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 61, 442, 203);
		frmConsultaDeMatrculas.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"No.", "C\u00F3digo", "Nombre", "Programa", "Periodo", "Fecha", "Estado"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(193, 274, 100, 25);
		frmConsultaDeMatrculas.getContentPane().add(btnCerrar);
	}

}
