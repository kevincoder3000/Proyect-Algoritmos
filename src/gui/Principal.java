package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import arreglos.ArregloAlumno;
import arreglos.ArregloCurso;
import arreglos.ArregloMatricula;
import arreglos.ArregloRetiro;

public class Principal {

	
	public static ArregloAlumno aa = new ArregloAlumno();
	public static ArregloCurso ac = new ArregloCurso();
	public static ArregloMatricula am = new ArregloMatricula();
	public static ArregloRetiro ar = new ArregloRetiro();

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

		// ---------- Mantenimiento ----------
		JMenu mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);

		JMenuItem mntmAlumno = new JMenuItem("Alumno");
		mntmAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MantenimientoAlumno().setVisible(true);
			}
		});
		mnMantenimiento.add(mntmAlumno);

		JMenuItem mntmCurso = new JMenuItem("Curso");
		mntmCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MantenimientoCurso().setVisible(true);
			}
		});
		mnMantenimiento.add(mntmCurso);

		// ---------- Registro ----------
		JMenu mnRegistro = new JMenu("Registro");
		menuBar.add(mnRegistro);

		JMenuItem mntmMatricula = new JMenuItem("Matr\u00EDcula");
		mntmMatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegistroMatricula().setVisible(true);
			}
		});
		mnRegistro.add(mntmMatricula);

		JMenuItem mntmRetiro = new JMenuItem("Retiro");
		
		mnRegistro.add(mntmRetiro);

		// ---------- Consulta ----------
		JMenu mnConsulta = new JMenu("Consulta");
		menuBar.add(mnConsulta);

		JMenuItem mntmAlumnosCursos = new JMenuItem("Alumnos y Cursos");
		mntmAlumnosCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ConsultaAlumnnosCursos().setVisible(true);
			}
		});
		mnConsulta.add(mntmAlumnosCursos);

		JMenuItem mntmMatriculasRetiros = new JMenuItem("Matr\u00EDculas y retiros");
		mntmMatriculasRetiros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ConsultaMatriculasRetiros().setVisible(true);
			}
		});
		mnConsulta.add(mntmMatriculasRetiros);

		// ---------- Reporte ----------
		JMenu mnReporte = new JMenu("Reporte");
		menuBar.add(mnReporte);

		JMenuItem mntmPendientes = new JMenuItem("Alumnos con matr\u00EDcula pendiente");
		mntmPendientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReportePendientes().setVisible(true);
			}
		});
		mnReporte.add(mntmPendientes);

		JMenuItem mntmVigentes = new JMenuItem("Alumnos con matr\u00EDcula vigente");
		mntmVigentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReporteVigentes().setVisible(true);
			}
		});
		mnReporte.add(mntmVigentes);

		JMenuItem mntmAlumnosPorCurso = new JMenuItem("Alumnos matriculados por curso");
		// Pendiente: ReporteAlumnosPorCurso
		mnReporte.add(mntmAlumnosPorCurso);
	}

}