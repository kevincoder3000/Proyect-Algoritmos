package arreglos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import entidad.Curso;

public class ArregloCurso 
{	// Lista que almacena objetos de tipo Curso
	private ArrayList<Curso> cursos;

	// Constructor
	public ArregloCurso() 
	{cursos = new ArrayList<Curso>();}

	// Adiciona un curso si el c�digo es v�lido y no est� repetido
	public boolean adicionar(Curso curso) 
	{int codigo = curso.getCodCurso();

		// El c�digo debe tener cuatro d�gitos
		if (codigo < 1000 || codigo > 9999)
			{return false;}

		// El c�digo no debe estar repetido
		if (buscar(codigo) != null) 
		{return false;}
		cursos.add(curso);
		ordenar();
		return true;
	}

	// Retorna la cantidad de cursos
	public int tamanio() 
	{return cursos.size();}

	// Retorna un curso seg�n su posici�n
	public Curso obtener(int posicion) 
	{return cursos.get(posicion);}

	// Busca un curso por su c�digo
	public Curso buscar(int codCurso)
	{for (Curso curso : cursos) 
		{if (curso.getCodCurso() == codCurso) 
			{return curso;}}
		return null;
	}

	// Elimina un curso
	public void eliminar(Curso curso) 
	{cursos.remove(curso);}

	// Ordena los cursos de menor a mayor seg�n su c�digo
	private void ordenar() 
	{Collections.sort(cursos, new Comparator<Curso>() 
		{@Override
			public int compare(Curso curso1, Curso curso2) 
		{return Integer.compare(
						curso1.getCodCurso(),
						curso2.getCodCurso()
				);
			}
		});
	}
}