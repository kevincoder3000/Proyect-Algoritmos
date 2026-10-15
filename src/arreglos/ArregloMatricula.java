package arreglos;

import java.util.ArrayList;

import entidad.Matricula;

public class ArregloMatricula {

	// Lista que almacena las matrículas
	private ArrayList<Matricula> matriculas;

	// Constructor
	public ArregloMatricula() 
	{matriculas = new ArrayList<Matricula>();}

	// Adiciona una matrícula si el alumno no está matriculado
	public boolean adicionar(Matricula matricula) 
	{int codAlumno = matricula.getCodAlumno();

		// El alumno solamente puede matricularse una vez
		if (buscarPorAlumno(codAlumno) != null) 
		{return false;}

		matriculas.add(matricula);
		return true;
	}

	// Retorna la cantidad de matrículas
	public int tamaño() 
	{return matriculas.size();}

	// Retorna una matrícula según su posición
	public Matricula obtener(int posicion) 
	{return matriculas.get(posicion);}

	// Busca una matrícula por su número
	public Matricula buscar(int numMatricula) 
	{for (Matricula matricula : matriculas) 
		{if (matricula.getNumMatricula() == numMatricula) 
		{return matricula;}}
		return null;
	}

	// Busca la matrícula de un alumno
	public Matricula buscarPorAlumno(int codAlumno) 
	{for (Matricula matricula : matriculas) 
	{if (matricula.getCodAlumno() == codAlumno) 
		{return matricula;}}
		return null;
	}

	// Busca la primera matrícula correspondiente a un curso
	public Matricula buscarPorCurso(int codCurso) 
	{for (Matricula matricula : matriculas) {
			if (matricula.getCodCurso() == codCurso) {
				return matricula;}}
		return null;
	}

	 // Modifica solamente el curso de una matrícula
    public void modificarCurso(Matricula matricula, int nuevoCodCurso) 
    { matricula.setCodCurso(nuevoCodCurso);}
	
	// Elimina físicamente una matrícula
	public void eliminar(Matricula matricula) 
	{matriculas.remove(matricula);}
}