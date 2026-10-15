package arreglos;

import java.util.ArrayList;

import entidad.Matricula;

public class ArregloMatricula {

	// Lista que almacena las matr�culas
	private ArrayList<Matricula> matriculas;

	// Constructor
	public ArregloMatricula() 
	{matriculas = new ArrayList<Matricula>();}

	// Adiciona una matr�cula si el alumno no est� matriculado
	public boolean adicionar(Matricula matricula) 
	{int codAlumno = matricula.getCodAlumno();

		// El alumno solamente puede matricularse una vez
		if (buscarPorAlumno(codAlumno) != null) 
		{return false;}

		matriculas.add(matricula);
		return true;
	}

	// Retorna la cantidad de matr�culas
	public int tamanio() 
	{return matriculas.size();}

	// Retorna una matr�cula seg�n su posici�n
	public Matricula obtener(int posicion) 
	{return matriculas.get(posicion);}

	// Busca una matr�cula por su n�mero
	public Matricula buscar(int numMatricula) 
	{for (Matricula matricula : matriculas) 
		{if (matricula.getNumMatricula() == numMatricula) 
		{return matricula;}}
		return null;
	}

	// Busca la matr�cula de un alumno
	public Matricula buscarPorAlumno(int codAlumno) 
	{for (Matricula matricula : matriculas) 
	{if (matricula.getCodAlumno() == codAlumno) 
		{return matricula;}}
		return null;
	}

	// Busca la primera matr�cula correspondiente a un curso
	public Matricula buscarPorCurso(int codCurso) 
	{for (Matricula matricula : matriculas) {
			if (matricula.getCodCurso() == codCurso) {
				return matricula;}}
		return null;
	}

	 // Modifica solamente el curso de una matr�cula
    public void modificarCurso(Matricula matricula, int nuevoCodCurso) 
    { matricula.setCodCurso(nuevoCodCurso);}
	
	// Elimina f�sicamente una matr�cula
	public void eliminar(Matricula matricula) 
	{matriculas.remove(matricula);}
}