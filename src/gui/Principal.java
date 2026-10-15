package gui;

import java.awt.EventQueue;
import arreglos.ArregloAlumno;
import arreglos.ArregloCurso;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal {
	public static ArregloAlumno aa = new ArregloAlumno();
	public static ArregloCurso ac = new ArregloCurso();
	
	private JFrame frmSistemaDeRegistro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmSistemaDeRegistro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSistemaDeRegistro = new JFrame();
		frmSistemaDeRegistro.setTitle("Sistema de Registro y Matr\u00EDcula");
		frmSistemaDeRegistro.setBounds(100, 100, 450, 300);
		frmSistemaDeRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmSistemaDeRegistro.setJMenuBar(menuBar);
		
		JMenu mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		
		
		JMenuItem mntmCurso = new JMenuItem("Curso");
		mntmCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MantenimientoCurso().setVisible(true);
			}
		});
		mnMantenimiento.add(mntmCurso);
		
		JMenu mnRegistro = new JMenu("Registro");
		menuBar.add(mnRegistro);
		
		JMenuItem mntmMatricula = new JMenuItem("Matr\u00EDcula");
		mnRegistro.add(mntmMatricula);
		
		JMenuItem mntmRetiro = new JMenuItem("Retiro");
		mnRegistro.add(mntmRetiro);
		
		JMenu mnConsulta = new JMenu("Consulta");
		menuBar.add(mnConsulta);
		
		JMenuItem mntmAlumno = new JMenuItem("Alumno");
		mntmAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MantenimientoAlumno().setVisible(true);
			}
		});
		mnMantenimiento.add(mntmAlumno);
		
		JMenuItem mntmMatriculasRetiros = new JMenuItem("Matr\u00EDculas y retiros");
		mnConsulta.add(mntmMatriculasRetiros);
		
		JMenu mnReporte = new JMenu("Reporte");
		menuBar.add(mnReporte);
		
		JMenuItem mntmPendientes = new JMenuItem("Alumnos con matr\u00EDcula pendiente");
		mnReporte.add(mntmPendientes);
		
		JMenuItem mntmVigentes = new JMenuItem("Alumnos con matr\u00EDcula vigente");
		mnReporte.add(mntmVigentes);
		
		JMenuItem mntmAlumnosPorCurso = new JMenuItem(" Alumnos matriculados por curso");
		mnReporte.add(mntmAlumnosPorCurso);
	}

}
